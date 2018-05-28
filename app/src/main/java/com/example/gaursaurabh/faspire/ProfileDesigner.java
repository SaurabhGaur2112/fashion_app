package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.CheckNetworkConnection.ConnectionDetector;
import com.example.gaursaurabh.faspire.DesignerFile.ProfileDesignerGetValue;
import com.example.gaursaurabh.faspire.Picasso.PicassoClient;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ProfileDesigner extends YouTubeBaseActivity {

    ImageView profileImg,designImgFirst,designImgSecond,designImgThird,designImgFourth,designImgFifth,designImgSixth;
    ImageView galleryImgFirst,galleryImgSecond,galleryImgThird,galleryImgFourth,galleryImgFifth,galleryImgSixth;
    TextView name,yearActive,specilization,city,experience;
    String get_details[];
    ConnectionDetector cd;
    ProfileDesignerGetValue profileDesignerGetValue;
    Intent intent;
    String getId;
    String IMAGE_URL = "http://www.faspire.in/faspire_android/designer_image/";

    String nameTxt,profileImgTxt,specilizationTxt,yearActiveTxt,cityTxt,codeTxt,experienceTxt,imageFirstTxt,imageSecondTxt,imageThirdtxt
            ,imageFourthTxt,imageFifthTxt,imageSixthTxt,galleryFirstTxt,gallerySecondTxt,galleryThirdTxt,galleryFourthTxt,
            galleryFifthTxt,gallerySixthTxt,videoFirstTxt,videoSecondTxt,videoThirdTxt,videoFourthTxt,videoFifthTxt,videoSixthTxt;

    public static final String API_KEY = "AIzaSyBCVo6DdJKv471NPfWDSgt1fP1tIUAY_F8";
    YouTubePlayerView firstYouTube;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_designer);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        cd = new ConnectionDetector(this);
        profileDesignerGetValue = new ProfileDesignerGetValue();
        intent = getIntent();
        getId = intent.getStringExtra("designerId");

        profileImg = (ImageView) findViewById(R.id.des_profileImg);
        designImgFirst = (ImageView) findViewById(R.id.des_designImgFirst);
        designImgSecond = (ImageView) findViewById(R.id.des_designImgSecond);
        designImgThird = (ImageView) findViewById(R.id.des_designImgThird);
        designImgFourth = (ImageView) findViewById(R.id.des_designImgFourth);
        designImgFifth = (ImageView) findViewById(R.id.des_designImgFifth);
        designImgSixth = (ImageView) findViewById(R.id.des_designImgSixth);
        galleryImgFirst = (ImageView) findViewById(R.id.des_galleryImgFirst);
        galleryImgSecond = (ImageView) findViewById(R.id.des_galleryImgSecond);
        galleryImgThird = (ImageView) findViewById(R.id.des_galleryImgThird);
        galleryImgFourth = (ImageView) findViewById(R.id.des_galleryImgFourth);
        galleryImgFifth = (ImageView) findViewById(R.id.des_galleryImgFifth);
        galleryImgSixth = (ImageView) findViewById(R.id.des_galleryImgSixth);

        name = (TextView) findViewById(R.id.des_name);
        yearActive = (TextView) findViewById(R.id.des_yearActive);
        specilization = (TextView) findViewById(R.id.des_specilization);
        city = (TextView) findViewById(R.id.des_city);
        experience = (TextView) findViewById(R.id.des_experience);

        firstYouTube = (YouTubePlayerView) findViewById(R.id.des_videoFirst);


        if(cd.isConnected())
        {
            get_details = profileDesignerGetValue.getvaluesDesigner(getId);

            nameTxt = get_details[0];
            profileImgTxt = get_details[1];
            specilizationTxt = get_details[2];
            yearActiveTxt = get_details[3];
            cityTxt = get_details[4];
            codeTxt = get_details[5];
            experienceTxt = get_details[6];
            imageFirstTxt = get_details[7];
            imageSecondTxt = get_details[8];
            imageThirdtxt = get_details[9];
            imageFourthTxt = get_details[10];
            imageFifthTxt = get_details[11];
            imageSixthTxt = get_details[12];
            galleryFirstTxt = get_details[13];
            gallerySecondTxt = get_details[14];
            galleryThirdTxt = get_details[15];
            galleryFourthTxt = get_details[16];
            galleryFifthTxt = get_details[17];
            gallerySixthTxt = get_details[18];
            videoFirstTxt = get_details[19];
            videoSecondTxt = get_details[20];
            videoThirdTxt = get_details[21];
            videoFourthTxt = get_details[22];
            videoFifthTxt = get_details[23];
            videoSixthTxt = get_details[24];

        } else {
            Toast.makeText(ProfileDesigner.this, "No internet connection", Toast.LENGTH_SHORT).show();
        }

        name.setText(nameTxt);
        yearActive.setText(yearActiveTxt);
        specilization.setText(specilizationTxt);
        city.setText(cityTxt);
        experience.setText(specilizationTxt);

        PicassoClient.downloadImgae(ProfileDesigner.this,IMAGE_URL + profileImgTxt,profileImg);

        if(!imageFirstTxt.equals("null"))
        {
            designImgFirst.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileDesigner.this,IMAGE_URL + imageFirstTxt,designImgFirst);
        }
        if(!imageSecondTxt.equals("null"))
        {
            designImgSecond.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileDesigner.this,IMAGE_URL + imageSecondTxt,designImgSecond);
        }
        if(!imageThirdtxt.equals("null"))
        {
            designImgThird.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileDesigner.this,IMAGE_URL + imageThirdtxt,designImgThird);
        }
        if(!imageFourthTxt.equals("null"))
        {
            designImgFourth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileDesigner.this,IMAGE_URL + imageFourthTxt,designImgFourth);
        }
        if(!imageFifthTxt.equals("null"))
        {
            designImgFifth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileDesigner.this,IMAGE_URL + imageFifthTxt,designImgFifth);
        }
        if(!imageSixthTxt.equals("null"))
        {
            designImgSixth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileDesigner.this,IMAGE_URL + imageSixthTxt,designImgSixth);
        }
        if(!galleryFirstTxt.equals("null"))
        {
            galleryImgFirst.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileDesigner.this,IMAGE_URL + galleryFirstTxt,galleryImgFirst);
        }
        if(!gallerySecondTxt.equals("null"))
        {
            galleryImgSecond.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileDesigner.this,IMAGE_URL + gallerySecondTxt,galleryImgSecond);
        }
        if(!galleryThirdTxt.equals("null"))
        {
            galleryImgThird.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileDesigner.this,IMAGE_URL + galleryThirdTxt,galleryImgThird);
        }
        if(!galleryFourthTxt.equals("null"))
        {
            galleryImgFourth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileDesigner.this,IMAGE_URL + galleryFourthTxt,galleryImgFourth);
        }
        if(!galleryFifthTxt.equals("null"))
        {
            galleryImgFifth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileDesigner.this,IMAGE_URL + galleryFifthTxt,galleryImgFifth);
        }
        if(!gallerySixthTxt.equals("null"))
        {
            galleryImgSixth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileDesigner.this,IMAGE_URL + gallerySixthTxt,galleryImgSixth);
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
