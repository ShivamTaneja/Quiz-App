package com.example.shivam.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CoreJava extends AppCompatActivity {

    RadioButton r1, r2, r3, r4, r5, r6, r7, r8;
    RadioGroup rg1, rg2;
    int answer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_java);

        r1 = findViewById(R.id.b1);
        r2 = findViewById(R.id.b2);
        r3 = findViewById(R.id.b3);
        r4 = findViewById(R.id.b4);
        r5 = findViewById(R.id.b5);
        r6 = findViewById(R.id.b6);
        r7 = findViewById(R.id.b7);
        r8 = findViewById(R.id.b8);

        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
   }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.b1:
            if (checked)
            {
                Toast.makeText(getApplicationContext(),"Incorrect - As Short occupies 16 bits in memory. Its range is from -32768 to 32767",Toast.LENGTH_SHORT).show();
            //    answer++;
                break;
            }
            case R.id.b2:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                            answer++;
                    break;
                }
            case R.id.b3:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect - As Short occupies 16 bits in memory. Its range is from -32768 to 32767",Toast.LENGTH_SHORT).show();
                    //         answer++;
                    break;
                }
            case R.id.b4:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect - As Short occupies 16 bits in memory. Its range is from -32768 to 32767",Toast.LENGTH_SHORT).show();
                    //          answer++;
                    break;
                }
            case R.id.b5:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                            answer++;
                    break;
                }
            case R.id.b6:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect - As An expression involving bytes, ints, shorts, literal numbers, the entire expression is promoted to int before any calculation is done.",Toast.LENGTH_SHORT).show();
                  //  answer++;
                    break;
                }
            case R.id.b7:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect - As An expression involving bytes, ints, shorts, literal numbers, the entire expression is promoted to int before any calculation is done.",Toast.LENGTH_SHORT).show();
                    //         answer++;
                    break;
                }
            case R.id.b8:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "Incorrect - As An expression involving bytes, ints, shorts, literal numbers, the entire expression is promoted to int before any calculation is done.", Toast.LENGTH_SHORT).show();
                    //         answer++;
                    break;
                }
        }
    }
}