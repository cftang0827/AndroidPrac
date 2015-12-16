package com.example.bmi_2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
//import android.support.v7.widget.To;
//;

public class BMI extends  AppCompatActivity {

    private TextView result;
    private TextView tip;
    private String record;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_bmi);
            result = (TextView) findViewById(R.id.result);

            Bundle extra = getIntent().getExtras();
            double h = extra.getDouble("height") / 100.0;
            double w = extra.getDouble("weight");

            double value = w / Math.pow(h, 2);
            value = Math.round(value);
            record = Double.toString(value);
            result.setText(record);
            String aa = giveSuggest(value);
//            tip(TextView)
//            tip.setText(aa);
            tip = (TextView)findViewById(R.id.tip);
            tip.setText(aa);


        }catch(Exception e)
        {
            Toast.makeText(this, R.string.error1, Toast.LENGTH_SHORT).show();
        }
    }

    private String giveSuggest(double value)
    {
        String m = " ";
        if(value>0 && value < 20)
        {
            m = getResources().getString(R.string.thin);
        }else if(value >=20 && value < 28)
        {
            m = getResources().getString(R.string.normal);
        }else if(value >=28 )
        {
            m = getResources().getString(R.string.fat);
        }

        return m;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuItem backItem = menu.add(0,0,0,"BACK!!");
        backItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
                if(item.getItemId() == 0)
        {
            Intent intent = new Intent();
            intent.putExtra("result",record);
            setResult(1,intent);
            finish();
        }
        return true;
    }

    }


//    @Override
//    public boolean onMenuItemSelected(int featureId, MenuItem item)
//    {
//        if(item.getItemId() == 0)
//        {
//            Intent intent = new Intent();
//            intent.putExtra("result",record);
//            setResult(1,intent);
//            finish();
//        }
//        return super.onMenuItemSelected(featureId, item);
//    }



//}
