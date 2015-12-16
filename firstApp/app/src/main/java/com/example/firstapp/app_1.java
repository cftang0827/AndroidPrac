package com.example.firstapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class app_1 extends AppCompatActivity {
    private Context context;
    private EditText h,w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_1);
        context = this;
        h = (EditText)findViewById(R.id.input_height);
        w = (EditText)findViewById(R.id.input_weight);
    }

    public void onClick(View view){

        try {

            int height = Integer.parseInt(h.getText().toString());
            int weight = Integer.parseInt(w.getText().toString());

            Bundle extra = new Bundle();
            extra.putInt("height",height);
            extra.putInt("weight",weight);
            Intent intents;
            intents = new Intent(context,BMIActivity.class);
            intents.putExtras(extra);
            startActivity(intents);
        }catch(Exception e)
        {
            Toast.makeText(context,R.string.bmi_error_mes,Toast.LENGTH_SHORT).show();
        }

    }
}
