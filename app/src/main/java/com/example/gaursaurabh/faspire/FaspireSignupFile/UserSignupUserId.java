package com.example.gaursaurabh.faspire.FaspireSignupFile;

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
 * Created by Saurabh Gaur on 11/21/2017.
 */

public class UserSignupUserId {

    InputStream is = null;
    String line = null;
    String result = null;
    String temp = "";
    String[] arr;
    String getSignupUseridValue;

    public String getSignupUserId(String mobile){
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
        nameValuePairs.add(new BasicNameValuePair("signupmobile", mobile));

        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://www.faspire.in/faspire_android/faspire_signup_userid.php");
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
        } catch (Exception e) {

        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuffer sb = new StringBuffer();
            while ((line = reader.readLine()) != null)
                sb.append(line + "\n");
            result = sb.toString();
            is.close();
        } catch (Exception e) {

        }
        try {
            JSONArray jArray = new JSONArray(result);
            int count = jArray.length();

            for (int i = 0; i < count; i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                temp += json_data.getString("user_id") + ":";
            }

            arr = temp.split(":");

            getSignupUseridValue = Arrays.toString(arr).replace("[", "").replace("]", "");

        } catch (Exception e) {

        }
        return getSignupUseridValue;
    }
}
