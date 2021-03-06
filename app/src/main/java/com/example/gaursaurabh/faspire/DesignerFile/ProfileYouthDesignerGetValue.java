package com.example.gaursaurabh.faspire.DesignerFile;

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
 * Created by Saurabh Gaur on 3/9/2017.
 */
public class ProfileYouthDesignerGetValue {

    public static String[] getvaluesYouthDesigner(String id)
    {
        InputStream is = null;
        String line = null;
        String result = null;
        String temp_name = "",temp_profile_image = "",temp_specilization = "",temp_year_active = "",temp_city = "",
                temp_code = "",temp_experience = "",temp_image_first = "",temp_image_second = "",
                temp_image_third = "",temp_image_fourth = "",temp_image_fifth = "",temp_image_sixth = ""
                ,temp_gallery_first = "",temp_gallery_second = "",temp_gallery_third = "",temp_gallery_fourth = ""
                ,temp_gallery_fifth = "",temp_gallery_sixth = "",temp_video_first = "",temp_video_second = ""
                ,temp_video_third = "",temp_video_fourth = "",temp_video_fifth = "",temp_video_sixth = ""
                ,temp_fb_icon = "",temp_tw_icon = "",temp_insta_icon = "",temp_web_icon = "";

        String[] arr_name,arr_profile_image,arr_specilization,arr_year_active,arr_city,arr_code,
                arr_experience,arr_image_first,arr_image_second,arr_image_third,arr_image_fourth,arr_image_fifth,
                arr_image_sixth,arr_gallery_first,arr_gallery_second,arr_gallery_third,arr_gallery_fourth,
                arr_gallery_fifth,arr_gallery_sixth,arr_video_first,arr_video_second,arr_video_third,
                arr_video_fourth,arr_video_fifth,arr_video_sixth,arr_fb_icon,arr_tw_icon,arr_insta_icon,arr_web_icon;

        String getname = null,getprofile_image = null,getspecilization = null,getyear_active = null,getcity = null,
                getcode = null,getexperience = null,getimage_first = null,getimage_second = null,
                getimage_third = null,getimage_fourth = null,getimage_fifth = null,getimage_sixth = null,
                getgallery_first = null,getgallery_second = null,getgallery_third = null,getgallery_fourth = null,
                getgallery_fifth = null,getgallery_sixth = null,getvideo_first = null,getvideo_second = null,
                getvideo_third = null,getvideo_fourth = null,getvideo_fifth = null,getvideo_sixth = null
                ,getfb_icon = null,gettw_icon = null,getinsta_icon = null,getweb_icon = null;

        List<NameValuePair> loginEmailSend = new ArrayList<NameValuePair>(1);
        loginEmailSend.add(new BasicNameValuePair("id", id));

        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://www.faspire.in/faspire_android/profile_youth_designer.php");
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
                temp_name += json_data.getString("designer_name") + ":";
                temp_profile_image += json_data.getString("designer_profile_image") + ":";
                temp_specilization += json_data.getString("designer_specilization") + ":";
                temp_year_active += json_data.getString("designer_year_active") + ":";
                temp_city += json_data.getString("designer_city") + ":";
                temp_code += json_data.getString("designer_code") + ":";
                temp_experience += json_data.getString("designer_experience") + ":";
                temp_image_first += json_data.getString("designer_image_first") + ":";
                temp_image_second += json_data.getString("designer_image_second") + ":";
                temp_image_third += json_data.getString("designer_image_third") + ":";
                temp_image_fourth += json_data.getString("designer_image_fourth") + ":";
                temp_image_fifth += json_data.getString("designer_image_fifth") + ":";
                temp_image_sixth += json_data.getString("designer_image_sixth") + ":";
                temp_gallery_first += json_data.getString("designer_gallery_first") + ":";
                temp_gallery_second += json_data.getString("designer_gallery_second") + ":";
                temp_gallery_third += json_data.getString("designer_gallery_third") + ":";
                temp_gallery_fourth += json_data.getString("designer_gallery_fourth") + ":";
                temp_gallery_fifth += json_data.getString("designer_gallery_fifth") + ":";
                temp_gallery_sixth += json_data.getString("designer_gallery_sixth") + ":";
                temp_video_first += json_data.getString("designer_video_first") + ":";
                temp_video_second += json_data.getString("designer_video_second") + ":";
                temp_video_third += json_data.getString("designer_video_third") + ":";
                temp_video_fourth += json_data.getString("designer_video_fourth") + ":";
                temp_video_fifth += json_data.getString("designer_video_fifth") + ":";
                temp_video_sixth += json_data.getString("designer_video_sixth") + ":";
                temp_fb_icon += json_data.getString("designer_fb") + ":";
                temp_tw_icon += json_data.getString("designer_twitter") + ":";
                temp_insta_icon += json_data.getString("designer_insta") + ":";
                temp_web_icon += json_data.getString("designer_web") + ":";

            }


