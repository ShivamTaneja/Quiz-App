package com.example.shivam.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_Android,btn_CoreJava;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Android = findViewById(R.id.btn_Android);
        btn_CoreJava = findViewById(R.id.btn_CoreJava);

        btn_Android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Android.class);
                startActivity(intent);

            }
        });

        btn_CoreJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,CoreJava.class);
                startActivity(intent);

            }
        });

    }
}
