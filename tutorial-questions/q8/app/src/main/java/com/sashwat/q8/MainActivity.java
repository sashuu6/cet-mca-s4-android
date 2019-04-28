package com.sashwat.q8;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1=findViewById(R.id.layout1);

        // initiate view's
        ImageButton simpleImageButtonHome = (ImageButton)findViewById(R.id.simpleImageButtonGithub);
        ImageButton simpleImageButtonYouTube = (ImageButton)findViewById(R.id.simpleImageButtonDocker);

        // perform click event on button's
        simpleImageButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l1.setBackgroundResource(R.drawable.github);
            }
        });
        simpleImageButtonYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l1.setBackgroundResource(R.drawable.docker);
            }
        });
    }
}
