package com.amyunus.iakquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by amyunus on 8/13/17.
 */

public class Quiz2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz2);

        //  Set on click listener on the button programmatically, not in the xml
        Button btnQ2 = (Button) findViewById(R.id.btnQ2);
        btnQ2.setOnClickListener(new View.OnClickListener() {


                                     @Override
                                     public void onClick(View view) {

                                         // Initiate all checkbox
                                         CheckBox q2a1 = (CheckBox) findViewById(R.id.q2a1);
                                         CheckBox q2a2 = (CheckBox) findViewById(R.id.q2a2);
                                         CheckBox q2a3 = (CheckBox) findViewById(R.id.q2a3);
                                         CheckBox q2a4 = (CheckBox) findViewById(R.id.q2a4);

                                         // Checking if not 2 items of checkbox are checked, process will not be continued
                                         if (checkedBox(q2a1, q2a2, q2a3, q2a4) == 2) {

                                             // Get intent from previous intent
                                             int scoreQ1 = getIntent().getIntExtra("score", 0);

                                             // Initiate intent and passing value to the next intent
                                             Intent intent = new Intent(Quiz2.this, Quiz3.class);
                                             intent.putExtra("score", (scoreQ1 + calculateScoreQ2()));
                                             startActivity(intent);

                                         } else {
                                             Toast.makeText(Quiz2.this, R.string.q2warning, Toast.LENGTH_SHORT).show();
                                         }
                                     }
                                 }


        );
    }


    /*
     * function that returns check how many items of checkbox are checked
     * else checked is 0 by default
     */
    private int checkedBox(CheckBox q2a1, CheckBox q2a2, CheckBox q2a3, CheckBox q2a4) {

        int checked = 0;

        if (q2a1.isChecked()) {
            checked += 1;
        }
        if (q2a2.isChecked()) {
            checked += 1;
        }
        if (q2a3.isChecked()) {
            checked += 1;
        }
        if (q2a4.isChecked()) {
            checked += 1;
        }

        return checked;
    }

    /*
     * function to calculate score on question number 2
     * return the score if correct option is checked
     * else score is 0 by default
     */
    private int calculateScoreQ2() {

        CheckBox q2a1 = (CheckBox) findViewById(R.id.q2a1);
        CheckBox q2a2 = (CheckBox) findViewById(R.id.q2a2);

        int score = 0;
        if (q2a1.isChecked() && q2a2.isChecked()) {
            score += 10;
        }

        return score;
    }


}
