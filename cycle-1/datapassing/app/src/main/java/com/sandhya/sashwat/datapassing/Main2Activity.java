package com.sandhya.sashwat.datapassing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text=(TextView)findViewById(R.id.text);
        Intent i1=getIntent();
        String str= i1.getStringExtra("message");
        text.setText(str);
    }
}



