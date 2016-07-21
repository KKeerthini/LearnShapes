package colan.com.learnshapes.guesstheshape;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import colan.com.learnshapes.R;
import colan.com.learnshapes.common.ImageDecoding;

/**
 * Created by KEERTHINI on 7/18/2016.
 */

public class LevelUpDialog extends DialogFragment {

    Button btnDone;
    static String DialogboxTitle;

    public LevelUpDialog() {

    }

    public void setDialogTitle(String title) {
        DialogboxTitle = title;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.dialog_levelup, container);

        ImageView levelUpImage=(ImageView)view.findViewById(R.id.img_medal);
        levelUpImage.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(),R.drawable.star_medal,100,60));
        btnDone = (Button) view.findViewById(R.id.btn_dialog);
        btnDone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dismiss();
            }
        });

        getDialog().setTitle(DialogboxTitle);

        return view;
    }
}
