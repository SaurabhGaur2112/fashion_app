package com.example.gaursaurabh.faspire.FaspireLoginFile;

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
 * Created by Saurabh Gaur on 11/25/2017.
 */

public class UserLoginCheck {

    InputStream is = null;
    String line = null;
    String result = null;
    String temp = "";
    String[] arr;
    String mobileUser;

    public String checkLoginUser(String loginMobile){
        List<NameValuePair> loginEmailSend = new ArrayList<NameValuePair>(1);
        loginEmailSend.add(new BasicNameValuePair("webloginmobile", loginMobile));
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://www.faspire.in/faspire_android/faspire_user_exists.php");
            httpPost.setEntity(new UrlEncodedFormEntity(loginEmailSend));
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
                temp += json_data.getString("getUserExists") + ":";
            }

            arr = temp.split(":");

            mobileUser = Arrays.toString(arr).replace("[", "").replace("]", "");

        } catch (Exception e) {

        }
        return mobileUser;
    }

}
