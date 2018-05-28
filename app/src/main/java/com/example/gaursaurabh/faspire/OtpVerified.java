package com.example.gaursaurabh.faspire;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.Session.Session;

public class OtpVerified extends AppCompatActivity {

    EditText otp_enter;
    Button otp_verified;
    Session session;
    String otpValue;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_otp_verified);

        session = new Session(this);
        otpValue = session.getUserVerifi();

        Toast.makeText(this, session.getUserVerifi(), Toast.LENGTH_SHORT).show();

        otp_enter = (EditText) findViewById(R.id.otp_edit);
        otp_verified = (Button) findViewById(R.id.otp_btn);

        otp_verified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OtpVerified.this, otpValue, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
