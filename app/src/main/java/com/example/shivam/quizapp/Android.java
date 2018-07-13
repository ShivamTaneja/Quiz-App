package com.example.shivam.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import javax.security.auth.login.LoginException;

public class Android extends AppCompatActivity {

    Button btn;
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16;
    RadioGroup rg1, rg2, rg3, rg4;
    int answer=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);

        r1 = findViewById(R.id.b1);
        r2 = findViewById(R.id.b2);
        r3 = findViewById(R.id.b3);
        r4 = findViewById(R.id.b4);
        r5 = findViewById(R.id.b5);
        r6 = findViewById(R.id.b6);
        r7 = findViewById(R.id.b7);
        r8 = findViewById(R.id.b8);
        r9 = findViewById(R.id.b9);
        r10 = findViewById(R.id.b10);
        r11 = findViewById(R.id.b11);
        r12 = findViewById(R.id.b12);
        r13 = findViewById(R.id.b13);
        r14 = findViewById(R.id.b14);
        r15 = findViewById(R.id.b15);
        r16 = findViewById(R.id.b16);

        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        rg3 = findViewById(R.id.rg3);
        rg4 = findViewById(R.id.rg4);




    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.b1:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                    answer++;
                    break;
                }
            case R.id.b2:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
         //           answer++;
                    break;
                }
            case R.id.b3:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
           //         answer++;
                    break;
                }
            case R.id.b4:
                if (checked)
                {
                  Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
          //          answer++;
                    break;
                }
            case R.id.b5:
                if (checked)
                {
                  Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
          //          answer++;
                    break;
                }
            case R.id.b6:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                    answer++;
                    break;
                }
            case R.id.b7:
                if (checked)
                {
                   Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
           //         answer++;
                    break;
                }
            case R.id.b8:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
           //         answer++;
                    break;
                }
            case R.id.b9:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
           //         answer++;
                    break;
                }
            case R.id.b10:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
               //     answer++;
                    break;
                }
            case R.id.b11:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
        //            answer++;
                    break;
                }
            case R.id.b12:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
               //     answer++;
                    break;
                }
            case R.id.b13:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
               //     answer++;
                    break;
                }
            case R.id.b14:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                 //   answer++;
                    break;
                }
            case R.id.b15:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                   // answer++;
                    break;
                }
            case R.id.b16:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                    answer++;
                    break;
                }
        }
    }
}
