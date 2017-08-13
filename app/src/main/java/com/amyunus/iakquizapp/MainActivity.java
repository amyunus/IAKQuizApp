package com.amyunus.iakquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Set on click listener on the button programmatically, not in the xml
        Button btnQ1 = (Button) findViewById(R.id.btnQ1);
        btnQ1.setOnClickListener(new View.OnClickListener() {


                                     @Override
                                     public void onClick(View view) {

                                         // Initiate all radio button
                                         RadioButton q1a1 = (RadioButton) findViewById(R.id.q1a1);
                                         RadioButton q1a2 = (RadioButton) findViewById(R.id.q1a2);
                                         RadioButton q1a3 = (RadioButton) findViewById(R.id.q1a3);
                                         RadioButton q1a4 = (RadioButton) findViewById(R.id.q1a4);

                                         // Checking if none of any radio button is checked, process will not be continued
                                         if (q1a1.isChecked() || q1a2.isChecked() | q1a3.isChecked() | q1a4.isChecked()) {

                                             // Initiate intent and passing value to the next intent
                                             Intent intent = new Intent(MainActivity.this, Quiz2.class);
                                             intent.putExtra("score", calculateScoreQ1());
                                             startActivity(intent);

                                         } else {
                                             Toast.makeText(MainActivity.this, R.string.q1warning, Toast.LENGTH_SHORT).show();
                                         }
                                     }
                                 }


        );
    }


    /*
     * function to calculate score on question number 1
     * return the score if correct option is checked
     * else score is 0 by default
     */
    private int calculateScoreQ1() {

        RadioButton q1a1 = (RadioButton) findViewById(R.id.q1a1);

        int score = 0;
        if (q1a1.isChecked()) {
            score += 10;
        }

        return score;
    }


}