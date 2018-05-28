package com.example.gaursaurabh.faspire.ActorFile;

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
 * Created by Saurabh Gaur on 2/7/2017.
 */
public class ProfileActorGetValue {

    public static String[] getvalueActor(String id)
    {
        InputStream is = null;
        String line = null;
        String result = null;
        String temp_name = "",temp_profile_image = "",temp_gender = "",temp_city = "",
                temp_style = "",temp_language = "",temp_code = "",temp_year_active = "",temp_height = ""
                ,temp_chest_brest = "",temp_waste = "",temp_hair_color = "",temp_eye_color = ""
                ,temp_shoe_size = "",temp_experience = "",temp_biography = ""
                ,temp_portfolio_first = "",temp_portfolio_second = "",temp_portfolio_third = "",temp_portfolio_fourth = ""
                ,temp_portfolio_fifth = "",temp_portfolio_sixth = "",temp_gallery_first = "",temp_gallery_second = ""
                ,temp_gallery_third = "",temp_gallery_fourth = "",temp_gallery_fifth = "",temp_gallery_sixth = ""
                ,temp_video_first = "",temp_video_second = "",temp_video_third = "",temp_video_fourth = "",
                temp_video_fifth = "",temp_video_sixth = "";

        String[] arr_name,arr_profile_image,arr_gender,arr_city,arr_style,arr_language,arr_code,arr_year_active,
                arr_height,arr_chest_brest,arr_waste,arr_hair_color,arr_eye_color,arr_shoe_size,arr_experience
                ,arr_biography,arr_portfolio_first,arr_portfolio_second,arr_portfolio_third,arr_portfolio_fourth
                ,arr_portfolio_fifth,arr_portfolio_sixth,arr_gallery_first,arr_gallery_second,arr_gallery_third
                ,arr_gallery_fourth,arr_gallery_fifth,arr_gallery_sixth,arr_video_first,arr_video_second
                ,arr_video_third,arr_video_fourth,arr_video_fifth,arr_video_sixth;

        String getname = null,getprofile_image = null,getgender = null,getcity = null,getstyle = null,getlanguage = null
                ,getcode = null,getyear_active = null,getheight = null,getchest_brest = null,getwaste = null
                ,gethair_color = null,geteye_color = null,getshoe_size = null,getexperience = null,getbiography = null
        ,getportfolio_first = null,getportfolio_second = null,getportfolio_third = null,getportfolio_fourth = null
                ,getportfolio_fifth = null,getportfolio_sixth = null,getgallery_first = null,getgallery_second = null
                ,getgallery_third = null,getgallery_fourth = null,getgallery_fifth = null,getgallery_sixth = null
                ,getvideo_first = null,getvideo_second = null,getvideo_third = null,getvideo_fourth = null
                ,getvideo_fifth = null,getvideo_sixth = null;

        List<NameValuePair> loginEmailSend = new ArrayList<NameValuePair>(1);
        loginEmailSend.add(new BasicNameValuePair("id", id));

        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://www.faspire.in/faspire_android/profile_actor.php");
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
                temp_name += json_data.getString("actor_name") + ":";
                temp_profile_image += json_data.getString("actor_profile_image") + ":";
                temp_gender += json_data.getString("actor_gender") + ":";
                temp_city += json_data.getString("actor_city") + ":";
                temp_style += json_data.getString("actor_style") + ":";
                temp_language += json_data.getString("actor_language") + ":";
                temp_code += json_data.getString("actor_code") + ":";
                temp_year_active += json_data.getString("actor_year_active") + ":";
                temp_height += json_data.getString("actor_height") + ":";
                temp_chest_brest += json_data.getString("actor_chest_brest") + ":";
                temp_waste += json_data.getString("actor_waste") + ":";
                temp_hair_color += json_data.getString("actor_hair_color") + ":";
                temp_eye_color += json_data.getString("actor_eye_color") + ":";
                temp_shoe_size += json_data.getString("actor_shoe_size") + ":";
                temp_experience += json_data.getString("actor_experience") + ":";
                temp_biography += json_data.getString("actor_biography") + ":";
                temp_portfolio_first += json_data.getString("actor_portfolio_first") + ":";
                temp_portfolio_second += json_data.getString("actor_portfolio_second") + ":";
                temp_portfolio_third += json_data.getString("actor_portfolio_third") + ":";
                temp_portfolio_fourth += json_data.getString("actor_portfolio_fourth") + ":";
                temp_portfolio_fifth += json_data.getString("actor_portfolio_fifth") + ":";
                temp_portfolio_sixth += json_data.getString("actor_portfolio_sixth") + ":";
                temp_gallery_first += json_data.getString("actor_gallery_first") + ":";
                temp_gallery_second += json_data.getString("actor_gallery_second") + ":";
                temp_gallery_third += json_data.getString("actor_gallery_third") + ":";
                temp_gallery_fourth += json_data.getString("actor_gallery_fourth") + ":";
                temp_gallery_fifth += json_data.getString("actor_gallery_fifth") + ":";
                temp_gallery_sixth += json_data.getString("actor_gallery_sixth") + ":";
                temp_video_first += json_data.getString("actor_video_first") + ":";
                temp_video_second += json_data.getString("actor_video_second") + ":";
                temp_video_third += json_data.getString("actor_video_third") + ":";
                temp_video_fourth += json_data.getString("actor_video_fourth") + ":";
                temp_video_fifth += json_data.getString("actor_video_fifth") + ":";
                temp_video_sixth += json_data.getString("actor_video_sixth") + ":";

            }


