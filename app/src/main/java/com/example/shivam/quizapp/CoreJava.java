package com.example.shivam.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

class CoreJava extends AppCompatActivity {

    Button btn_submit,btn_check_txt_answer;

    RadioButton radiobutton1,radiobutton2,radiobutton3,radiobutton4,radiobutton5,radiobutton6,radiobutton7,radiobutton8;
    RadioGroup radiogroup1, radiogroup2;

    int answer=0;

    boolean a =false,b=false,c=false,d=false,e=false,f=false;

    EditText edittext;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_java);

        edittext = findViewById(R.id.edittext);
        
        btn_check_txt_answer = findViewById(R.id.btn_check_txt_answer);
        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(a ==true)answer++; if(e==true)answer++; if(f==true)answer++; if(b==true && c==true && (d==false))answer++;
                Log.e("shivam", "java" + answer );
                Toast.makeText(getApplicationContext(),"You scored " + " " + answer , Toast.LENGTH_LONG).show();
                answer=0;
            }
        });

        btn_check_txt_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str_et = "",str="Java Virtual Machine";
                str=str.replaceAll("\\s+","");
                str_et = edittext.getText().toString();
                str_et=str_et.replaceAll("\\s+","");
                if(str_et.equals(""))
                {
                        Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_SHORT).show();
                }
                else if(str.equalsIgnoreCase(str_et) )
                {
                    Toast.makeText(getApplicationContext(),"Correct ",Toast.LENGTH_SHORT).show();
                    a =true;
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Incorrect  ",Toast.LENGTH_SHORT).show();
                    a =false;
                }
            }
        });

   }
   public void  onCheckboxClicked(View view) {
       boolean checked = ((CheckBox) view).isChecked();
       switch (view.getId()) {
           case R.id.checkbox1:
               if (checked) {
                   Toast.makeText(getApplicationContext(), "correct - you will get point iff you select all correct options", Toast.LENGTH_SHORT).show();
                   b=true;
                   break;
               }
               else
               {
                   b=false;
               }
           case R.id.checkbox2:
               if (checked) {
                   Toast.makeText(getApplicationContext(), "correct - you will get point iff you select all correct options", Toast.LENGTH_SHORT).show();
                   c=true;
                   break;
               }
               else {
                   b=false;
               }
           case R.id.checkbox3:
               if (checked) {
                   Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                   d=true;
                   break;
               }
               else {
                   d=false;
               }
           case R.id.checkbox4:
               if (checked) {
                   Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                   d=true;
                   break;
               }
               else {
                   d=false;
               }
           case R.id.checkbox5:
               if (checked) {
                   Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                   d=true;
                   break;
               }
               else {
                   d=false;
               }
       }
   }


  public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radiobutton1:
            if (checked)
            {
                Toast.makeText(getApplicationContext(),"Incorrect - As Short occupies 16 bits in memory. Its range is from -32768 to 32767",Toast.LENGTH_SHORT).show();
                e=false;
                break;
            }
            case R.id.radiobutton2:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                    e=true;
                    break;
                }
            case R.id.radiobutton3:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect - As Short occupies 16 bits in memory. Its range is from -32768 to 32767",Toast.LENGTH_SHORT).show();
                    e=false;
                    break;
                }
            case R.id.radiobutton4:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect - As Short occupies 16 bits in memory. Its range is from -32768 to 32767",Toast.LENGTH_SHORT).show();
                    e=false;
                    break;
                }
            case R.id.radiobutton5:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                    f=true;
                    break;
                }
            case R.id.radiobutton6:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect - As An expression involving bytes, ints, shorts, literal numbers, the entire expression is promoted to int before any calculation is done.",Toast.LENGTH_SHORT).show();
                    f=false;
                    break;
                }
            case R.id.radiobutton7:
                if (checked)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect - As An expression involving bytes, ints, shorts, literal numbers, the entire expression is promoted to int before any calculation is done.",Toast.LENGTH_SHORT).show();
                    f=false;
                    break;
                }
            case R.id.radiobutton8:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "Incorrect - As An expression involving bytes, ints, shorts, literal numbers, the entire expression is promoted to int before any calculation is done.", Toast.LENGTH_SHORT).show();
                    f=false;
                    break;
                }
        }
    }
}