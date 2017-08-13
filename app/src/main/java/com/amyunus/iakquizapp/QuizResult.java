package com.amyunus.iakquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by amyunus on 8/13/17.
 */

public class QuizResult extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        // Get value from previous intent and display it into screen
        TextView score = (TextView) findViewById(R.id.score);
        int scoreValue = getIntent().getIntExtra("score", 0);
        score.setText("" + scoreValue);

        //  Set on click listener on the button programmatically, not in the xml
        ImageView replay = (ImageView) findViewById(R.id.replay);
        replay.setOnClickListener(new View.OnClickListener() {


                                      @Override
                                      public void onClick(View view) {

                                          // Initiate intent to restart quiz
                                          Intent intent = new Intent(QuizResult.this, MainActivity.class);
                                          startActivity(intent);

                                      }
                                  }


        );
    }


}
