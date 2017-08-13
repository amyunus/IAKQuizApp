package com.amyunus.iakquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by amyunus on 8/13/17.
 */

public class Quiz3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz3);

        //  Setting the input text
        EditText q3a = (EditText) findViewById(R.id.q3a);
        q3a.setHint(R.string.q3hint);

        //  Set on click listener on the button programmatically, not in the xml
        Button btnQ3 = (Button) findViewById(R.id.btnQ3);
        btnQ3.setOnClickListener(new View.OnClickListener() {


                                     @Override
                                     public void onClick(View view) {
                                         EditText q3a = (EditText) findViewById(R.id.q3a);
                                         String answer = q3a.getText().toString();

                                         // Checking whether answer is not empty
                                         if (!answer.isEmpty()) {

                                             // Get intent from previous intent
                                             int scoreQ3 = getIntent().getIntExtra("score", 0);

                                             // Initiate intent and passing value to the next intent
                                             Intent intent = new Intent(Quiz3.this, QuizResult.class);
                                             intent.putExtra("score", (scoreQ3 + calculateScoreQ3(answer)));
                                             startActivity(intent);

                                         } else {
                                             Toast.makeText(Quiz3.this, R.string.q3warning, Toast.LENGTH_SHORT).show();
                                         }

                                     }
                                 }


        );
    }


    /*
     * function to calculate score on question number 3
     * return the score if answer is correct
     * else score is 0 by default
     */
    private int calculateScoreQ3(String answer) {
        int score = 0;

        if (answer.equalsIgnoreCase("iak")) {
            score += 10;
        }

        return score;
    }
}
