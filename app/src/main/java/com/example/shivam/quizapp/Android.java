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

class Android extends AppCompatActivity {

    Button btn_submit;

    RadioButton radiobutton1,radiobutton2,radiobutton3,radiobutton4,radiobutton5,radiobutton6,radiobutton7,radiobutton8,radiobutton9,radiobutton10,radiobutton11,radiobutton12,radiobutton13,radiobutton14,radiobutton15,radiobutton16;
    RadioGroup radiogroup1, radiogroup2, radiogroup3, radiogroup4;

    int answer=0;

    boolean a=false,b=false,c=false,d=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);

        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(a==true)answer++; if(b==true)answer++; if(c==true)answer++; if(d==true)answer++;
                Log.e("shivam", "answer" + answer );
                Toast.makeText(getApplicationContext(),"You scored " + " " + answer , Toast.LENGTH_LONG).show();
                answer=0;
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radiobutton1:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                    a=true;
                    break;
                }
            case R.id.radiobutton2:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                    a=false;
                    break;
                }
            case R.id.radiobutton3:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                    a=false;
                    break;
                }
            case R.id.radiobutton4:
                if (checked)
                {
                  Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                    a=false;
                    break;
                }
            case R.id.radiobutton5:
                if (checked)
                {
                  Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                    b=false;
                    break;
                }
            case R.id.radiobutton6:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                    b=true;
                    break;
                }
            case R.id.radiobutton7:
                if (checked)
                {
                   Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                    b=false;
                    break;
                }
            case R.id.radiobutton8:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                    b=false;
                    break;
                }
            case R.id.radiobutton9:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                    c=false;
                    break;
                }
            case R.id.radiobutton10:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                    c=false;
                    break;
                }
            case R.id.radiobutton11:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                    c=true;
                    break;
                }
            case R.id.radiobutton12:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                    c=false;
                    break;
                }
            case R.id.radiobutton13:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                    d=false;
                    break;
                }
            case R.id.radiobutton14:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                    d=false;
                    break;
                }
            case R.id.radiobutton15:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                    d=false;
                    break;
                }
            case R.id.radiobutton16:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                    d=true;
                    break;
                }
        }
    }
}
