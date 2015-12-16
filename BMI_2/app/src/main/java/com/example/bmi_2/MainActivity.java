package com.example.bmi_2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends  AppCompatActivity {

    private EditText bmi_height,bmi_weight;
    private Context context;
    private TextView record_from_BMI;
//    private Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        bmi_height = (EditText) findViewById(R.id.input_heght);
        bmi_weight = (EditText) findViewById(R.id.input_weight);
        record_from_BMI = (TextView) findViewById(R.id.record_text);
    }
    public void onClick(View view) {
        try {

            switch(view.getId())
            {
                case R.id.cal:
                {
                    double height = Double.parseDouble(bmi_height.getText().toString());
                    double weight = Double.parseDouble(bmi_weight.getText().toString());
                    Bundle extra = new Bundle();
                    extra.putDouble("height", height);
                    extra.putDouble("weight", weight);

                    Intent intent = new Intent(context, BMI.class);
                    intent.putExtras(extra);
                    startActivityForResult(intent,1);
//                    startActivity(intent);
//                    break;
                }
            }

//            int height = Integer.getInteger(bmi_height.getText().toString());
//            int weight = Integer.getInteger(bmi_weight.getText().toString());

        }catch(Exception e){
            Toast.makeText(context,R.string.error,Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == resultCode)
        {
            String record = data.getStringExtra("result");
            record_from_BMI.setText(getResources().getString(R.string.record)+record);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }



    }




