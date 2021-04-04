package com.example.tipsandtricks;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Double.parseDouble;


public class Trigo extends AppCompatActivity {

    EditText t1,t2;
    Button btn;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trigo);

        t1=(EditText)findViewById(R.id.editTextTextPersonName);
        t2=(EditText)findViewById(R.id.editTextTextPersonName2);

        btn=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        btn5=(Button)findViewById(R.id.button5);
        btn6=(Button)findViewById(R.id.button6);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Angle;
                Angle = t1.getText().toString();
                double degrees;
                degrees= Math.toRadians(parseDouble(Angle));
                double sineOfAngle;
                sineOfAngle= Math.sin(degrees);
                String Ans;
                Ans=Double.toString(sineOfAngle);
                t2.setText(Ans);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String Angle;
                Angle = t1.getText().toString();
                double degrees=Math.toRadians(parseDouble(Angle));
                double cosOfAngle = Math.cos(degrees);
                String Ans;
                Ans = Double.toString(cosOfAngle);
                t2.setText(Ans);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String Angle;
                Angle = t1.getText().toString();
                double degrees=Math.toRadians(parseDouble(Angle));
                double tanOfAngle = Math.tan(degrees);
                String Ans;
                Ans = Double.toString(tanOfAngle);
                t2.setText(Ans);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String Angle;
                Angle = t1.getText().toString();
                double degrees=Math.toRadians(parseDouble(Angle));
                double secOfAngle = 1 / Math.cos(degrees);
                String Ans;
                Ans = Double.toString(secOfAngle);
                t2.setText(Ans);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String Angle;
                Angle = t1.getText().toString();
                double degrees=Math.toRadians(parseDouble(Angle));
                double cosecOfAngle = 1 / Math.sin(degrees);
                String Ans;
                Ans = Double.toString(cosecOfAngle);
                t2.setText(Ans);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String Angle;
                Angle = t1.getText().toString();
                double degrees=Math.toRadians(parseDouble(Angle));
                double cotOfAngle = 1 / Math.tan(degrees);
                String Ans;
                Ans = Double.toString(cotOfAngle);
                t2.setText(Ans);
            }
        });

    }
}