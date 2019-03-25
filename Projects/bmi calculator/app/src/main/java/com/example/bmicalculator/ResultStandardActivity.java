package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultStandardActivity extends AppCompatActivity {
    String heightStr;
    String weightStr;
    TextView Result;
    Button b;
    Button risksbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_standard);
        b = (Button) findViewById(R.id.standardtipsbutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultStandardActivity.this, TipsActivity.class);
                startActivity(intent);
            }
        });
        risksbutton = (Button) findViewById(R.id.standardrisksbutton);
        risksbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultStandardActivity.this, RisksActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        Result = (TextView) findViewById(R.id.res);
        if (b != null) {
            heightStr = b.getString("height");
            weightStr = b.getString("weight");
        }
        if (heightStr != null && !"".equals(heightStr) && weightStr != null && !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr);
            float weightValue = Float.parseFloat(weightStr);
            float bmi = weightValue / (heightValue * heightValue) * 703;
            displayBMI(bmi);
        }
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