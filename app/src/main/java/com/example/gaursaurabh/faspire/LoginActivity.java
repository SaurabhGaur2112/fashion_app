package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.Session.Session;

import java.util.Random;

public class LoginActivity extends AppCompatActivity {

    //Random random;
    LinearLayout signup;
    TextView login;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        session = new Session(this);

        if(session.loggedin()){
            startActivity(new Intent(LoginActivity.this,FaspireHome.class));
            finish();
        }

        signup = (LinearLayout) findViewById(R.id.signupLayout);
        login = (TextView) findViewById(R.id.loginLayout);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,FaspireSignup.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,FaspireLogin.class));
            }
        });

        //random = new Random();
        //int value = (random.nextInt(1000) + 999);
        //Toast.makeText(this, String.valueOf(value) , Toast.LENGTH_SHORT).show();
    }
}
