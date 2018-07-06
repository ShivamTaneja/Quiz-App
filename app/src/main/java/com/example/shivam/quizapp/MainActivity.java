package com.example.shivam.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_Android,btn_Cpp,btn_CoreJava,btn_Sql,btn_Xml;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Android = findViewById(R.id.btn_Android);
        btn_CoreJava = findViewById(R.id.btn_CoreJava);
        btn_Cpp = findViewById(R.id.btn_Cpp);
        btn_Sql = findViewById(R.id.btn_Sql);
        btn_Xml = findViewById(R.id.btn_Xml);

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

        btn_Cpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Cpp.class);
                startActivity(intent);

            }
        });

        btn_Sql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Sql.class);
                startActivity(intent);

            }
        });

        btn_Xml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Xml.class);
                startActivity(intent);

            }
        });
    }
}
