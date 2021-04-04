package com.example.tipsandtricks;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Page3_rohit extends AppCompatActivity {


    //TextView tv;
    Button bt1, bt2, bt3, bt4;

    List<Double> values1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3_rohit);
        Intent it3 = getIntent();
        ArrayList<Double> values = (ArrayList<Double>) it3.getSerializableExtra(Page2_rohit.msg2);

        //   values = Arrays.asList(it3.getStringArrayExtra(Page2.msg2));
        //  values1 = values;
        TextView tv = (TextView) findViewById(R.id.textView3);
        //tv.setText(String.valueOf(values));
        values1 = values;
        TextView tv1 = (TextView) findViewById(R.id.textView4);
        tv.setText(String.valueOf(values1));
        bt1 = (Button) findViewById(R.id.mean);
        bt2 = (Button) findViewById(R.id.median);
        bt3 = (Button) findViewById(R.id.variance);
        bt4 = (Button) findViewById(R.id.sd);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Object[] objects = values.toArray();
                double m = 0.0;
                for (int i = 0; i <= values1.size() - 1; i++) {

                    m = m + values1.get(i);
                }
                m = m / values1.size();
                //Toast.makeText(getBaseContext(),"" + m,Toast.LENGTH_LONG).show();

                tv1.setText("" + m);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double median = 0.0;
                double mid = 0.0;
                if(values1.size() % 2 == 0 )
                {
                    int temp = (values1.size() / 2) - 1;
                    for (int i = 0; i <= values1.size() - 1; i++){
                        if(temp == i || (temp + 1) == i){
                            mid = mid + values1.get(i);
                        }
                    }
                    mid = mid / 2;
                    tv1.setText("" + mid);
                }
                else{
                    int temp = (values1.size() / 2);
                    for(int i = 0; i <= values1.size() - 1; i++){
                        if(temp == i){
                            mid = values1.get(i);
                            tv1.setText("" + mid);
                        }
                    }
                }

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double sum = 0.0, sum1 = 0.0, m, var;
                for (int i = 0; i <= values1.size() - 1; i++) {
                    sum = sum + values1.get(i);
                }
                m = sum / values1.size();
                for (int i = 0; i <= values1.size() - 1; i++) {
                    sum1 = sum1 + ((m - values1.get(i)) * (m - values1.get(i)));
                }
                var = sum1 / values1.size();

                // Toast.makeText(getBaseContext(), "" + var, Toast.LENGTH_LONG).show();

                tv1.setText("" + var);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double sum = 0.0, sum1 = 0.0, m, var;
                double sd = 0.0;
                for (int i = 0; i <= values1.size() - 1; i++) {
                    sum = sum + values1.get(i);
                }
                m = sum / values1.size();
                for (int i = 0; i <= values1.size() - 1; i++) {
                    sum1 = sum1 + ((m - values1.get(i)) * (m - values1.get(i)));
                }
                var = sum1 / values1.size();
                sd = Math.sqrt(var);

                // Toast.makeText(getBaseContext(), "" + sd, Toast.LENGTH_LONG).show();

                tv1.setText("" + sd);
            }
        });

    }
}