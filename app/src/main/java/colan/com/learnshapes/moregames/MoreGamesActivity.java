package colan.com.learnshapes.moregames;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import colan.com.learnshapes.R;

/**
 * Created by KEERTHINI on 7/20/2016.
 */

public class MoreGamesActivity extends Activity {

    private Context context;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    static View.OnClickListener moreGamesClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_games);

        recyclerView = (RecyclerView) findViewById(R.id.more_games_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MoreGamesAppData.nameArray.length; i++) {
            data.add(new DataModel(MoreGamesAppData.nameArray[i], MoreGamesAppData.id[i], MoreGamesAppData.drawableArray[i]
            ));
        }

        adapter = new MoreGamesAdapter(data);
        recyclerView.setAdapter(adapter);
        moreGamesClickListener = new MoreGameOnClick(context);
    }


    private class MoreGameOnClick implements View.OnClickListener {

        private final Context context;

        private MoreGameOnClick(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {

            moveToPlayStore(v);
        }

        private void moveToPlayStore(View v) {
            int selectedItemPosition = recyclerView.getChildLayoutPosition(v);
            final String appPackageName = MoreGamesAppData.appPackageName[selectedItemPosition]; // getPackageName()
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }

        }
    }
}
