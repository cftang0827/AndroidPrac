package com.example.cftang.bmi_5;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(calBMI);

    }
        private OnClickListener calBMI = new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText fieldheight = (EditText)findViewById(R.id.editText);
                EditText fieldweight = (EditText)findViewById(R.id.editText2);

                double height = Double.parseDouble(fieldheight.getText().toString()) / 100;
                double weight = Double.parseDouble(fieldweight.getText().toString());
                double BMI = weight / (height*height);

                EditText out = (EditText)findViewById(R.id.editText3);
                out.setText("你的BMI值為: "+BMI);

                //
                TextView suggest = (TextView)findViewById(R.id.textView5);
                if(BMI>25)
                {
                    suggest.setText("幹你媽肥子!");
                }else if(BMI >20 && BMI <=25)
                {
                    suggest.setText("你普通啦，隨便!!");
                }else if(BMI<20)
                {
                    suggest.setText("小瘦皮猴!!嫩!!!");
                }

            }
        };







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

