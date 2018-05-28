package com.example.gaursaurabh.faspire.UserLoginSignup;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by Saurabh Gaur on 11/11/2017.
 */

public class UserSignup extends AsyncTask<Void, Void, Void> {

    String username,email,mobile;
    ProgressDialog progressDialog;
    String getUserEmailExists = "";
    String getUserSignupId = "";
    Context context;

    public UserSignup(String username,String email,String mobile,Context context){
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context,"","Please wait...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }
}
