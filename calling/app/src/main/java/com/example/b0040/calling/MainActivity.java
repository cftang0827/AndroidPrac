package com.example.b0040.calling;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private Context context1;
    private String action;
    private TextView Text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context1 = this;
        action = Intent.ACTION_CALL;
        editText1 = (EditText)this.findViewById(R.id.editText);
        Text2 = (TextView)this.findViewById(R.id.textView2);
    }


    public void onClick (View view){
        switch (view.getId()){
            case R.id.button:
                String phoneNumber = editText1.getText().toString();
                if((phoneNumber == null) || (phoneNumber.equals(""))){
                    Toast.makeText(context1, R.string.error, Toast.LENGTH_SHORT).show();
                }else{
                    Uri uri = Uri.parse("tel:"+phoneNumber);
                    Intent intent = new Intent(action,uri);
                    startActivity(intent);
                    Text2.setText("上次撥打:" + uri.toString());


                }break;
        }
    }





}