            arr_name = temp_name.split(":");
            arr_profile_image = temp_profile_image.split(":");
            arr_specilization = temp_specilization.split(":");
            arr_year_active = temp_year_active.split(":");
            arr_city = temp_city.split(":");
            arr_code = temp_code.split(":");
            arr_experience = temp_experience.split(":");
            arr_image_first = temp_image_first.split(":");
            arr_image_second = temp_image_second.split(":");
            arr_image_third = temp_image_third.split(":");
            arr_image_fourth = temp_image_fourth.split(":");
            arr_image_fifth = temp_image_fifth.split(":");
            arr_image_sixth = temp_image_sixth.split(":");
            arr_gallery_first = temp_gallery_first.split(":");
            arr_gallery_second = temp_gallery_second.split(":");
            arr_gallery_third = temp_gallery_third.split(":");
            arr_gallery_fourth = temp_gallery_fourth.split(":");
            arr_gallery_fifth = temp_gallery_fifth.split(":");
            arr_gallery_sixth = temp_gallery_sixth.split(":");
            arr_video_first = temp_video_first.split(":");
            arr_video_second = temp_video_second.split(":");
            arr_video_third = temp_video_third.split(":");
            arr_video_fourth = temp_video_fourth.split(":");
            arr_video_fifth = temp_video_fifth.split(":");
            arr_video_sixth = temp_video_sixth.split(":");
            arr_fb_icon = temp_fb_icon.split(":");
            arr_tw_icon = temp_tw_icon.split(":");
            arr_insta_icon = temp_insta_icon.split(":");
            arr_web_icon = temp_web_icon.split(":");


            getname = Arrays.toString(arr_name).replace("[", "").replace("]", "");
            getprofile_image = Arrays.toString(arr_profile_image).replace("[", "").replace("]", "");
            getspecilization = Arrays.toString(arr_specilization).replace("[", "").replace("]", "");
            getyear_active = Arrays.toString(arr_year_active).replace("[", "").replace("]", "");
            getcity = Arrays.toString(arr_city).replace("[", "").replace("]", "");
            getcode = Arrays.toString(arr_code).replace("[", "").replace("]", "");
            getexperience = Arrays.toString(arr_experience).replace("[", "").replace("]", "");
            getimage_first = Arrays.toString(arr_image_first).replace("[","").replace("]","");
            getimage_second = Arrays.toString(arr_image_second).replace("[","").replace("]","");
            getimage_third = Arrays.toString(arr_image_third).replace("[","").replace("]","");
            getimage_fourth = Arrays.toString(arr_image_fourth).replace("[","").replace("]","");
            getimage_fifth = Arrays.toString(arr_image_fifth).replace("[","").replace("]","");
            getimage_sixth = Arrays.toString(arr_image_sixth).replace("[","").replace("]","");
            getgallery_first = Arrays.toString(arr_gallery_first).replace("[","").replace("]","");
            getgallery_second = Arrays.toString(arr_gallery_second).replace("[","").replace("]","");
            getgallery_third = Arrays.toString(arr_gallery_third).replace("[","").replace("]","");
            getgallery_fourth = Arrays.toString(arr_gallery_fourth).replace("[","").replace("]","");
            getgallery_fifth = Arrays.toString(arr_gallery_fifth).replace("[","").replace("]","");
            getgallery_sixth = Arrays.toString(arr_gallery_sixth).replace("[","").replace("]","");
            getvideo_first = Arrays.toString(arr_video_first).replace("[","").replace("]","");
            getvideo_second = Arrays.toString(arr_video_second).replace("[","").replace("]","");
            getvideo_third = Arrays.toString(arr_video_third).replace("[","").replace("]","");
            getvideo_fourth = Arrays.toString(arr_video_fourth).replace("[","").replace("]","");
            getvideo_fifth = Arrays.toString(arr_video_fifth).replace("[","").replace("]","");
            getvideo_sixth = Arrays.toString(arr_video_sixth).replace("[","").replace("]","");
            getfb_icon = Arrays.toString(arr_fb_icon).replace("[","").replace("]","");
            gettw_icon = Arrays.toString(arr_tw_icon).replace("[","").replace("]","");
            getinsta_icon = Arrays.toString(arr_insta_icon).replace("[","").replace("]","");
            getweb_icon = Arrays.toString(arr_web_icon).replace("[","").replace("]","");



        } catch (Exception e) {

        }


        return new String[]
                {
                        getname,getprofile_image,getspecilization,getyear_active,getcity,getcode,getexperience,getimage_first
                        ,getimage_second,getimage_third,getimage_fourth,getimage_fifth,getimage_sixth,getgallery_first
                        ,getgallery_second,getgallery_third,getgallery_fourth,getgallery_fifth,getgallery_sixth
                        ,getvideo_first,getvideo_second,getvideo_third,getvideo_fourth,getvideo_fifth,getvideo_sixth
                        ,getfb_icon,gettw_icon,getinsta_icon,getweb_icon
                };
    }
}
