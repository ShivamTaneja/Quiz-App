package com.example.shivam.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("intVariableName", 0);

        tv = findViewById(R.id.tv);
        tv.setText("You Scored " + intValue );
    }
}
