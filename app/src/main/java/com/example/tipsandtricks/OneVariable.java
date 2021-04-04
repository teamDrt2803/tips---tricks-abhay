package com.example.tipsandtricks;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


import androidx.appcompat.app.AppCompatActivity;

public class OneVariable extends AppCompatActivity {

 EditText a1,b1;
 TextView rx,xx;
 float a,b;
 String p,q;
 Button btn1,btn2;
 float x,y;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_variable);

    }

    @Override
    protected void onStart() {

        super.onStart();

        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);




        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clr();
            }
        });




    }

    public boolean getNumbers() {

        a1 = (EditText) findViewById(R.id.a);
        b1 = (EditText) findViewById(R.id.b);
        rx = (TextView) findViewById(R.id.rx);
        p = a1.getText().toString();
        q = b1.getText().toString();


            if (((p.equals(null) && q.equals(null))
                    || (p.equals("") && q.equals(""))))
            {

                String result = "Please enter a value";
                rx.setText(result);


                return false;
            }
            else {
            // converting string to int.


            a = Integer.parseInt(p);
            b = Integer.parseInt(q);


           }




        return true;
    }

    public void clr()
    {
        a1 = (EditText) findViewById(R.id.a);
        b1 = (EditText) findViewById(R.id.b);
        rx = (TextView) findViewById(R.id.rx);
        a1.getText().clear();
        b1.getText().clear();
        rx.setText("");
        rx.setHint("Result x");


    }

    @SuppressLint("SetTextI18n")
    public void calc() {

        // get the input numbers
        if (getNumbers()) {
            x = b / a;


            rx.setText(Float.toString(x));

        }
    }


}
