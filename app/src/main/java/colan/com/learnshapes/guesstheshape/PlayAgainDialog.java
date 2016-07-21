package colan.com.learnshapes.guesstheshape;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import colan.com.learnshapes.R;
import colan.com.learnshapes.common.ImageDecoding;
import colan.com.learnshapes.common.SharedPref;

/**
 * Created by KEERTHINI on 7/20/2016.
 */

public class PlayAgainDialog extends DialogFragment {

    Button btnDone;
    static String DialogboxTitle;
    SharedPref sharedPref;
    private Context context;

    public PlayAgainDialog( ) {

    }

    public void setDialogTitle(Context context,String title) {

        DialogboxTitle = title;
        this.context=context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.dialog_play_again, container);

        ImageView levelUpImage = (ImageView) view.findViewById(R.id.badge);
        levelUpImage.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), R.drawable.badge, 100, 60));
        btnDone = (Button) view.findViewById(R.id.playAgain);
        btnDone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sharedPref = new SharedPref(context);
                sharedPref.clearAll();
                Intent intent = new Intent(context, GuessTheShapeActivity.class);
                startActivity(intent);
                dismiss();

            }
        });

        getDialog().setTitle(DialogboxTitle);

        return view;
    }
}
