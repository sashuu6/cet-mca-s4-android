package com.sandhya.sashwat.myapplication.tutorial1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button) findViewById(R.id.button);
        t=(TextView) findViewById(R.id.txtview);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t.setText("You have clicked button");
            }
        });

    }

}
