package colan.com.learnshapes.guesstheshape;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import colan.com.learnshapes.R;
import colan.com.learnshapes.common.Constants;
import colan.com.learnshapes.common.ImageDecoding;
import colan.com.learnshapes.common.SharedPref;

/**
 * Created by KEERTHINI on 7/20/2016.
 */

public class GuessTheShapeFragment extends Fragment implements View.OnClickListener {

    Context context;
    private ImageView firstImage, secondImage, thirdImage;
    private String currentShape;
    SharedPref sharedPref;
    ArrayList completeImage;
    int[] currentShapeArray;
    int imageArraySize = 0;
    int currentImageSelected;
    int[] exactImageArray;

    private int[] imagesArray = new int[]{R.drawable.circle_cd, R.drawable.oval_mirror, R.drawable.square_cushion};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_guess_shape, container, false);
        context = getActivity();
        Bundle bundle = getArguments();
        currentShape = bundle.getString("currentShape");

        addImageArray();

        if (currentShape.equals("oval")) {
            currentShapeArray = DifferentShapes.OVAL.getDrawable();
        }

        for (int currentDrawable : currentShapeArray) {
            for (int currentImageArray : (int[]) completeImage.get(imageArraySize)) {
                if (currentDrawable == currentImageArray) {
                    currentImageSelected = currentDrawable;
                }
            }
        }

        exactImageArray = (int[]) completeImage.get(imageArraySize);


        firstImage = (ImageView) view.findViewById(R.id.firstImage);
        firstImage.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), exactImageArray[0], 150, 200));
        firstImage.setOnClickListener(this);

        secondImage = (ImageView) view.findViewById(R.id.secondImage);
        secondImage.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), exactImageArray[1], 150, 200));
        secondImage.setOnClickListener(this);

        thirdImage = (ImageView) view.findViewById(R.id.thirdImage);
        thirdImage.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), exactImageArray[2], 150, 200));
        thirdImage.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.firstImage:
                if (currentImageSelected == exactImageArray[0]) {
                    Toast.makeText(context, "One fragment" + currentImageSelected, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Not" + currentImageSelected, Toast.LENGTH_SHORT).show();
                }
              /*  if (("rectangle").equals(currentShape)) {
                    Toast.makeText(context, "Its a " + currentShape, Toast.LENGTH_SHORT).show();
                    sharedPref=new SharedPref(context);
                    sharedPref.setInt(Constants.RECT_COUNT,sharedPref.getInt(Constants.RECT_COUNT)+1);

                    Bundle bundle = new Bundle();
                    bundle.putString("currentShape", sharedPref.getString(Constants.CURRENT_SHAPE));

                    GuessTheShapeFragment8 guessShape = new GuessTheShapeFragment8();
                    guessShape.setArguments(bundle);

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, guessShape).commit();
                } else {
                    Toast.makeText(context, "Its not a " + currentShape, Toast.LENGTH_SHORT).show();
                }*/
                break;
            case R.id.secondImage:
                if (currentImageSelected == exactImageArray[1]) {
                    Toast.makeText(context, "One fragment" + currentImageSelected, Toast.LENGTH_SHORT).show();
                    sharedPref = new SharedPref(context);
                    sharedPref.setInt(Constants.OVAL_COUNT,Constants.OVAL_GET_COUNT);
                    Toast.makeText(context, "Its a " + currentShape, Toast.LENGTH_SHORT).show();
                    sharedPref.setInt(Constants.OVAL_COUNT,sharedPref.getInt(Constants.OVAL_COUNT)+1);
                    imageArraySize++;
                    Bundle bundle = new Bundle();
                    bundle.putString("currentShape", sharedPref.getString(Constants.CURRENT_SHAPE));

                    GuessTheShapeFragment guessShapeDefault = new GuessTheShapeFragment();
                    guessShapeDefault.setArguments(bundle);

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, guessShapeDefault).commit();

                } else {
                    Toast.makeText(context, "Not" + currentImageSelected, Toast.LENGTH_SHORT).show();
                }
               /* if (("oval").equals(currentShape)) {
                    sharedPref = new SharedPref(context);
                    sharedPref.setInt(Constants.OVAL_COUNT,Constants.OVAL_GET_COUNT);
                    Toast.makeText(context, "Its a " + currentShape, Toast.LENGTH_SHORT).show();
                    sharedPref.setInt(Constants.OVAL_COUNT,sharedPref.getInt(Constants.OVAL_COUNT)+1);

                    Bundle bundle = new Bundle();
                    bundle.putString("currentShape", sharedPref.getString(Constants.CURRENT_SHAPE));

                    GuessTheShapeFragment2 guessShape = new GuessTheShapeFragment2();
                    guessShape.setArguments(bundle);

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, guessShape).commit();

                } else {
                    Toast.makeText(context, "Its not a " + currentShape, Toast.LENGTH_SHORT).show();
                }*/
                break;
            case R.id.thirdImage:
                if (currentImageSelected == exactImageArray[2]) {
                    Toast.makeText(context, "One fragment" + currentImageSelected, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Not" + currentImageSelected, Toast.LENGTH_SHORT).show();
                }
                /*if (("square").equals(currentShape)) {

                    sharedPref = new SharedPref(context);
                    sharedPref.setInt(Constants.SQUARE_COUNT,Constants.SQUARE_GET_COUNT);
                    Toast.makeText(context, "Its a " + currentShape, Toast.LENGTH_SHORT).show();
                    sharedPref.setInt(Constants.SQUARE_COUNT,sharedPref.getInt(Constants.SQUARE_COUNT)+1);

                    Bundle bundle = new Bundle();
                    bundle.putString("currentShape", sharedPref.getString(Constants.CURRENT_SHAPE));

                    GuessTheShapeFragment8 guessShape = new GuessTheShapeFragment8();
                    guessShape.setArguments(bundle);

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, guessShape).commit();

                } else {
                    Toast.makeText(context, "Its not a " + currentShape, Toast.LENGTH_SHORT).show();
                }*/
                break;
            default:
                break;
        }

    }

    private void addImageArray() {
        int[] imagesArray1 = new int[]{R.drawable.circle_cd, R.drawable.oval_mirror, R.drawable.square_cushion};
        int[] imagesArray2 = new int[]{R.drawable.circle_coins, R.drawable.oval_ruby, R.drawable.rect_creditcard};
        int[] imagesArray3 = new int[]{R.drawable.oval_coin, R.drawable.rect_mobile, R.drawable.circle_ball};
        completeImage = new ArrayList();
        completeImage.add(imagesArray1);
        completeImage.add(imagesArray2);
        completeImage.add(imagesArray3);

    }

}
