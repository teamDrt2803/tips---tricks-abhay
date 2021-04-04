package com.example.tipsandtricks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Statistics extends AppCompatActivity {

    public static final String msg1 = "com.example.staticstics.msg1";
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics);
        next=findViewById(R.id.button);
    }

    public void next(View view) {

        Intent intent = new Intent(this,Page2_rohit.class);
        EditText editText1 = (EditText) findViewById(R.id.edit1);
        String et = editText1.getText().toString().trim();
        if(et.isEmpty())
        {
            editText1.setError("Number Of Observations are required");
            editText1.requestFocus();
            return;
        }
        String val1 = editText1.getText().toString();
        //String[] s = {val1 , val2};
        intent.putExtra(msg1 , val1);
        startActivity(intent);
    }
}