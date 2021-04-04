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
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity implements View.OnClickListener {

    private TextView banner,register;
    private EditText name,email,password,contact;

    private ProgressBar p2;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        mAuth = FirebaseAuth.getInstance();
        banner = (TextView)findViewById(R.id.textView4);
        banner.setOnClickListener(this);
        register = (Button)findViewById(R.id.button2);
        register.setOnClickListener(this);

        name = (EditText)findViewById(R.id.edit3);
        email = (EditText)findViewById(R.id.edit4);
        password = (EditText)findViewById(R.id.edit5);
        contact = (EditText)findViewById(R.id.edit6);

        p2 = (ProgressBar)findViewById(R.id.progressBar2);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.textView4:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.button2:
                registeruser();
                break;

        }
    }

    private void registeruser() {
        String n = name.getText().toString().trim();
        String e = email.getText().toString().trim();
        String p = password.getText().toString().trim();
        String c = contact.getText().toString().trim();

        if(n.isEmpty()){
            name.setError("Full Name is required!");
            name.requestFocus();
            return;
        }
        if(e.isEmpty()){
            email.setError("Email is required!");
            email.requestFocus();
            return;
        }

        if(c.isEmpty()){
            contact.setError("Contact is required!");
            contact.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(e).matches()){
            email.setError("Please provide valid Email!");
            email.requestFocus();
            return;
        }

        if(p.isEmpty()){
            password.setError("Password is Required");
            password.requestFocus();
            return;
        }
        if(p.length() < 6){
            password.setError("Minimum 6 characters required!");
            password.requestFocus();
            return;
        }

        p2.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(e,p)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            User user = new User(n,c,e);
                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()){
                                        Toast.makeText(register.this,"User has been registered Successfully!",Toast.LENGTH_LONG).show();
                                        p2.setVisibility(View.GONE);
                                        Intent intent = new Intent(register.this,MainActivity.class);
                                        startActivity(intent);


                                    }else{
                                        Toast.makeText(register.this,"Failed to register..! Try Again!",Toast.LENGTH_LONG).show();
                                        p2.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }else{
                            Toast.makeText(register.this,"Failed to register..! Try Again!",Toast.LENGTH_LONG).show();
                            p2.setVisibility(View.GONE);
                        }
                    }
                });
    }
}