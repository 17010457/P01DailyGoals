package com.myapplicationdev.android.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Button btnBack = findViewById(R.id.btnBack);
        setTitle("Summary");

        Intent i = getIntent();
        String[] info = i.getStringArrayExtra("answer");
        String qn1 = i.getStringExtra("qn1");
        String qn2 = i.getStringExtra("qn2");
        String qn3 = i.getStringExtra("qn3");

        TextView tv1 = findViewById(R.id.textView);
        tv1.setText(qn1 + " : " + info[0] + "\n" + qn2 + " : " + info[1] + "\n" + qn3 + " : " + info[2] + "\nReflection: " + info[3]);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
