package com.example.tipsandtricks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView register,change;
    private EditText editTextEmail, editTextPassword;
    private Button signIn;
    private ProgressBar p1;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        register = (TextView) findViewById(R.id.textView3);
        register.setOnClickListener(this);

        editTextEmail = (EditText) findViewById(R.id.edit1);
        editTextPassword = (EditText) findViewById(R.id.edit2);

        signIn = (Button) findViewById(R.id.button1);
        signIn.setOnClickListener(this);

        change = (TextView)findViewById(R.id.textView2);
        change.setOnClickListener(this);

        p1 = (ProgressBar)findViewById(R.id.progressBar);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView3:
                startActivity(new Intent(this, register.class));
                break;

            case R.id.button1:
                userLogin();
                break;

            case R.id.textView2:
                startActivity(new Intent(this,resetPassword.class));
                break;
        }
    }

    private void userLogin() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required!");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please provide valid Email!");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length() < 6){
            editTextPassword.setError("Minimum 6 characters required!");
            editTextPassword.requestFocus();
            return;
        }

        p1.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    startActivity(new Intent(MainActivity.this,app_1st.class));
                    p1.setVisibility(View.GONE);

                }else{
                    Toast.makeText(MainActivity.this,"Failed to login! Please put valid Email Address or Password!.",Toast.LENGTH_LONG).show();
                    p1.setVisibility(View.GONE);
                }
            }
        });
    }
}