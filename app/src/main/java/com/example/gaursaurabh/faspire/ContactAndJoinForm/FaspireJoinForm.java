package com.example.gaursaurabh.faspire.ContactAndJoinForm;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Saurabh Gaur on 3/11/2017.
 */
public class FaspireJoinForm {

    public static void submitJoinFormValue(String name,String number,String email,String occupation,String query,String city)
    {
        InputStream is = null;

        List<NameValuePair> loginEmailSend = new ArrayList<NameValuePair>(1);
        loginEmailSend.add(new BasicNameValuePair("name", name));
        loginEmailSend.add(new BasicNameValuePair("number", number));
        loginEmailSend.add(new BasicNameValuePair("email", email));
        loginEmailSend.add(new BasicNameValuePair("occupation", occupation));
        loginEmailSend.add(new BasicNameValuePair("query", query));
        loginEmailSend.add(new BasicNameValuePair("city", city));

        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://www.faspire.in/faspire_android/faspire_join_form.php");
            httpPost.setEntity(new UrlEncodedFormEntity(loginEmailSend));
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
        } catch (Exception e) {

        }
    }
}
