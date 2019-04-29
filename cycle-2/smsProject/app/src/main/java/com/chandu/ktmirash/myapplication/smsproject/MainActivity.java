package com.chandu.ktmirash.myapplication.smsproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity<button> extends Activity {
    button smsButton,speedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button smsButton= (Button) findViewById(R.id.smsButton);
        Button speedButton= (Button) findViewById(R.id.speedButton);
        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i= new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });
        speedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I= new Intent(MainActivity.this,Main3Activity.class);
                startActivity(I);
            }
        });
    }
}
