package com.chandu.ktmirash.myapplication.smsproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bcall,bclr;
    EditText dialerSpeed;
    String num = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        b0 = (Button)findViewById(R.id.speeddial0);
        b1 = (Button)findViewById(R.id.speeddial1);
        b2 = (Button)findViewById(R.id.speeddial2);
        b3 = (Button)findViewById(R.id.speeddial3);
        b4 = (Button)findViewById(R.id.speeddial4);
        b5 = (Button)findViewById(R.id.speeddial5);
        b6 = (Button)findViewById(R.id.speeddial6);
        b7 = (Button)findViewById(R.id.speeddial7);
        b8 = (Button)findViewById(R.id.speeddial8);
        b9 = (Button)findViewById(R.id.speeddial9);
        bcall = (Button)findViewById(R.id.speeddialcallButton);
        bclr = (Button)findViewById(R.id.speeddialclear);
        dialerSpeed = (EditText)findViewById(R.id.diallerEditText);
        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bclr.setOnClickListener(this);
        bcall.setOnClickListener(this);
        num = dialerSpeed.getText().toString();
        b1.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == b0) {
            num = num + "0";
            dialerSpeed.setText(num);
        }
        if (v == b1) {
            num = num + "1";
            dialerSpeed.setText(num);
        }
        if (v == b2) {
            num = num + "2";
            dialerSpeed.setText(num);
        }
        if (v == b3) {
            num = num + "3";
            dialerSpeed.setText(num);
        }
        if (v == b4) {
            num = num + "4";
            dialerSpeed.setText(num);
        }
        if (v == b5) {
            num = num + "5";
            dialerSpeed.setText(num);
        }
        if (v == b6) {
            num = num + "6";
            dialerSpeed.setText(num);
        }
        if (v == b7) {
            num = num + "7";
            dialerSpeed.setText(num);
        }
        if (v == b8) {
            num = num + "8";
            dialerSpeed.setText(num);
        }
        if (v == b9) {
            num = num + "9";
            dialerSpeed.setText(num);
        }
        if (v == bclr) {
            num = "";
            dialerSpeed.setText(num);
        }
        if (v == bcall) {

            if (ContextCompat.checkSelfPermission(Main3Activity.this, Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Main3Activity.this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        1);

                // Permission is not granted
            }
            else {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+dialerSpeed.getText().toString()));

                if (ActivityCompat.checkSelfPermission(Main3Activity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (ContextCompat.checkSelfPermission(Main3Activity.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Main3Activity.this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1);

            // Permission is not granted
        }
        else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:8281962557"));

            if (ActivityCompat.checkSelfPermission(Main3Activity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return true;
            }
            startActivity(callIntent);
        }
        return false;
    }
}
