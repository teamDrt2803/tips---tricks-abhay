package com.example.tipsandtricks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class resetPassword extends AppCompatActivity {

    private EditText editTextEmail;
    private Button b5;
    private ProgressBar p3;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_pass);

        p3 = (ProgressBar)findViewById(R.id.progressBar3);
        editTextEmail = (EditText)findViewById(R.id.edit9);
        auth = FirebaseAuth.getInstance();
        b5 = (Button)findViewById(R.id.button3);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change();
            }

            private void change() {

                String email = editTextEmail.getText().toString().trim();

                if(email.isEmpty()){
                    editTextEmail.setError("Email is required!");
                    editTextEmail.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    editTextEmail.setError("Please provide valid Email!");
                    editTextEmail.requestFocus();
                    return;
                }

                p3.setVisibility(View.VISIBLE);
                auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(resetPassword.this,"Check your Email to reset Password",Toast.LENGTH_LONG).show();
                            p3.setVisibility(View.GONE);
                        }else{
                            Toast.makeText(resetPassword.this,"Try Again!",Toast.LENGTH_LONG).show();
                            p3.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
    }
}