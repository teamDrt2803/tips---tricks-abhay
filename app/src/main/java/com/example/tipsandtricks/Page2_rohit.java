package com.example.tipsandtricks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class Page2_rohit extends AppCompatActivity {
    public static final String msg2 = "com.example.staticstics.msg2";
    // ArrayList<Integer> abcd = new ArrayList();
    ArrayList<Double> abcd = new ArrayList<>();


    String a;
    Button bt,resetBt;
    ListView show;
    int n,t;
    Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2_rohit);
        it = getIntent();
        //String[] msg2 = it.getStringArrayExtra(MainActivity.msg1);
        String val2 = it.getStringExtra(Statistics.msg1);
        EditText et = findViewById(R.id.val);
        TextView count = (TextView)findViewById(R.id.textView2);
        ArrayAdapter<Double> adp = new ArrayAdapter<Double>(Page2_rohit.this, android.R.layout.simple_list_item_1, abcd);
        n = Integer.parseInt(val2);
        t = n;
        show = (ListView)findViewById(R.id.list);
        bt = (Button)findViewById(R.id.button2);
        resetBt = (Button) findViewById(R.id.reset);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void  onClick(View v){
                String getInput = et.getText().toString();
                if (abcd.contains(getInput)) {
                    Toast.makeText(getBaseContext(), "items already there", Toast.LENGTH_LONG).show();
                } else if (getInput == null || getInput.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "empty", Toast.LENGTH_LONG).show();
                } else {
                    // int ct = t - n + 1;
                    //   count.setText("Count " + ct);
                    abcd.add(Double.valueOf(getInput));
                    show.setAdapter(adp);
                    ((EditText) findViewById(R.id.val)).setText("");
                    n--;
                    int ct1 = t - n + 1;
                    String s = "Enter value no: " + ct1;
                    et.setHint(s);
                    if (n <= 0) {
                        et.setHint("Enter Value 1");
                        n = t;
                        openNewact();
                    }
                }


            }
        });
        resetBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abcd.clear();
                adp.notifyDataSetChanged();
            }
        });


        //txt.setText(Arrays.toString(msg2));
        //String tb = "Welcome " + msg2;
        //txt.setText(tb);




    }

    private void openNewact() {
        Intent it2 = new Intent(this,Page3_rohit.class);
        it2.putExtra(msg2 , abcd);
        startActivity(it2);
    }



//    public void TakeInput(View view) {
//
//            //TextView txt = findViewById(R.id.textView2);
//
//            //txt.setText(t-n+1);
//
//             a = et.getText().toString();
//            abcd.add(a);
//            et.clearComposingText();
//            n--;
//
//
//    }
}
