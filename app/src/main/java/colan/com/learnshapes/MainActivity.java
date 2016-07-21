package colan.com.learnshapes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import colan.com.learnshapes.common.SharedPref;
import colan.com.learnshapes.guesstheshape.GuessTheShapeActivity;
import colan.com.learnshapes.moregames.MoreGamesActivity;

public class MainActivity extends AppCompatActivity {

    private Button findShapes;
    private Button moreGames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findShapes = (Button) findViewById(R.id.find_shapes_button);
        moreGames = (Button) findViewById(R.id.more_games_button);

        findShapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, GuessTheShapeActivity.class);
                startActivity(intent);
            }
        });

        moreGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MoreGamesActivity.class);
                startActivity(intent);
            }
        });

    }

}
