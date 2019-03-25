package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    private EditText height= null;
    private EditText weight = null;
    private EditText age = null;
    private EditText name = null;
    private TextView result;
    String heightStr = "";
    String weightStr = "";
    String ageStr = "";
    String nameStr = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        age = (EditText) findViewById(R.id.enterage);
        name = (EditText) findViewById(R.id.name);
        button1 = (Button) findViewById(R.id.calc);
        button2 = (Button) findViewById(R.id.standard);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, StandardActivity.class);
                    startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heightStr = height.getText().toString();
                weightStr = weight.getText().toString();
                ageStr = age.getText().toString();
                nameStr = name.getText().toString();
                if (heightStr.equals("") || weightStr.equals("") || ageStr.equals("") || nameStr.equals("")) {
                    Toast.makeText(MainActivity.this, "Values cannot be Empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("height", heightStr);
                    intent.putExtra("weight", weightStr);
                    startActivity(intent);
                }
            }
        });

    }

    public void calculateBMI(View v) {
//
//        if (heightStr != null && !"".equals(heightStr) &&
//        weightStr!=null && !"".equals(weightStr)) {
//            float heightValue = Float.parseFloat(heightStr) / 100;
//            float weightValue = Float.parseFloat(weightStr);
//            float bmi = weightValue / (heightValue * heightValue);
//            displayBMI(bmi);
//        }

    }
}


//    private void displayBMI(float bmi) {
//        String bmiLabel = "";
//
//        if (Float.compare(bmi, 15f) <= 0) {
//            bmiLabel = getString(R.string.very_severely_underweight);
//        } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
//            bmiLabel = getString(R.string.severely_underweight);
//        } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
//            bmiLabel = getString(R.string.underweight);
//        } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
//            bmiLabel = getString(R.string.normal);
//        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
//            bmiLabel = getString(R.string.overweight);
//        } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
//            bmiLabel = getString(R.string.obese_class_i);
//        } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
//            bmiLabel = getString(R.string.obese_class_ii);
//        } else {
//            bmiLabel = getString(R.string.obese_class_iii);
//        }
//
//        bmiLabel = bmi + "\n\n" + bmiLabel;
//        result.setText(bmiLabel);
//    }

