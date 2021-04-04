package com.example.tipsandtricks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Sequations extends AppCompatActivity {

    Button btn1;
    Button btn2,btn3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sequations);
         btn1 = findViewById(R.id.onevariable);
         btn2 = findViewById(R.id.twovariables);
         btn3 = findViewById(R.id.threevariables);

    }







    @Override
    protected void onStart() {

        super.onStart();
        btn1 = findViewById(R.id.onevariable);
        btn2 = findViewById(R.id.twovariables);
        btn3 = findViewById(R.id.threevariables);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),OneVariable.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),TwoVariables.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),ThreeVariables.class);
                startActivity(intent);
            }
        });


    }
}
