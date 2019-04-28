package com.sashwat.q4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton tb;
    ToggleButton tb1;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=findViewById(R.id.tb);
        tb1=findViewById(R.id.tb1);
        b=findViewById(R.id.b);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(getApplicationContext(),"tb on",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"tb off",Toast.LENGTH_LONG).show();
            }
        });
        tb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(getApplicationContext(),"tb1 on",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"tb1 off",Toast.LENGTH_LONG).show();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"b clicked",Toast.LENGTH_LONG).show();
            }
        });
    }
}