            arr_name = temp_name.split(":");
            arr_profile_image = temp_profile_image.split(":");
            arr_gender = temp_gender.split(":");
            arr_city = temp_city.split(":");
            arr_style = temp_style.split(":");
            arr_language = temp_language.split(":");
            arr_code = temp_code.split(":");
            arr_year_active = temp_year_active.split(":");
            arr_height = temp_height.split(":");
            arr_chest_brest = temp_chest_brest.split(":");
            arr_waste = temp_waste.split(":");
            arr_hair_color = temp_hair_color.split(":");
            arr_eye_color = temp_eye_color.split(":");
            arr_shoe_size = temp_shoe_size.split(":");
            arr_experience = temp_experience.split(":");
            arr_biography = temp_biography.split(":");
            arr_portfolio_first = temp_portfolio_first.split(":");
            arr_portfolio_second = temp_portfolio_second.split(":");
            arr_portfolio_third = temp_portfolio_third.split(":");
            arr_portfolio_fourth = temp_portfolio_fourth.split(":");
            arr_portfolio_fifth = temp_portfolio_fifth.split(":");
            arr_portfolio_sixth = temp_portfolio_sixth.split(":");
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


            getname = Arrays.toString(arr_name).replace("[", "").replace("]", "");
            getprofile_image = Arrays.toString(arr_profile_image).replace("[", "").replace("]", "");
            getgender = Arrays.toString(arr_gender).replace("[", "").replace("]", "");
            getcity = Arrays.toString(arr_city).replace("[", "").replace("]", "");
            getstyle = Arrays.toString(arr_style).replace("[", "").replace("]", "");
            getlanguage = Arrays.toString(arr_language).replace("[", "").replace("]", "");
            getcode = Arrays.toString(arr_code).replace("[", "").replace("]", "");
            getyear_active = Arrays.toString(arr_year_active).replace("[","").replace("]","");
            getheight = Arrays.toString(arr_height).replace("[","").replace("]","");
            getchest_brest = Arrays.toString(arr_chest_brest).replace("[","").replace("]","");
            getwaste = Arrays.toString(arr_waste).replace("[","").replace("]","");
            gethair_color = Arrays.toString(arr_hair_color).replace("[","").replace("]","");
            geteye_color = Arrays.toString(arr_eye_color).replace("[","").replace("]","");
            getshoe_size = Arrays.toString(arr_shoe_size).replace("[","").replace("]","");
            getexperience = Arrays.toString(arr_experience).replace("[","").replace("]","");
            getbiography = Arrays.toString(arr_biography).replace("[","").replace("]","");
            getportfolio_first = Arrays.toString(arr_portfolio_first).replace("[","").replace("]","");
            getportfolio_second = Arrays.toString(arr_portfolio_second).replace("[","").replace("]","");
            getportfolio_third = Arrays.toString(arr_portfolio_third).replace("[","").replace("]","");
            getportfolio_fourth = Arrays.toString(arr_portfolio_fourth).replace("[","").replace("]","");
            getportfolio_fifth = Arrays.toString(arr_portfolio_fifth).replace("[","").replace("]","");
            getportfolio_sixth = Arrays.toString(arr_portfolio_sixth).replace("[","").replace("]","");
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



        } catch (Exception e) {

        }


        return new String[]
                {
                        getname,getprofile_image,getgender,getcity,getstyle,getlanguage,getcode,getyear_active
                        ,getheight,getchest_brest,getwaste,gethair_color,geteye_color,getshoe_size
                        ,getexperience,getbiography,getportfolio_first,getportfolio_second,getportfolio_third
                        ,getportfolio_fourth,getportfolio_fifth,getportfolio_sixth,getgallery_first
                        ,getgallery_second,getgallery_third,getgallery_fourth,getgallery_fifth,getgallery_sixth
                        ,getvideo_first,getvideo_second,getvideo_third,getvideo_fourth,getvideo_fifth,getvideo_sixth
                };
    }
}