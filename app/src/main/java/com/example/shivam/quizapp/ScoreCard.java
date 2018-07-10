package com.example.shivam.quizapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreCard extends AppCompatActivity {

    TextView a1, a2, a3, a4, a5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SharedPreferences sharedPreferences = getSharedPreferences("Score", Context.MODE_PRIVATE);
        a1 = (TextView) findViewById(R.id.android);
        /**/
        try {
            a1.setText("" + sharedPreferences.getInt("Android", 0));
        } catch (Exception e) {
            Toast.makeText(ScoreCard.this, "" + e, Toast.LENGTH_SHORT).show();
        }


        }
}
