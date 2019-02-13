package com.sandhya.sashwat.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,badd,bsub,bmul,bdiv,bequ,bclr;
    EditText calcView;
    String num = "";
    String num2 = "";
    int numResult;
    int ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0 = (Button)findViewById(R.id.button0);
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);
        b7 = (Button)findViewById(R.id.button7);
        b8 = (Button)findViewById(R.id.button8);
        b9 = (Button)findViewById(R.id.button9);
        badd = (Button)findViewById(R.id.button_add);
        bsub = (Button)findViewById(R.id.button_min);
        bmul = (Button)findViewById(R.id.button_mul);
        bdiv = (Button)findViewById(R.id.button_div);
        bequ = (Button)findViewById(R.id.button_equal);
        bclr = (Button)findViewById(R.id.button_clear);
        calcView = (EditText)findViewById(R.id.numText);
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
        badd.setOnClickListener(this);
        bsub.setOnClickListener(this);
        bmul.setOnClickListener(this);
        bdiv.setOnClickListener(this);
        bclr.setOnClickListener(this);
        bequ.setOnClickListener(this);
        num = calcView.getText().toString();
    }

    @Override
    public void onClick(View v) {
        if(v == b0) {
            num = num + "0";
            calcView.setText(num);
        }
        if(v== b1) {
            num=num+"1";
            calcView.setText(num);
        }
        if(v== b2) {
            num=num+"2";
            calcView.setText(num);
        }
        if(v== b3) {
            num=num+"3";
            calcView.setText(num);
        }
        if(v== b4) {
            num=num+"4";
            calcView.setText(num);
        }
        if(v== b5) {
            num=num+"5";
            calcView.setText(num);
        }
        if(v== b6) {
            num=num+"6";
            calcView.setText(num);
        }
        if(v== b7) {
            num=num+"7";
            calcView.setText(num);
        }
        if(v== b8) {
            num=num+"8";
            calcView.setText(num);
        }
        if(v== b9) {
            num=num+"9";
            calcView.setText(num);
        }
        if(v== badd) {
            num2 = num;
            num = "";
            calcView.setText("");
            ch = 1;
        }
        if(v== bsub) {
            num2 = num;
            calcView.setText("");
            ch = 2;
            num = "";
        }
        if(v== bmul) {
            num2 = num;
            calcView.setText("");
            ch = 3;
            num = "";

        }
        if(v== bdiv) {
            num2 = num;
            calcView.setText("");
            ch = 4;
            num = "";

        }
        if(v== bequ) {
            if(ch == 1) {
                numResult = Integer.parseInt(num2) + Integer.parseInt(num);
            }
            if(ch == 2) {
                numResult = Integer.parseInt(num2) - Integer.parseInt(num);
            }
            if(ch == 3) {
                numResult = Integer.parseInt(num2) * Integer.parseInt(num);
            }
            if(ch == 4) {
                numResult = Integer.parseInt(num2) / Integer.parseInt(num);
            }
            calcView.setText(numResult+"");
        }
        if(v == bclr) {
            calcView.setText("");
            num = "";
            num2 = "";
            numResult = 0;
        }
    }
}
