package com.example.schoolmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity implements View.OnClickListener {



    private EditText mailID , passwordID;
    private FirebaseAuth mAuth;
// ...
// Initialize Firebase Auth


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        mAuth = FirebaseAuth.getInstance();




    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){

            startActivity(new Intent(this,Login.class));


        }
    }

    @Override
    public void onClick(View view) {
        // Configure Google Sign In




//        if(view.getId()==R.id.buttondlprof && visible == false)
//        {
//            zbbitxt.setVisibility(View.VISIBLE);
//            visible= true;
//
//        }
//        else if (view.getId()==R.id.buttondlprof && visible == true)
//        {
//            zbbitxt.setVisibility(View.INVISIBLE);
//            visible= false;
//
//        }

    }
}