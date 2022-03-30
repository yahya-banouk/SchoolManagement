package com.example.schoolmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    Button loginbtnID ;
    Button registerBtnID ;
    EditText mailsignUpID ;
    EditText passworsignUpdID ;


    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen);
        loginbtnID = findViewById(R.id.loginBtnID);
        registerBtnID= findViewById(R.id.registerBtnID);
        mailsignUpID = findViewById(R.id.mailsignUpID);
        passworsignUpdID = findViewById(R.id.passworsignUpdID);


        mAuth = FirebaseAuth.getInstance();
        registerBtnID.setOnClickListener(view -> {
            creatUser();
        });
        loginbtnID.setOnClickListener(view -> {
            startActivity(new Intent(this,Login.class));


        });



    }

    private void creatUser()
    {
        String email = mailsignUpID.getText().toString();
        String password = passworsignUpdID.getText().toString();
        if(TextUtils.isEmpty(email))
        {
            mailsignUpID.setError("Email cannot be emty");
            mailsignUpID.requestFocus();

        }else  if(TextUtils.isEmpty(password))
        {
            passworsignUpdID.setError("Password cannot be emty");
            passworsignUpdID.requestFocus();
        }
        else
        {
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(Register.this,"successfully done",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this,Login.class));

                    }
                    else
                    {
                        Toast.makeText(Register.this,"Registration Error :"+task.getException().getMessage().toString(),Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(Register.this,Login.class));

                    }
                }
            });
        }

    }
}