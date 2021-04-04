package com.example.tipsandtricks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Factorisation extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factorisation);

        editText = (EditText) findViewById(R.id.editTextNumberSigned);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button );
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num =Integer.parseInt(editText.getText().toString());
                textView.setText("" + String.format(Locale.getDefault(),"%.0f",factorial(num)));
            }
        });
    }

    private double factorial(double num) {
        if (num < 2 && num >-1) {
            return 1;
        } else {
            return num * factorial(num - 1);

        }
    }
}