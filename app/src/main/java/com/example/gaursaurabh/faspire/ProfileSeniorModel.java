package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.ActorFile.ProfileActorGetValue;
import com.example.gaursaurabh.faspire.CheckNetworkConnection.ConnectionDetector;
import com.example.gaursaurabh.faspire.ModelFile.ProfileSeniorModelGetValue;
import com.example.gaursaurabh.faspire.Picasso.PicassoClient;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ProfileSeniorModel extends YouTubeBaseActivity {

    ImageView profileImg,portfolioImgFirst,portfolioImgSecond,portfolioImgThird,portfolioImgFourth,portfolioImgFifth
            ,portfolioImgSixth,galleryImgFirst,galleryImgSecond,galleryImgThird,galleryImgFourth,galleryImgFifth,galleryImgSixth;
    TextView name,gender,city,style,yearActive,language,height,chestBrest,waste,hairColor,eyeColor,shoeSize,experience,biography;

    String nameTxt,genderTxt,cityTxt,styleTxt,yearActiveTxt,langaugeTxt,heightTxt,chestBrestTxt,wasteTxt,hairColorTxt,
            eyeColorTxt,shoeSizeTxt,experiencetTxt,biographyTxt,profileImgTxt,portfolioImgFirstTxt,portfolioImgSecondTxt,portfolioImgThirdTxt
            ,portfolioImgFourthTxt,portfolioImgFifthTxt,portfolioImgSixthTxt,galleryFirstTxt,gallerySecondTxt,galleryThirdTxt
            ,galleryFourthTxt,galleryFifthTxt,gallerySixthTxt,codeTxt,videoFirstTxt,videoSecondTxt,videoThirdTxt,videoFourthTxt,
            videoFifthTxt,videoSixthTxt,fbTxt,twTxt,instaTxt,webTxt;

    ImageView fbIcon,twIcon,instaIcon,webIcon,contactIcon;

    ConnectionDetector cd;
    Intent intent;
    String getId;
    String IMAGE_URL = "http://www.faspire.in/faspire_android/senior_model_image/";
    ProfileSeniorModelGetValue profileSeniorModelGetValue;
    String get_details[];

    public static final String API_KEY = "AIzaSyBCVo6DdJKv471NPfWDSgt1fP1tIUAY_F8";
    YouTubePlayerView firstYouTube;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_senior_model);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        cd = new ConnectionDetector(this);
        profileSeniorModelGetValue = new ProfileSeniorModelGetValue();
        intent = getIntent();
        getId = intent.getStringExtra("seniorModelId");

        profileImg = (ImageView) findViewById(R.id.senior_mod_profileImg);
        portfolioImgFirst = (ImageView) findViewById(R.id.senior_mod_portfolioFirst);
        portfolioImgSecond = (ImageView) findViewById(R.id.senior_mod_portfolioSecond);
        portfolioImgThird = (ImageView) findViewById(R.id.senior_mod_portfolioThird);
        portfolioImgFourth = (ImageView) findViewById(R.id.senior_mod_portfolioFourth);
        portfolioImgFifth = (ImageView) findViewById(R.id.senior_mod_portfolioFifth);
        portfolioImgSixth = (ImageView) findViewById(R.id.senior_mod_portfolioSixth);
        galleryImgFirst = (ImageView) findViewById(R.id.senior_mod_galleryFirst);
        galleryImgSecond = (ImageView) findViewById(R.id.senior_mod_gallerySecond);
        galleryImgThird = (ImageView) findViewById(R.id.senior_mod_galleryThird);
        galleryImgFourth = (ImageView) findViewById(R.id.senior_mod_galleryFourth);
        galleryImgFifth = (ImageView) findViewById(R.id.senior_mod_galleryFifth);
        galleryImgSixth = (ImageView) findViewById(R.id.senior_mod_gallerySixth);

        fbIcon = (ImageView) findViewById(R.id.senior_model_facebook_icon);
        twIcon = (ImageView) findViewById(R.id.senior_model_twitter_icon);
        instaIcon = (ImageView) findViewById(R.id.senior_model_instagram_icon);
        webIcon = (ImageView) findViewById(R.id.senior_model_website_icon);
        contactIcon = (ImageView) findViewById(R.id.senior_model_contact_icon);

        name = (TextView) findViewById(R.id.senior_mod_name);
        gender = (TextView) findViewById(R.id.senior_mod_gender);
        city = (TextView) findViewById(R.id.senior_mod_city);
        style = (TextView) findViewById(R.id.senior_mod_style);
        yearActive = (TextView) findViewById(R.id.senior_mod_yearActive);
        language = (TextView) findViewById(R.id.senior_mod_language);
        height = (TextView) findViewById(R.id.senior_mod_height);
        chestBrest = (TextView) findViewById(R.id.senior_mod_chestBrest);
        waste = (TextView) findViewById(R.id.senior_mod_waste);
        hairColor = (TextView) findViewById(R.id.senior_mod_hairColor);
        eyeColor = (TextView) findViewById(R.id.senior_mod_eyeColor);
        shoeSize = (TextView) findViewById(R.id.senior_mod_shoeSize);
        experience = (TextView) findViewById(R.id.senior_mod_experience);
        biography = (TextView) findViewById(R.id.senior_mod_biography);

        firstYouTube = (YouTubePlayerView) findViewById(R.id.senior_mod_videoFirst);

        if(cd.isConnected())
        {
            get_details = profileSeniorModelGetValue.getvalueSeniorModel(getId);

            nameTxt = get_details[0];
            profileImgTxt = get_details[1];
            genderTxt = get_details[2];
            cityTxt = get_details[3];
            styleTxt = get_details[4];
            langaugeTxt = get_details[5];
            codeTxt = get_details[6];
            yearActiveTxt = get_details[7];
            heightTxt = get_details[8];
            chestBrestTxt = get_details[9];
            wasteTxt = get_details[10];
            hairColorTxt = get_details[11];
            eyeColorTxt = get_details[12];
            shoeSizeTxt = get_details[13];
            experiencetTxt = get_details[14];
            biographyTxt = get_details[15];
            portfolioImgFirstTxt = get_details[16];
            portfolioImgSecondTxt = get_details[17];
            portfolioImgThirdTxt = get_details[18];
            portfolioImgFourthTxt = get_details[19];
            portfolioImgFifthTxt = get_details[20];
            portfolioImgSixthTxt = get_details[21];
            galleryFirstTxt = get_details[22];
            gallerySecondTxt = get_details[23];
            galleryThirdTxt = get_details[24];
            galleryFourthTxt = get_details[25];
            galleryFifthTxt = get_details[26];
            gallerySixthTxt = get_details[27];
            videoFirstTxt = get_details[28];
            videoSecondTxt = get_details[29];
            videoThirdTxt = get_details[30];
            videoFourthTxt = get_details[31];
            videoFifthTxt = get_details[32];
            videoSixthTxt = get_details[33];
            fbTxt = get_details[34];
            twTxt = get_details[35];
            instaTxt = get_details[36];
            webTxt = get_details[37];

        } else {
            Toast.makeText(ProfileSeniorModel.this, "No internet connection", Toast.LENGTH_SHORT).show();
        }

        if(!fbTxt.equals("null"))
        {
            fbIcon.setVisibility(View.VISIBLE);
        }
        if(!twTxt.equals("null"))
        {
            twIcon.setVisibility(View.VISIBLE);
        }
        if(!instaTxt.equals("null"))
        {
            instaIcon.setVisibility(View.VISIBLE);
        }
        if(!webTxt.equals("null"))
        {
            webIcon.setVisibility(View.VISIBLE);
        }

        name.setText(nameTxt);
        gender.setText(genderTxt);
        city.setText(cityTxt);
        style.setText(styleTxt);
        yearActive.setText(yearActiveTxt);
        language.setText(langaugeTxt);
        height.setText(heightTxt);
        chestBrest.setText(chestBrestTxt);
        waste.setText(wasteTxt);
        hairColor.setText(hairColorTxt);
        eyeColor.setText(eyeColorTxt);
        shoeSize.setText(shoeSizeTxt);
        experience.setText(experiencetTxt);
        biography.setText(biographyTxt);

        PicassoClient.downloadImgae(ProfileSeniorModel.this,IMAGE_URL + profileImgTxt,profileImg);


        if(!portfolioImgFirstTxt.equals("null"))
        {
            portfolioImgFirst.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileSeniorModel.this,IMAGE_URL + portfolioImgFirstTxt,portfolioImgFirst);
        }
        if(!portfolioImgSecondTxt.equals("null"))
        {
            portfolioImgSecond.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileSeniorModel.this,IMAGE_URL + portfolioImgSecondTxt,portfolioImgSecond);
        }
        if(!portfolioImgThirdTxt.equals("null"))
        {
            portfolioImgThird.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileSeniorModel.this,IMAGE_URL + portfolioImgThirdTxt,portfolioImgThird);
        }
        if(!portfolioImgFourthTxt.equals("null"))
        {
            portfolioImgFourth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileSeniorModel.this,IMAGE_URL + portfolioImgFourthTxt,portfolioImgFourth);
        }
        if(!portfolioImgFifthTxt.equals("null"))
        {
            portfolioImgFifth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileSeniorModel.this,IMAGE_URL + portfolioImgFifthTxt,portfolioImgFifth);
        }
        if(!portfolioImgSixthTxt.equals("null"))
        {
            portfolioImgSixth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileSeniorModel.this,IMAGE_URL + portfolioImgSixthTxt,portfolioImgSixth);
        }
        if(!galleryFirstTxt.equals("null"))
        {
            galleryImgFirst.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileSeniorModel.this,IMAGE_URL + galleryFirstTxt,galleryImgFirst);
        }
        if(!gallerySecondTxt.equals("null"))
        {
            galleryImgSecond.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileSeniorModel.this,IMAGE_URL + gallerySecondTxt,galleryImgSecond);
        }
        if(!galleryThirdTxt.equals("null"))
        {
            galleryImgThird.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileSeniorModel.this,IMAGE_URL + galleryThirdTxt,galleryImgThird);
        }
        if(!galleryFourthTxt.equals("null"))
        {
            galleryImgFourth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileSeniorModel.this,IMAGE_URL + galleryFourthTxt,galleryImgFourth);
        }
        if(!galleryFifthTxt.equals("null"))
        {
            galleryImgFifth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileSeniorModel.this,IMAGE_URL + galleryFifthTxt,galleryImgFifth);
        }
        if(!gallerySixthTxt.equals("null"))
        {
            galleryImgSixth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileSeniorModel.this,IMAGE_URL + gallerySixthTxt,galleryImgSixth);
        }

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if(!b){
                    if(!videoFirstTxt.equals("null"))
                    {
                        firstYouTube.setVisibility(View.VISIBLE);
                        youTubePlayer.cueVideo(videoFirstTxt);
                    }
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        firstYouTube.initialize(API_KEY, onInitializedListener);
    }
}
