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
import com.example.gaursaurabh.faspire.FaspireLoginFile.UserLoginCheck;
import com.example.gaursaurabh.faspire.FaspireLoginFile.UserLoginUserId;
import com.example.gaursaurabh.faspire.Session.Session;

public class FaspireLogin extends AppCompatActivity {

    EditText mobile;
    Button login;
    ConnectionDetector connectionDetector;
    ProgressDialog progressDialog;
    UserLoginCheck userLoginCheck;
    UserLoginUserId userLoginUserId;

    Session session;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_faspire_login);

        session = new Session(this);

        connectionDetector = new ConnectionDetector(this);
        userLoginCheck = new UserLoginCheck();
        userLoginUserId = new UserLoginUserId();

        mobile = (EditText) findViewById(R.id.login_mobile);
        login = (Button) findViewById(R.id.login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connectionDetector.isConnected()){
                    String userMobile = "" + mobile.getText().toString();

                    if(userMobile.trim().length() == 0){
                        mobile.requestFocus();
                    } else {
                        new LoginUser(userMobile).execute();
                    }
                } else {
                    Toast.makeText(FaspireLogin.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public class LoginUser extends AsyncTask<Void,Void,Void>{

        String mobileLogin;
        String checkMobileNumber = "";
        String userIdGetSession = "";

        public LoginUser(String mobileLogin){
            this.mobileLogin = mobileLogin;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(FaspireLogin.this,"","Please wait...",false,false);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
            if(checkMobileNumber.equals("wrong")){
//                Toast.makeText(FaspireLogin.this, "Enter correct mobile", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(FaspireLogin.this,FaspireLogin.class));
                finish();
            }
        }

        @Override
        protected Void doInBackground(Void... voids) {

            checkMobileNumber = userLoginCheck.checkLoginUser(mobileLogin);

            if(checkMobileNumber.equals("user")){
                userIdGetSession = userLoginUserId.loginUserGetId(mobileLogin);

                session.setLoggedin(true);
                session.setUserLogin(userIdGetSession);
                Intent intent = new Intent(getApplicationContext(),FaspireHome.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
            if(checkMobileNumber.equals("wrong")){
                //Toast.makeText(FaspireLogin.this, "User Not Register", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),FaspireLogin.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
            return null;
        }
    }
}
