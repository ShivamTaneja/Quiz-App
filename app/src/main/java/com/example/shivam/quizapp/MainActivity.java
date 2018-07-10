    package com.example.shivam.quizapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
           implements NavigationView.OnNavigationItemSelectedListener {

    private ProgressDialog progressBar;
    public static String PACKAGE_NAME;
    Button c1,btn_Cpp,btn_CoreJava,btn_Sql,btn_Xml;
    public final static String Message = "com.example.shivam.quizapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PACKAGE_NAME = getApplicationContext().getPackageName();

        c1 = findViewById(R.id.btn_Android);
        btn_CoreJava = findViewById(R.id.btn_CoreJava);
        btn_Cpp = findViewById(R.id.btn_Cpp);
        btn_Sql = findViewById(R.id.btn_Sql);
        btn_Xml = findViewById(R.id.btn_Xml);

        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //To show button click
                new Handler().postDelayed(new Runnable() {@Override public void run(){}}, 400);

                progressBar = new ProgressDialog(v.getContext());//Create new object of progress bar type
                progressBar.setCancelable(false);//Progress bar cannot be cancelled by pressing any wher on screen
                progressBar.setMessage("Getting Questions Ready ...");//Title shown in the progress bar
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);//Style of the progress bar
                progressBar.setProgress(0);//attributes
                progressBar.setMax(100);//attributes
                progressBar.show();//show the progress bar
                //This handler will add a delay of 3 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Intent start to open the navigation drawer activity
                        progressBar.cancel();//Progress bar will be cancelled (hide from screen) when this run function will execute after 3.5seconds
                        Intent intent = new Intent(MainActivity.this, Questions.class);
                        intent.putExtra(Message, "c1");//by this statement we are sending the name of the button that invoked the new Questions.java activity "Message" is defined by the name of the package + MESSAGE
                        startActivity(intent);
                    }
                }, 2000);


            }
        });

        btn_CoreJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        btn_Cpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        btn_Sql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        btn_Xml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
