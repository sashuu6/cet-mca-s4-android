package com.sandhya.sashwat.datapassing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText textbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textbox=(EditText)findViewById(R.id.editText);
        b=(Button) findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=textbox.getText().toString();

                Intent i= new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("message",str);
                startActivity(i);
            }
        });
    }

}
