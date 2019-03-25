package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StandardActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    private EditText height;
    private EditText weight;
    private TextView result;
    private EditText name;
    private EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
        b1 = (Button) findViewById(R.id.metric);
        b2 = (Button) findViewById(R.id.calculate);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StandardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.enter_age);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(height.getText().toString().equals("")|| weight.getText().toString().equals("") || age.getText().toString().equals("")
                || name.getText().toString().equals("")){
                    Toast.makeText(StandardActivity.this, "Values cannot be Empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    String heightStr = height.getText().toString();
                    String weightStr = weight.getText().toString();
                    Intent intent = new Intent(StandardActivity.this, ResultStandardActivity.class);
                    intent.putExtra("height", heightStr);
                    intent.putExtra("weight", weightStr);
                    startActivity(intent);
                }
            }
        });
    }
    public void calculateBMI(View v) {

//        Intent intent = new Intent(StandardActivity.this, ResultStandardActivity.class);
//        intent.putExtra("height", heightStr);
//        intent.putExtra("weight", weightStr);
//        startActivity(intent);
    }

}
