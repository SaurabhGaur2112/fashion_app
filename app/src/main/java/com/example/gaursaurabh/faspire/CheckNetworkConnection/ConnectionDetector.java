package com.example.gaursaurabh.faspire.CheckNetworkConnection;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Saurabh Gaur on 2/5/2017.
 */
public class ConnectionDetector {

    Context context;

    public ConnectionDetector(Context context)
    {
        this.context = context;
    }

    public boolean isConnected(){
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Service.CONNECTIVITY_SERVICE);

        if(connectivity!=null){
            NetworkInfo info = connectivity.getActiveNetworkInfo();

            if(info != null){
                if(info.getState() == NetworkInfo.State.CONNECTED){
                    return true;
                }
            }
        }
        return false;
    }
}
