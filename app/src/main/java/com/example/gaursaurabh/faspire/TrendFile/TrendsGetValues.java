package com.example.gaursaurabh.faspire.TrendFile;

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
 * Created by Saurabh Gaur on 2/10/2017.
 */
public class TrendsGetValues {

    public static String[] getvaluesTrends(String id)
    {
        InputStream is = null;
        String line = null;
        String result = null;
        String temp_image = "",temp_headline = "",temp_description = "",temp_represent = "",temp_video = "";

        String[] arr_image,arr_headline,arr_description,arr_represent,arr_video;
        String getimage = null,getheadline = null,getdescription = null,getrepresent = null,getvideo = null;

        List<NameValuePair> loginEmailSend = new ArrayList<NameValuePair>(1);
        loginEmailSend.add(new BasicNameValuePair("id", id));

        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://www.faspire.in/faspire_android/show_trend.php");
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
                temp_image += json_data.getString("trends_image") + ":";
                temp_headline += json_data.getString("trends_headline") + ":";
                //temp_description += json_data.getString("trends_description") + ":";
                temp_represent += json_data.getString("trends_represent") + ":";
                temp_video += json_data.getString("trends_video") + ":";
            }

            arr_image = temp_image.split(":");
            arr_headline = temp_headline.split(":");
            //arr_description = temp_description.split(":");
            arr_represent = temp_represent.split(":");
            arr_video = temp_video.split(":");

            getimage = Arrays.toString(arr_image).replace("[", "").replace("]", "");
            getheadline = Arrays.toString(arr_headline).replace("[", "").replace("]", "");
            //getdescription = Arrays.toString(arr_description).replace("[", "").replace("]", "");
            getrepresent = Arrays.toString(arr_represent).replace("[", "").replace("]", "");
            getvideo = Arrays.toString(arr_video).replace("[", "").replace("]", "");

        } catch (Exception e) {

        }

        return new String[]
                {
                        getimage,getheadline,getdescription,getrepresent,getvideo

                };
    }
}
