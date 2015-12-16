package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BMIActivity extends AppCompatActivity {

    private TextView bmi_result;
    private String bmi_record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi3);
        bmi_result = (TextView) findViewById(R.id.bmi_result);

        Bundle extra = getIntent().getExtras();
        double h = extra.getInt("height") / 100.0;
        double w = extra.getInt("weight");

        double bmi = w / Math.pow(h, 2);
        NumberFormat nf = new DecimalFormat("##.00");

        bmi_record = String.format("%s %s %s", bmi_result.getText().toString(), nf.format(bmi), getBMIMessage(bmi));

        bmi_result.setText(bmi_record);


    }

    private String getBMIMessage(double value) {
        String m = " ";
        if (value > 0 && value < 20) {
            m = getResources().getString(R.string.thin);
        } else if (value >= 20 && value < 26) {
            m = getResources().getString(R.string.normal);
        } else if (value >= 26 && value < 30) {
            m = getResources().getString(R.string.fat);
        } else if (value >= 30 && value < 40) {
            m = getResources().getString(R.string.reallyFat);
        } else if (value >= 40) {
            m = getResources().getString(R.string.godFat);
        }

        return m;
    }
}
