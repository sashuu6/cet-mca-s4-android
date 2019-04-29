package com.sandhya.sashwat.myapplication.tut10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    ImageButton i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=findViewById(R.id.imageButton);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"haii..",Toast.LENGTH_LONG).show();
            }
        });
    }
}
