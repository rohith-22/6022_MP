package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    String heightStr;
    String weightStr;
    TextView Result;
    Button b;
    Button risksbutton;
    Button chartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        b = (Button) findViewById(R.id.tips);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, TipsActivity.class);
                startActivity(intent);
            }
        });
        chartButton = (Button) findViewById(R.id.chart);
        chartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, ChartActivity.class);
                startActivity(intent);
            }
        });
        risksbutton = (Button) findViewById(R.id.risks);
        risksbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, RisksActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        Result = (TextView) findViewById(R.id.res);
        if(b!=null) {
          heightStr = b.getString("height");
          weightStr = b.getString("weight");
        }

        if (heightStr != null && !"".equals(heightStr) && weightStr!=null && !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);
            float bmi = weightValue / (heightValue * heightValue);
            displayBMI(bmi);
        }
       // else {
         //   String r = "Invalid Input";
           // Result.setText(r);
       // }
    }



    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);
        } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.severely_underweight);
        } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.overweight);
        } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
        } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
        } else {
            bmiLabel = getString(R.string.obese_class_iii);
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        Result.setText(bmiLabel);
    }
}
