package colan.com.learnshapes.guesstheshape;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import colan.com.learnshapes.MainActivity;
import colan.com.learnshapes.R;
import colan.com.learnshapes.common.Constants;
import colan.com.learnshapes.common.ImageDecoding;
import colan.com.learnshapes.common.SharedPref;

/**
 * Created by KEERTHINI on 7/18/2016.
 */

public class GuessTheShapeActivity extends AppCompatActivity {

    Context context;
    SharedPref sharedPref;
    ImageView firstLevelIv, secLevelIv, thirdLevelIv, fourthLevelIv, fifthLevelIv, sixthLevelIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_shape);

        firstLevelIv = (ImageView) findViewById(R.id.firstLevel);
        secLevelIv = (ImageView) findViewById(R.id.secLevel);
        thirdLevelIv = (ImageView) findViewById(R.id.thirdLevel);
        fourthLevelIv = (ImageView) findViewById(R.id.fourthLevel);
        fifthLevelIv = (ImageView) findViewById(R.id.fifthLevel);
        sixthLevelIv = (ImageView) findViewById(R.id.sixthLevel);

        firstLevelIv.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), R.drawable.star_medal, 25, 25));
        secLevelIv.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), R.drawable.star_medal, 25, 25));
        thirdLevelIv.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), R.drawable.star_medal, 25, 25));
        fourthLevelIv.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), R.drawable.star_medal, 25, 25));
        fifthLevelIv.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), R.drawable.star_medal, 25, 25));
        sixthLevelIv.setImageBitmap(ImageDecoding.decodeSampledBitmapFromResource(getResources(), R.drawable.star_medal, 25, 25));

        firstLevelIv.setVisibility(View.INVISIBLE);
        secLevelIv.setVisibility(View.INVISIBLE);
        thirdLevelIv.setVisibility(View.INVISIBLE);
        fourthLevelIv.setVisibility(View.INVISIBLE);
        fifthLevelIv.setVisibility(View.INVISIBLE);
        sixthLevelIv.setVisibility(View.INVISIBLE);

        context = getApplicationContext();
        sharedPref = new SharedPref(context);

      //  chooseFragment();

        sharedPref.setString(Constants.CURRENT_SHAPE, "oval");
        Bundle bundle = new Bundle();
        bundle.putString("currentShape", sharedPref.getString(Constants.CURRENT_SHAPE));

        GuessTheShapeFragment guessShapeDefault = new GuessTheShapeFragment();
        guessShapeDefault.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.mainLayout, guessShapeDefault).commit();

    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        finish();
    }

    public void generateImageView() {
        if (sharedPref.getInt(Constants.OVAL_COUNT) == 3) {
            firstLevelIv.setVisibility(View.VISIBLE);
        }
        if (sharedPref.getInt(Constants.RHOMBUS_COUNT) == 3) {
            secLevelIv.setVisibility(View.VISIBLE);
        }
        if (sharedPref.getInt(Constants.CIRCLE_COUNT) == 3) {
            thirdLevelIv.setVisibility(View.VISIBLE);
        }
        if (sharedPref.getInt(Constants.SQUARE_COUNT) == 3) {
            fourthLevelIv.setVisibility(View.VISIBLE);
        }
        if (sharedPref.getInt(Constants.TRIANGLE_COUNT) == 3) {
            fifthLevelIv.setVisibility(View.VISIBLE);
        }
        if (sharedPref.getInt(Constants.RECT_COUNT) == 3) {
            sixthLevelIv.setVisibility(View.VISIBLE);
        }

    }

    private void chooseFragment() {
        Bundle bundle = new Bundle();
        int levelKey = sharedPref.getInt(Constants.LEVEL_KEY);
        switch (levelKey) {
            default:
                sharedPref.setString(Constants.CURRENT_SHAPE, "oval");

                bundle.putString("currentShape", sharedPref.getString(Constants.CURRENT_SHAPE));

                GuessTheShapeFragment1 guessShapeDefault = new GuessTheShapeFragment1();
                guessShapeDefault.setArguments(bundle);

                getSupportFragmentManager().beginTransaction().add(R.id.mainLayout, guessShapeDefault).commit();
                break;
            case 1:
                firstLevelIv.setVisibility(View.VISIBLE);
                sharedPref.setString(Constants.CURRENT_SHAPE, "rhombus");

                bundle.putString("currentShape", sharedPref.getString(Constants.CURRENT_SHAPE));

                GuessTheShapeFragment4 guessShape4 = new GuessTheShapeFragment4();
                guessShape4.setArguments(bundle);

                getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, guessShape4).commit();
                break;
            case 2:
                firstLevelIv.setVisibility(View.VISIBLE);
                secLevelIv.setVisibility(View.VISIBLE);
                sharedPref.setString(Constants.CURRENT_SHAPE, "circle");
                bundle = new Bundle();
                bundle.putString("currentShape", sharedPref.getString(Constants.CURRENT_SHAPE));

                GuessTheShapeFragment7 guessShape7 = new GuessTheShapeFragment7();
                guessShape7.setArguments(bundle);

                getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, guessShape7).commit();
                break;
            case 3:
                firstLevelIv.setVisibility(View.VISIBLE);
                secLevelIv.setVisibility(View.VISIBLE);
                thirdLevelIv.setVisibility(View.VISIBLE);
                sharedPref.setString(Constants.CURRENT_SHAPE, "square");

                bundle.putString("currentShape", sharedPref.getString(Constants.CURRENT_SHAPE));

                GuessTheShapeFragment1 guessShape1 = new GuessTheShapeFragment1();
                guessShape1.setArguments(bundle);

                getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, guessShape1).commit();

                break;
            case 4:
                firstLevelIv.setVisibility(View.VISIBLE);
                secLevelIv.setVisibility(View.VISIBLE);
                thirdLevelIv.setVisibility(View.VISIBLE);
                fourthLevelIv.setVisibility(View.VISIBLE);
                sharedPref.setString(Constants.CURRENT_SHAPE, "triangle");

                bundle.putString("currentShape", sharedPref.getString(Constants.CURRENT_SHAPE));

                GuessTheShapeFragment4 guessShape = new GuessTheShapeFragment4();
                guessShape.setArguments(bundle);

                getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, guessShape).commit();
                break;
            case 5:
                firstLevelIv.setVisibility(View.VISIBLE);
                secLevelIv.setVisibility(View.VISIBLE);
                thirdLevelIv.setVisibility(View.VISIBLE);
                fourthLevelIv.setVisibility(View.VISIBLE);
                fifthLevelIv.setVisibility(View.VISIBLE);
                sharedPref.setString(Constants.CURRENT_SHAPE, "rect");
                bundle.putString("currentShape", sharedPref.getString(Constants.CURRENT_SHAPE));

                GuessTheShapeFragment2 guessShape2 = new GuessTheShapeFragment2();
                guessShape2.setArguments(bundle);

                getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, guessShape2).commit();

                break;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(GuessTheShapeActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
