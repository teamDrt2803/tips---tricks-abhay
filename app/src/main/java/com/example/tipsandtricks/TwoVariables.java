package com.example.tipsandtricks;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class TwoVariables extends AppCompatActivity {

    EditText a1, a2, a3, b1, b2, b3, c1, c2, c3, d1, d2, d3;
    TextView rx, ry, rz;
    float a[] = new float[4];
    float b[] = new float[4];
    float c[] = new float[4];
    float d[] = new float[4];
    float tempa, tempb, tempc, tempd, ta, tb, tc, td, aa, bb, cc, dd, temp, x, y, z;
    String p[] = new String[4];
    String q[] = new String[4];
    String r[] = new String[4];
    String s[] = new String[4];

    int i;
    int j;
    Button btn1;
    Button btn2;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_variables);

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

        a1 = (EditText) findViewById(R.id.a1);
        a2 = (EditText) findViewById(R.id.a2);
        b1 = (EditText) findViewById(R.id.b1);
        b2 = (EditText) findViewById(R.id.b2);
        c1 = (EditText) findViewById(R.id.c1);
        c2 = (EditText) findViewById(R.id.c2);
        rx = (TextView) findViewById(R.id.rx);
        ry = (TextView) findViewById(R.id.ry);

        p[1] = a1.getText().toString();
        p[2] = a2.getText().toString();
        q[1] = b1.getText().toString();
        q[2] = b2.getText().toString();
        r[1] = c1.getText().toString();
        r[2] = c2.getText().toString();

        for (i = 1; i < 3; i++) {

            if ((p[i].equals(null) && q[i].equals(null) && r[i].equals(null))
                    || (p[i].equals("") && q[i].equals("") && r[i].equals(""))) {

                String result = "Please enter a value";
                rx.setText(result);
                ry.setText(result);

                return false;
            } else {
                // converting string to int.
                for (j = 1; j < 3; j++) {

                    a[j] = Integer.parseInt(p[j]);
                    b[j] = Integer.parseInt(q[j]);
                    c[j] = Integer.parseInt(r[j]);


                }
            }
        }


        return true;
    }
    public void clr()
    {
        a1 = (EditText) findViewById(R.id.a1);
        a2 = (EditText) findViewById(R.id.a2);
        b1 = (EditText) findViewById(R.id.b1);
        b2 = (EditText) findViewById(R.id.b2);
        c1 = (EditText) findViewById(R.id.c1);
        c2 = (EditText) findViewById(R.id.c2);
        rx = (TextView) findViewById(R.id.rx);
        ry = (TextView) findViewById(R.id.ry);
        a1.getText().clear();
        a2.getText().clear();
        b1.getText().clear();
        b2.getText().clear();
        c1.getText().clear();
        c2.getText().clear();
        rx.setText("");
        rx.setHint("Result x");
        ry.setText("");
        ry.setHint("Result y");

    }

    public void calc() {

        // get the input numbers
        if (getNumbers()) {

            /*System.out.println("Your Equations are in the form:\n a1x + b1y = c1\n a2x + b2y = c2\n");
            System.out.println("\nEnter Value For a1\t");
            a[1]=input.nextInt();
            //System.out.println("\nEnter Value For b1\t");
            b[1]=input.nextInt();
            //System.out.println("\nEnter Value For a2\t");
            a[2]=input.nextInt();
            //System.out.println("\nEnter Value For b2\t");
            b[2]=input.nextInt();
            //System.out.println("\nEnter Value For c1\t");
            c[1]=input.nextInt();
            //System.out.println("\nEnter Value For c2\t");
            c[2]=input.nextInt();
            /*System.out.printf("Your Entered Equations Are:\n\n %fx + %fy = %f--------1\n %fx + %fy = %f--------2\n",a[1],b[1],c[1],a[2],b[2],c[2]);
            System.out.println("We will use equating the coefficients method for solving these equations\n\n\n");
            System.out.println("STEP I : \tMultiplying Equation 1 by coefficient of x of Equation 2 i.e. "+a[2]+" and Multiplying Equation 2 by original coefficient of x of 1 equation i.e.\t\t "+a[1]+" We get\n\n\n\n");*/
            temp=a[1];
            a[1]=a[1]*a[2];
            b[1]=b[1]*a[2];
            c[1]=c[1]*a[2];
            a[2]=a[2]*temp;
            b[2]=b[2]*temp;
            c[2]=c[2]*temp;
            /*System.out.printf("\t\t%fx + %fy = %f--------A\n \t\t%fx + %fy = %f--------B\n\n",a[1],b[1],c[1],a[2],b[2],c[2]);
            System.out.println("STEP II : \tSubtracting Equation B From Equation A we get:\n");*/
            ta=a[1]-a[2];
            tb=b[1]-b[2];
            tc=c[1]-c[2];
            /*System.out.printf("\t\t %fx + %fy = %f\n - \t\t %fx + %fy = %f\n \t\t ------------------------------------------\n \t\t %fx + %fy = %f\n",a[1],b[1],c[1],a[2],b[2],c[2],ta,tb,tc);
            System.out.printf("\t\t .'. %fy = %f\n",tb,tc);
            System.out.printf("\t\t .'. y= %f/%f\n",tc,tb);*/
            y=tc/tb;
            /*System.out.printf("\t\t .'. y = %f\n\n",y);
            System.out.printf("STEP III : \tPutting y=%f in Equation A we get\n\n",y);
            System.out.printf("\t\t %fx + %f(%f) = %f\n \t\t .'. %fx + %f = %f\n \t\t .'. %fx = %f - %f\n \t\t .'. %fx=%f\n \t\t .'. x = %f/%f\n \t\t .'. x = %f\n\n\n",a[1],b[1],y,c[1],a[1],b[1]*y,c[1],a[1],c[1],b[1]*y,a[1],c[1]-b[1]*y,c[1]-b[1]*y,a[1],(c[1]-b[1]*y)/a[1]);*/
            x=(c[1]-b[1]*y)/a[1];
            //System.out.println("Solution of Entered Equations is :\n x= "+x+"\ny= "+y);



            rx.setText(Float.toString(x));
            ry.setText(Float.toString(y));

        }
    }
}