package com.example.shivam.quizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.ArrayList;
import java.util.Collections;

public class  Questions extends AppCompatActivity {

    DonutProgress donutProgress;
    int variable =0;
    TextView ques;
    Button OptA, OptB, OptC, OptD;
    Button play_button;
    String get;
    //Objects of different classes
    Android obj_android;
    Sql obj_sql;
    Xml obj_xml;
    CoreJava obj_corejava;
    Cpp obj_cpp;

    public int visibility = 0, c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, i, j = 0, k = 0, l = 0;
    String global = null, Ques, Opta, Optb, Optc, Optd;
    ArrayList<Integer> list = new ArrayList<Integer>();
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences shared = getSharedPreferences("Score", Context.MODE_PRIVATE);

        Intent intent = getIntent();//recieving the intent send by the main activity
        get = intent.getStringExtra(MainActivity.Message);//converting that intent message to string using the getStringExtra() method
        toast = new Toast(this);

        //attribute of the circular progress bar
        donutProgress = (DonutProgress) findViewById(R.id.donut_progress);
        donutProgress.setMax(100);
        donutProgress.setFinishedStrokeColor(Color.parseColor("#FFFB385F"));
        donutProgress.setTextColor(Color.parseColor("#FFFB385F"));
        donutProgress.setKeepScreenOn(true);
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);

        //Now the linking of all the datbase files with the Question activity
        //Android
        obj_android = new  Android(this);
        obj_android.createDatabase();
        obj_android.openDatabase();
        obj_android.getWritableDatabase();
        //Core Java
        obj_corejava = new CoreJava(this);
        obj_corejava.createDatabase();
        obj_corejava.openDatabase();
        obj_corejava.getWritableDatabase();

        //Sql
        obj_sql = new Sql(this);
        obj_sql.createDatabase();
        obj_sql.openDatabase();
        obj_sql.getWritableDatabase();

        //Xml
        obj_xml = new Xml(this);
        obj_xml.createDatabase();
        obj_xml.openDatabase();
        obj_xml.getWritableDatabase();

        //Cpp
        obj_cpp = new Cpp(this);
        obj_cpp.createDatabase();
        obj_cpp.openDatabase();
        obj_cpp.getWritableDatabase();

        //Till here we are linking the database file
        OptA = (Button) findViewById(R.id.OptionA);
        OptB = (Button) findViewById(R.id.OptionB);
        OptC = (Button) findViewById(R.id.OptionC);
        OptD = (Button) findViewById(R.id.OptionD);
        ques = (TextView) findViewById(R.id.Questions);
        play_button = (Button) findViewById(R.id.play_button);//Play button to start the game

    }

    public void onClick(View v) {//When this method is executed then there will be new question came and also same method for play button
        final SharedPreferences shared = getSharedPreferences("Score", Context.MODE_PRIVATE);

        k++;
        if (visibility == 0) {
            //showing the buttons which were previously invisible
            OptA.setVisibility(View.VISIBLE);
            OptB.setVisibility(View.VISIBLE);
            OptC.setVisibility(View.VISIBLE);
            OptD.setVisibility(View.VISIBLE);
            play_button.setVisibility(View.GONE);
            donutProgress.setVisibility(View.VISIBLE);
            visibility = 1;
            new CountDownTimer(10000, 1000) {//countdowntimer
                int i = 100;

                @Override
                public void onTick(long millisUntilFinished) {
                    i = i - 10;
                    donutProgress.setProgress(i);
                }

                @Override
                public void onFinish() {

                    toast.cancel();
                    SharedPreferences.Editor editor = shared.edit();//here we are saving the data when the countdown timer will finish and it is saved in shared prefrence file that is defined in onCreate method as score
                    editor.putInt("Questions", k).commit();
                    if (get.equals("c1") && shared.getInt("obj_android", 0) < l)
                        editor.putInt("obj_android", l * 10).apply();
                    else if (get.equals("c2") && shared.getInt("obj_corejava", 0) < l)
                        editor.putInt("obj_corejava", l * 10).apply();
                    else if (get.equals("c3") && shared.getInt("obj_cpp", 0) < l)
                        editor.putInt("obj_cpp", l * 10).apply();
                    else if (get.equals("c5") && shared.getInt("obj_xml", 0) < l)
                        editor.putInt("obj_xml", l * 10).apply();
                    else if (get.equals("c4") && shared.getInt("obj_sql", 0) < l)
                        editor.putInt("obj_sql", l * 10).apply();


                    donutProgress.setProgress(0);
                    if(variable==0) {
                        Intent intent = new Intent(Questions.this, Result.class);
                        intent.putExtra("correct", l);
                        intent.putExtra("attemp", k);
                        startActivity(intent);
                        finish();
                    }
                }
            }.start();

        }

        if (global != null) {
            if (global.equals("A")) {
                if (v.getId() == R.id.OptionA) {
                    //Here we use the snackbar because if we use the toast then they will be stacked an user cannot idetify which questions answer is it showing
                    Snackbar.make(v, "         Correct ☺", Snackbar.LENGTH_SHORT).show();

                    l++;
                } else {
                    Snackbar.make(v, "Incorrect\t      Answer :" + Opta + "", Snackbar.LENGTH_SHORT).show();
                }

            } else if (global.equals("B")) {
                if (v.getId() == R.id.OptionB) {
                    Snackbar.make(v, "          Correct ☺", Snackbar.LENGTH_SHORT).show();
                    l++;
                } else {
                    Snackbar.make(v, "Incorrect\t      Answer :" + Optb + "", Snackbar.LENGTH_SHORT).show();
                }

            } else if (global.equals("C")) {
                if (v.getId() == R.id.OptionC) {

                    Snackbar.make(v, "         Correct ☺", Snackbar.LENGTH_SHORT).show();
                    l++;
                } else {
                    Snackbar.make(v, "Incorrect\tAnswer :" + Optc + "", Snackbar.LENGTH_SHORT).show();
                }
            } else if (global.equals("D")) {
                if (v.getId() == R.id.OptionD) {
                    Snackbar.make(v, "        Correct ☺", Snackbar.LENGTH_SHORT).show();
                    l++;
                } else {

                    Snackbar.make(v, "Incorrect\tAnswer :" + Optd + "", Snackbar.LENGTH_SHORT).show();
                }
            }
        }

      if (get.equals("c1")) {

            if (c1 == 0) {
                for (i = 1; i <= 15; i++) {
                    list.add(new Integer(i));
                }

                Log.e("c1", "get.equals(c1)" );

                Collections.shuffle(list);
                c1=1;
            }

            Ques = obj_android.readQuestion(list.get(j));
            Opta = obj_android.readOptionA(list.get(j));
            Optb = obj_android.readOptionB(list.get(j));
            Optc = obj_android.readOptionC(list.get(j));
            Optd = obj_android.readOptionD(list.get(j));
            global = obj_android.readAnswer(list.get(j++));

        }
        else if(get.equals("c2")) {

            Log.e("c2", "get.equal(c2) " );
            if (c2 == 0) {
                Log.e("c2", "get.equal(c2) " );
                for (i = 1; i <=15 ; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c2=1;
            }
            Ques = obj_corejava.readQuestion(list.get(j));
            Opta = obj_corejava.readOptionA(list.get(j));
            Optb = obj_corejava.readOptionB(list.get(j));
            Optc = obj_corejava.readOptionC(list.get(j));
            Optd = obj_corejava.readOptionD(list.get(j));
            global = obj_corejava.readAnswer(list.get(j++));

        } else if (get.equals("c3")) {
            Log.e("c3", "get.equal(c3) " );
            if (c3 == 0) {
                Log.e("c3", "get.equal(c3) " );
                for (i = 1; i <=15 ; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c3=1;
            }
            Ques = obj_cpp.readQuestion(list.get(j));
            Opta = obj_cpp.readOptionA(list.get(j));
            Optb = obj_cpp.readOptionB(list.get(j));
            Optc = obj_cpp.readOptionC(list.get(j));
            Optd = obj_cpp.readOptionD(list.get(j));
            global = obj_cpp.readAnswer(list.get(j++));
        } else if (get.equals("c5")) {
            Log.e("c5", "get.equal(c5) " );
            if (c5 == 0) {
                Log.e("c5", "get.equal(c5) " );
                for (i = 1; i <=15 ; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c5=1;
            }
            Ques = obj_xml.readQuestion(list.get(j));
            Opta = obj_xml.readOptionA(list.get(j));
            Optb = obj_xml.readOptionB(list.get(j));
            Optc = obj_xml.readOptionC(list.get(j));
            Optd = obj_xml.readOptionD(list.get(j));
            global = obj_xml.readAnswer(list.get(j++));
        } else if (get.equals("c4")) {
            Log.e("c4", "get.equal(c4) " );

            if (c4 == 0) {
                Log.e("c4", "get.equal(c4) " );

                for (i = 1; i <=15; i++) {
                    list.add(new Integer(i));
                    Log.e("Questions","get.equals(c5)" );
                }
                Collections.shuffle(list);
                c4=1;
            }
            Ques = obj_sql.readQuestion(list.get(j));
            Opta = obj_sql.readOptionA(list.get(j));
            Optb = obj_sql.readOptionB(list.get(j));
            Optc = obj_sql.readOptionC(list.get(j));
            Optd = obj_sql.readOptionD(list.get(j));
            global = obj_sql.readAnswer(list.get(j++));
        }

        ques.setText("" + Ques);
        OptA.setText(Opta);
        OptB.setText(Optb);
        OptC.setText(Optc);
        OptD.setText(Optd);

    }

    @Override
    protected void onPause() {
        super.onPause();
        variable =1;
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        variable =1;
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        variable = 1;
        finish();
    }
}




