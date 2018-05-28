package com.example.gaursaurabh.faspire.Session;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Saurabh Gaur on 7/11/2017.
 */
public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;
    String userid,userSession,userVerifiCode;

    public Session(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("fasireApp", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedin(boolean loggedin){
        editor.putBoolean("faspireLoggedIn",loggedin);
        editor.commit();
    }

    public boolean loggedin(){
        return prefs.getBoolean("faspireLoggedIn", false);
    }

    public void setUserLogin(String userConfirm){
        userSession = userConfirm;
        editor.putString("userFaspire",userSession);
        editor.commit();
    }

    public String getUserLogin(){
        return prefs.getString("userFaspire",userSession);
    }

    public void setUserVerifi(String userVerifi){
        userVerifiCode = userVerifi;
        editor.putString("userVerifi",userVerifiCode);
        editor.commit();
    }

    public String getUserVerifi(){
        return prefs.getString("userVerifi",userVerifiCode);
    }

}
