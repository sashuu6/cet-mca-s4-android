package com.sashwat.q10;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    Button b;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp=findViewById(R.id.date_picker);
        b=findViewById(R.id.b);
        tv=findViewById(R.id.tv);
        b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                tv.setText(dp.getDayOfMonth()+"-"+ dp.getMonth()+"-"+dp.getYear());

            }
        });
    }
}