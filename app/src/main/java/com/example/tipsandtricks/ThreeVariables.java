package com.example.tipsandtricks;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ThreeVariables extends AppCompatActivity {

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
        setContentView(R.layout.three_variables);

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
        a3 = (EditText) findViewById(R.id.a3);
        b1 = (EditText) findViewById(R.id.b1);
        b2 = (EditText) findViewById(R.id.b2);
        b3 = (EditText) findViewById(R.id.b3);
        c1 = (EditText) findViewById(R.id.c1);
        c2 = (EditText) findViewById(R.id.c2);
        c3 = (EditText) findViewById(R.id.c3);
        d1 = (EditText) findViewById(R.id.d1);
        d2 = (EditText) findViewById(R.id.d2);
        d3 = (EditText) findViewById(R.id.d3);
        rx = (TextView) findViewById(R.id.rx);
        ry = (TextView) findViewById(R.id.ry);
        rz = (TextView) findViewById(R.id.rz);

        p[1] = a1.getText().toString();
        p[2] = a2.getText().toString();
        p[3] = a3.getText().toString();
        q[1] = b1.getText().toString();
        q[2] = b2.getText().toString();
        q[3] = b3.getText().toString();
        r[1] = c1.getText().toString();
        r[2] = c2.getText().toString();
        r[3] = c3.getText().toString();
        s[1] = d1.getText().toString();
        s[2] = d2.getText().toString();
        s[3] = d3.getText().toString();

        for (i = 1; i < 4; i++) {

            if ((p[i].equals(null) && q[i].equals(null) && r[i].equals(null))
                    || (p[i].equals("") && q[i].equals("") && r[i].equals(""))) {

                String result = "Please enter a value";
                rx.setText(result);
                ry.setText(result);
                rz.setText(result);

                return false;
            } else {
                // converting string to int.
                for (j = 1; j < 4; j++) {

                    a[j] = Integer.parseInt(p[j]);
                    b[j] = Integer.parseInt(q[j]);
                    c[j] = Integer.parseInt(r[j]);
                    d[j] = Integer.parseInt(s[j]);


                }
            }
        }


        return true;
    }
    public void clr()
    {
        a1 = (EditText) findViewById(R.id.a1);
        a2 = (EditText) findViewById(R.id.a2);
        a3 = (EditText) findViewById(R.id.a3);
        b1 = (EditText) findViewById(R.id.b1);
        b2 = (EditText) findViewById(R.id.b2);
        b3 = (EditText) findViewById(R.id.b3);
        c1 = (EditText) findViewById(R.id.c1);
        c2 = (EditText) findViewById(R.id.c2);
        c3 = (EditText) findViewById(R.id.c3);
        d1 = (EditText) findViewById(R.id.d1);
        d2 = (EditText) findViewById(R.id.d2);
        d3 = (EditText) findViewById(R.id.d3);
        rx = (TextView) findViewById(R.id.rx);
        ry = (TextView) findViewById(R.id.ry);
        rz = (TextView) findViewById(R.id.rz);
        a1.getText().clear();
        a2.getText().clear();
        a3.getText().clear();
        b1.getText().clear();
        b2.getText().clear();
        b3.getText().clear();
        c1.getText().clear();
        c2.getText().clear();
        c3.getText().clear();
        d1.getText().clear();
        d2.getText().clear();
        d3.getText().clear();
        rx.setText("");
        rx.setHint("Result x");
        ry.setText("");
        ry.setHint("Result y");
        rz.setText("");
        rz.setHint("Result z");

    }

    public void calc() {

        // get the input numbers
        if (getNumbers()) {



/*System.out.println("Your Equations are in the form :\n a1x + b1y + c1z = d1--------1\n a2x + b2y + c2z = d2--------2\n a3x + b3y + c3z = d3--------3\n");
            System.out.println("Enter Coefficients For First Equation\n");
            System.out.print("\nEnter a1:\t");
    a[1]=input.nextFloat();
            System.out.print("\nEnter b1:\t");
    b[1]=input.nextFloat();
            System.out.print("\nEnter c1:\t");
    c[1]=input.nextFloat();
            System.out.print("\nEnter d1:\t");
    d[1]=input.nextFloat();
            System.out.println("\nEnter Coefficients For Second Equation\n");
            System.out.print("\nEnter a2:\t");
    a[2]=input.nextFloat();
            System.out.print("\nEnter b2:\t");
    b[2]=input.nextFloat();
            System.out.print("\nEnter c2:\t");
    c[2]=input.nextFloat();
            System.out.print("\nEnter d2:\t");
    d[2]=input.nextFloat();
            System.out.println("\nEnter Coefficients For Third Equation\n");
            System.out.print("\nEnter a3:\t");
    a[3]=input.nextFloat();
            System.out.print("\nEnter b3:\t");
    b[3]=input.nextFloat();
            System.out.print("\nEnter c3:\t");
    c[3]=input.nextFloat();
            System.out.print("\nEnter d3:\t");
    d[3]=input.nextFloat();
            System.out.printf("\nYour Entered Equations are :\n %fx + %fy + %fz = %f--------1\n %fx + %fy + %fz = %f--------2\n %fx + %fy + %fz = %f--------3\n\n\n",a[1],b[1],c[1],d[1],a[2],b[2],c[2],d[2],a[3],b[3],c[3],d[3]);
            System.out.println("We Solve these three Equations By Equating The Coefficients Method\n\n");
            System.out.println("First we reduce two equations to two variables and then solve those two equations to get the values for two variables\n");
            System.out.println("Step I: \tMultiplying Equation 1 by coefficient of x of 2 equation i.e."+a[2]+" and \n\t\tMultiplying Equation 2 by original coefficient of x of 1 equation i.e."+a[1]);*/
            tempa = a[1];
            tempb = b[1];
            tempc = c[1];
            tempd = d[1];
            a[1] = a[1] * a[2];
            b[1] = b[1] * a[2];
            c[1] = c[1] * a[2];
            d[1] = d[1] * a[2];
            a[2] = a[2] * tempa;
            b[2] = b[2] * tempa;
            c[2] = c[2] * tempa;
            d[2] = d[2] * tempa;
            /*System.out.printf("\n\t\tTwo Equations Are : \n \t\t%fx + %fy +%fz = %f--------3\n\n \t\t%fx + %fy + %fz = %f--------4\n\n",a[1],b[1],c[1],d[1],a[2],b[2],c[2],d[2]);
            System.out.println("\t\tNow Subtracting Equations 3 & 4 we get\n\n");*/
            ta = a[1] - a[2];
            tb = b[1] - b[2];
            tc = c[1] - c[2];
            td = d[1] - d[2];
            /*System.out.printf("\n\t\tFirst Simplified Equation is:\n \t\t%fy + %fz = %f--------A\n\n",tb,tc,td);
            System.out.println("Step II: \tMultiplying Equation 1 by coefficient of x of 3 equation i.e. "+a[3]+" and \n\t\tMultiplying Equation 3 by original coefficient of x of 1 equation i.e."+tempa);*/
            a[1] = tempa * a[3];
            b[1] = tempb * a[3];
            c[1] = tempc * a[3];
            d[1] = tempd * a[3];
            a[3] = a[3] * tempa;
            b[3] = b[3] * tempa;
            c[3] = c[3] * tempa;
            d[3] = d[3] * tempa;
            /*System.out.printf("\t\tTwo Equations Are : \n \t\t%fx + %fy +%fz = %f--------5\n\n \t\t%fx + %fy + %fz = %f--------6\n\n",a[1],b[1],c[1],d[1],a[3],b[3],c[3],d[3]);
            System.out.println("\t\tNow Subtracting Equations 5 & 6 we get\n\n");*/
            aa = a[1] - a[3];
            bb = b[1] - b[3];
            cc = c[1] - c[3];
            dd = d[1] - d[3];
            /*System.out.printf("\n\t\tSecond Simplified Equation is:\n \t\t%fy + %fz = %f--------B\n\n",bb,cc,dd);
            System.out.println("Step III : \tSolving Equations A and B we get y & z\n\n");*/
            temp = tb;
            tb = tb * bb;
            tc = tc * bb;
            td = td * bb;
            bb = bb * temp;
            cc = cc * temp;
            dd = dd * temp;
            tb = tb - bb;
            tc = tc - cc;
            td = td - dd;
            z = td / tc;
            y = (dd - cc * z) / bb;
            /*System.out.printf("\t\ty=%f \t\t && \t\tz=%f\n\n",y,z);
            System.out.println("Step IV : \tPut y & z in any equation and solve for x\n\n");*/
            x = (tempd - tempb * y - tempc * z) / tempa;
            /*System.out.printf("\nSolution of your Entered Equations is:\n x=%f\n y=%f\n z=%f\n",x,y,z);*/
            rx.setText(Float.toString(x));
            ry.setText(Float.toString(y));
            rz.setText(Float.toString(z));
        }
    }
}