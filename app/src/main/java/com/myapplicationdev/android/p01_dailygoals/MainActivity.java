package com.myapplicationdev.android.p01_dailygoals;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String USER_PREF = "USER_PREF" ;
    SharedPreferences sp; RadioGroup rg1; RadioGroup rg2; RadioGroup rg3; RadioButton rb1; RadioButton rb2; RadioButton rb3;
    TextView tv1; TextView tv2; TextView tv3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("Daily Goal");
        Button btn = findViewById(R.id.button);
        sp = getSharedPreferences(USER_PREF, Context.MODE_PRIVATE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1 = findViewById(R.id.textView1);
                tv2 = findViewById(R.id.textView3);
                tv3 = findViewById(R.id.textView5);
                rg1 = findViewById(R.id.radioGroup1);
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                rb1 = findViewById(selectedButtonId1);

                rg2 = findViewById(R.id.radioGroup2);
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                rb2 = findViewById(selectedButtonId2);

                rg3 = findViewById(R.id.radioGroup3);
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                rb3 = findViewById(selectedButtonId3);

                EditText et1 = findViewById(R.id.editText);

                String[] answer = {rb1.getText().toString(), rb2.getText().toString(), rb3.getText().toString(), et1.getText().toString()};

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("ans1", rb1.getText().toString());
                editor.putString("ans2", rb2.getText().toString());
                editor.putString("ans3", rb3.getText().toString());
                editor.putString("ans4", et1.getText().toString());
                editor.commit();


                Intent i = new Intent(MainActivity.this, SummaryActivity.class);
                i.putExtra("answer", answer);
                i.putExtra("qn1", tv1.getText());
                i.putExtra("qn2", tv2.getText());
                i.putExtra("qn3", tv3.getText());

                startActivity(i);

            }
        });


    }

    @Override
    protected void onResume() {
        RadioButton rb10 = findViewById(R.id.radioButton1);
        RadioButton rb11 = findViewById(R.id.radioButton2);
        RadioButton rb20 = findViewById(R.id.radioButton3);
        RadioButton rb21 = findViewById(R.id.radioButton4);
        RadioButton rb30 = findViewById(R.id.radioButton5);
        RadioButton rb31 = findViewById(R.id.radioButton6);
        EditText et1 = findViewById(R.id.editText);

        String goal1 = sp.getString("ans1","");
        String goal2 = sp.getString("ans2","");
        String goal3 = sp.getString("ans3","");
        String goal4 = sp.getString("ans4","");
        super.onResume();
        if (goal1 == "Yes"){
            rb10.setChecked(true);
            rb11.setChecked(false);
        } else{
            rb10.setChecked(false);
            rb11.setChecked(true);
        }
        if (goal2 == "Yes"){
            rb20.setChecked(true);
            rb21.setChecked(false);
        } else{
            rb21.setChecked(true);
            rb20.setChecked(false);
        }
        if (goal3 == "Yes"){
            rb31.setChecked(false);
            rb30.setChecked(true);
        } else{
            rb31.setChecked(true);
            rb30.setChecked(false);
        }
        et1.setText(goal4);

    }
}
