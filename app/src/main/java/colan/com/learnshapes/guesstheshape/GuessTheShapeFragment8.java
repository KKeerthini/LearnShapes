package colan.com.learnshapes.guesstheshape;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import colan.com.learnshapes.R;
import colan.com.learnshapes.common.Constants;
import colan.com.learnshapes.common.ImageDecoding;
import colan.com.learnshapes.common.SharedPref;

/**
 * Created by KEERTHINI on 7/19/2016.
 */

public class GuessTheShapeFragment8 extends Fragment implements View.OnClickListener {
    Context context;
    private ImageView firstImage, secondImage, thirdImage;
    private String currentShape;
    private SharedPref sharedPref;

    private int[] imagesArray =new int[]{R.drawable.circle_coins,R.drawable.square_saltine,R.drawable.triangle_melon};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_guess_shape, container, false);
        context=getActivity();
        Bundle bundle = getArguments();
        currentShape = bundle.getString("currentShape");

        firstImage = (ImageView) view.findViewById(R.id.firstImage);
        firstImage.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), imagesArray[0], 150, 200));
        firstImage.setOnClickListener(this);

        secondImage = (ImageView) view.findViewById(R.id.secondImage);
        secondImage.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), imagesArray[1], 150, 200));
        secondImage.setOnClickListener(this);

        thirdImage = (ImageView) view.findViewById(R.id.thirdImage);
        thirdImage.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), imagesArray[2], 150, 200));
        thirdImage.setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.firstImage:
                if (("circle").equals(currentShape)) {
                    Toast.makeText(context, "Its a " + currentShape, Toast.LENGTH_SHORT).show();
                    sharedPref = new SharedPref(context);
                    sharedPref.setInt(Constants.CIRCLE_COUNT, sharedPref.getInt(Constants.CIRCLE_COUNT)+1);

                    Bundle bundle = new Bundle();
                    bundle.putString("currentShape", sharedPref.getString(Constants.CURRENT_SHAPE));

                    GuessTheShapeFragment9 guessShape = new GuessTheShapeFragment9();
                    guessShape.setArguments(bundle);

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, guessShape).commit();

                } else {
                    Toast.makeText(context, "Its not a " + currentShape, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.secondImage:
                if (("square").equals(currentShape)) {
                    Toast.makeText(context, "Its a " + currentShape, Toast.LENGTH_SHORT).show();
                    sharedPref = new SharedPref(context);
                    sharedPref.setInt(Constants.SQUARE_COUNT, sharedPref.getInt(Constants.SQUARE_COUNT)+1);

                    Bundle bundle = new Bundle();
                    bundle.putString("currentShape", sharedPref.getString(Constants.CURRENT_SHAPE));

                    GuessTheShapeFragment9 guessShape = new GuessTheShapeFragment9();
                    guessShape.setArguments(bundle);

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, guessShape).commit();

                } else {
                    Toast.makeText(context, "Its not a " + currentShape, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.thirdImage:
                if (("triangle").equals(currentShape)) {
                    Toast.makeText(context, "Its a " + currentShape, Toast.LENGTH_SHORT).show();
                    sharedPref = new SharedPref(context);
                    sharedPref.setInt(Constants.TRIANGLE_COUNT, sharedPref.getInt(Constants.TRIANGLE_COUNT) + 1);
                    if (sharedPref.getInt(Constants.TRIANGLE_COUNT) == 3) {
                        LevelUpDialog dialog = new LevelUpDialog();
                        dialog.setDialogTitle("Level Up");
                        dialog.show(getFragmentManager(), "dialog");

                        sharedPref.setInt(Constants.LEVEL_KEY, sharedPref.getInt(Constants.LEVEL_KEY) + 1);
                        GuessTheShapeActivity imgActivity = (GuessTheShapeActivity) getActivity();
                        imgActivity.generateImageView();
                        sharedPref.setString(Constants.CURRENT_SHAPE, "rect");
                        Bundle bundle = new Bundle();
                        bundle.putString("currentShape", sharedPref.getString(Constants.CURRENT_SHAPE));

                        GuessTheShapeFragment2 guessShape = new GuessTheShapeFragment2();
                        guessShape.setArguments(bundle);

                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, guessShape).commit();

                    }
                } else {
                    Toast.makeText(context, "Its not a " + currentShape, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }

    }

}


