package colan.com.learnshapes.moregames;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import colan.com.learnshapes.R;

/**
 * Created by KEERTHINI on 7/20/2016.
 */

public class MoreGamesAdapter extends RecyclerView.Adapter<MoreGamesAdapter.MoreGamesViewHolder> {

    private ArrayList<DataModel> dataSet;

    public static class MoreGamesViewHolder extends RecyclerView.ViewHolder {

        TextView textViewAppName;
        ImageView imageViewIcon;

        public MoreGamesViewHolder(View itemView) {
            super(itemView);
            this.textViewAppName = (TextView) itemView.findViewById(R.id.appName);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public MoreGamesAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MoreGamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_moregames, parent, false);

        view.setOnClickListener(MoreGamesActivity.moreGamesClickListener);

        MoreGamesViewHolder moreGamesViewHolder = new MoreGamesViewHolder(view);
        return moreGamesViewHolder;
    }

    @Override
    public void onBindViewHolder(final MoreGamesViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewAppName;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getName());
        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}