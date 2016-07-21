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
    int incrementCurrentShape = 0;


    private int[] imagesArray = new int[]{R.drawable.circle_cd, R.drawable.oval_mirror, R.drawable.square_cushion};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_guess_shape, container, false);
        context = getActivity();
        sharedPref = new SharedPref(context);
        Bundle bundle = getArguments();
        currentShape = bundle.getString("currentShape");
        sharedPref.setInt(Constants.OVAL_COUNT, Constants.OVAL_GET_COUNT);
        addImageArray();
        findingCorrectImage();

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
                    Toast.makeText(context, "Its a " + currentShape, Toast.LENGTH_SHORT).show();
                    sharedPref.setInt(Constants.OVAL_COUNT,  Constants.OVAL_GET_COUNT++ );
                    imageArraySize++;

                    if (sharedPref.getInt(Constants.OVAL_COUNT) % 3 == 0) {
                        sharedPref.setString(Constants.CURRENT_SHAPE, Constants.SHAPES_ARRAY[incrementCurrentShape++]);
                        currentShape = sharedPref.getString(Constants.CURRENT_SHAPE);

                    }
                    changeImageViews();
                    findingCorrectImage();


                } else {
                    Toast.makeText(context, "Not" + currentImageSelected, Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.secondImage:
                if (currentImageSelected == exactImageArray[1]) {
                    Toast.makeText(context, "One fragment" + currentImageSelected, Toast.LENGTH_SHORT).show();
                    Toast.makeText(context, "Its a " + currentShape, Toast.LENGTH_SHORT).show();
                    sharedPref.setInt(Constants.OVAL_COUNT, Constants.OVAL_GET_COUNT++ );
                    imageArraySize++;


                    if (sharedPref.getInt(Constants.OVAL_COUNT) % 3 == 0) {
                        sharedPref.setString(Constants.CURRENT_SHAPE, Constants.SHAPES_ARRAY[incrementCurrentShape++]);
                        currentShape = sharedPref.getString(Constants.CURRENT_SHAPE);
                    }
                    changeImageViews();
                    findingCorrectImage();

                } else {
                    Toast.makeText(context, "Not" + currentImageSelected, Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.thirdImage:
                if (currentImageSelected == exactImageArray[2]) {
                    Toast.makeText(context, "One fragment" + currentImageSelected, Toast.LENGTH_SHORT).show();
                    Toast.makeText(context, "Its a " + currentShape, Toast.LENGTH_SHORT).show();
                    sharedPref.setInt(Constants.OVAL_COUNT, Constants.OVAL_GET_COUNT++);
                    imageArraySize++;

                    if (sharedPref.getInt(Constants.OVAL_COUNT) % 3 == 0) {
                        sharedPref.setString(Constants.CURRENT_SHAPE, Constants.SHAPES_ARRAY[incrementCurrentShape++]);
                        currentShape = sharedPref.getString(Constants.CURRENT_SHAPE);
                    }
                    changeImageViews();
                    findingCorrectImage();

                } else {
                    Toast.makeText(context, "Not" + currentImageSelected, Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                break;
        }

    }

    private void addImageArray() {
        int[] imagesArray1 = new int[]{R.drawable.circle_cd, R.drawable.oval_mirror, R.drawable.square_cushion};
        int[] imagesArray2 = new int[]{R.drawable.circle_coins, R.drawable.oval_ruby, R.drawable.rect_creditcard};
        int[] imagesArray3 = new int[]{R.drawable.oval_coin, R.drawable.rect_mobile, R.drawable.circle_ball};
        int[] imagesArray4 =new int[]{R.drawable.triangle_billiards,R.drawable.circle_coins,R.drawable.rhombus_kite};
        int[] imagesArray5 = new int[]{R.drawable.rect_diary, R.drawable.rhombus_sign, R.drawable.circle_coins};
        int[] imagesArray6 = new int[]{R.drawable.rhombus_search, R.drawable.rect_mobile, R.drawable.circle_cd};
        int[] imagesArray7 =new int[]{R.drawable.triangle_riskwarning,R.drawable.circle_ball,R.drawable.rect_diary};
        int[] imagesArray8 =new int[]{R.drawable.circle_coins,R.drawable.square_saltine,R.drawable.triangle_melon};
        int[] imagesArray9 = new int[]{R.drawable.square_chess, R.drawable.rect_diary, R.drawable.circle_cd};
        completeImage = new ArrayList();
        completeImage.add(imagesArray1);
        completeImage.add(imagesArray2);
        completeImage.add(imagesArray3);
        completeImage.add(imagesArray4);
        completeImage.add(imagesArray5);
        completeImage.add(imagesArray6);
        completeImage.add(imagesArray7);
        completeImage.add(imagesArray8);
        completeImage.add(imagesArray9);


    }

    private void changeImageViews() {
        exactImageArray = (int[]) completeImage.get(imageArraySize);

        firstImage.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), exactImageArray[0], 150, 200));
        firstImage.setOnClickListener(this);

        secondImage.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), exactImageArray[1], 150, 200));
        secondImage.setOnClickListener(this);

        thirdImage.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), exactImageArray[2], 150, 200));
        thirdImage.setOnClickListener(this);

    }

    private void findingCorrectImage() {
        if (currentShape.equals("oval")) {
            currentShapeArray = DifferentShapes.OVAL.getDrawable();
        }
       else if (currentShape.equals("rhombus")) {
            currentShapeArray = DifferentShapes.RHOMBUS.getDrawable();
        }

        for (int currentDrawable : currentShapeArray) {
            for (int currentImageArray : (int[]) completeImage.get(imageArraySize)) {
                if (currentDrawable == currentImageArray) {
                    currentImageSelected = currentDrawable;
                }
            }
        }
        exactImageArray = (int[]) completeImage.get(imageArraySize);
    }
}
