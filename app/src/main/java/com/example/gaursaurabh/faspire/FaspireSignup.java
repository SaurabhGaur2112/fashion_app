package com.example.gaursaurabh.faspire;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.CheckNetworkConnection.ConnectionDetector;
import com.example.gaursaurabh.faspire.FaspireSignupFile.UserSignupCheck;
import com.example.gaursaurabh.faspire.FaspireSignupFile.UserSignupUserId;
import com.example.gaursaurabh.faspire.FaspireSignupFile.UserSignupValueInsert;
import com.example.gaursaurabh.faspire.FaspireSignupFile.UserVerificationCode;
import com.example.gaursaurabh.faspire.Session.Session;

public class FaspireSignup extends AppCompatActivity {

    EditText username,email,mobile,city;
    Button signup;
    ConnectionDetector connectionDetector;

    UserSignupCheck userSignupCheck;
    UserSignupValueInsert userSignupValueInsert;
    UserSignupUserId userSignupUserId;
    UserVerificationCode userVerificationCode;

    Session session;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_faspire_signup);

        connectionDetector = new ConnectionDetector(this);

        session = new Session(this);

        userSignupCheck = new UserSignupCheck();
        userSignupValueInsert = new UserSignupValueInsert();
        userSignupUserId = new UserSignupUserId();
        userVerificationCode = new UserVerificationCode();

        username = (EditText) findViewById(R.id.signup_username);
        email = (EditText) findViewById(R.id.signup_email);
        mobile = (EditText) findViewById(R.id.signup_mobile);
        signup = (Button) findViewById(R.id.signup_btn);
        city = (EditText) findViewById(R.id.signup_city);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connectionDetector.isConnected()){
                    String userName = "" + username.getText().toString();
                    String userEmail = "" + email.getText().toString();
                    String userMobile = "" + mobile.getText().toString();
                    String userCity = "" + city.getText().toString();

                    if(userName.trim().length() == 0){
                        username.requestFocus();
                    } else if(userEmail.trim().length() == 0){
                        email.requestFocus();
                    } else if(userMobile.trim().length() == 0){
                        mobile.requestFocus();
                    } else if(userCity.trim().length() == 0){
                        city.requestFocus();
                    }
                    else {
                        new SignupUserEnter(userName,userEmail,userMobile,userCity).execute();
                    }
                } else {
                    Toast.makeText(FaspireSignup.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public class SignupUserEnter extends AsyncTask<Void, Void, Void>{

        String username,email,mobile,city;
        ProgressDialog progressDialog;
        String getUserMobileExists = "";
        String getUserId = "";
        String getUserVerifi = "hello";

        public SignupUserEnter(String username,String email,String mobile,String city){
            this.username = username;
            this.email = email;
            this.mobile = mobile;
            this.city = city;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(FaspireSignup.this,"","Please wait...",false,false);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
            if(getUserMobileExists.equals("not insert")){
                Toast.makeText(FaspireSignup.this, "Number already exists", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(FaspireSignup.this,FaspireSignup.class));
                finish();
            }
        }

        @Override
        protected Void doInBackground(Void... voids) {
            getUserMobileExists = userSignupCheck.userCheckMobile(mobile);

            if(getUserMobileExists.equals("insert")){
                userSignupValueInsert.insertUserSignupValue(username,email,mobile,city);

                getUserId = userSignupUserId.getSignupUserId(mobile);
                getUserVerifi = userVerificationCode.getSignupVerifiCode(getUserId);

                session.setLoggedin(true);
                session.setUserLogin(getUserId);
                session.setUserVerifi(getUserVerifi);

                Intent intent = new Intent(getApplicationContext(), FaspireHome.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
            return null;
        }
    }
}
