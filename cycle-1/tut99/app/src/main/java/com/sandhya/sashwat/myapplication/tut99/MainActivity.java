package com.sandhya.sashwat.myapplication.tut99;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends Activity {
    RelativeLayout tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tl=findViewById(R.id.abc);
// initiate view's
        ImageButton simpleImageButtonHome = (ImageButton)findViewById(R.id.simpleImageButtonHome);
        ImageButton simpleImageButtonYouTube = (ImageButton)findViewById(R.id.simpleImageButtonYouTube);

// perform click event on button's
        simpleImageButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tl.setBackgroundResource(R.drawable.sachi1);
            }
        });
        simpleImageButtonYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tl.setBackgroundResource(R.drawable.sachin);
            }
        });
    }


}