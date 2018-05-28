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
import com.example.gaursaurabh.faspire.Picasso.PicassoClient;
import com.example.gaursaurabh.faspire.StylistFile.ProfileFashionStylistGetValue;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ProfileFashionStylist extends YouTubeBaseActivity {

    ImageView profileImg,portfolioFirst,portfolioSecond,portfolioThird,portfolioFourth,portfolioFifth,portfolioSixth
            ,galleryFirst,gallerySecond,galleryThird,galleryFourth,galleryFifth,gallerySixth;

    TextView name,yearActive,aboutMe,experience;

    ImageView fbIcon,twIcon,instaIcon,webIcon,contactIcon;

    String profileImgTxt,portfolioFirstTxt,portfolioSecondTxt,portfolioThirdTxt,portfolioFourthTxt
            ,portfolioFifthTxt,portfolioSixthTxt,galleryFirstTxt,gallerySecondTxt,galleryThirdTxt,galleryFourthTxt
            ,galleryFifthTxt,gallerySixthTxt,videoFirstTxt,videoSecondTxt,videoThirdTxt,videoFourthTxt,videoFifthTxt,videoSixthTxt
            ,nameTxt,yearActiveTxt,aboutMeTxt,experienceTxt,codeTxt,fbTxt,twTxt,instaTxt,webTxt;

    ConnectionDetector cd;
    Intent intent;
    String getId;
    String IMAGE_URL = "http://www.faspire.in/faspire_android/fashion_stylist_image/";
    ProfileFashionStylistGetValue profileFashionStylistGetValue;
    String get_details[];

    public static final String API_KEY = "AIzaSyBCVo6DdJKv471NPfWDSgt1fP1tIUAY_F8";
    YouTubePlayerView firstYouTube;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_fashion_stylist);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        cd = new ConnectionDetector(this);
        profileFashionStylistGetValue = new ProfileFashionStylistGetValue();
        intent = getIntent();
        getId = intent.getStringExtra("fashionStylistId");

        profileImg = (ImageView) findViewById(R.id.stylist_profileImg);
        portfolioFirst = (ImageView) findViewById(R.id.stylist_portfolioFirst);
        portfolioSecond = (ImageView) findViewById(R.id.stylist_portfolioSecond);
        portfolioThird = (ImageView) findViewById(R.id.stylist_portfolioThird);
        portfolioFourth = (ImageView) findViewById(R.id.stylist_portfolioFourth);
        portfolioFifth = (ImageView) findViewById(R.id.stylist_portfolioFifth);
        portfolioSixth = (ImageView) findViewById(R.id.stylist_portfolioSixth);
        galleryFirst = (ImageView) findViewById(R.id.stylist_galleryFirst);
        gallerySecond = (ImageView) findViewById(R.id.stylist_gallerySecond);
        galleryThird = (ImageView) findViewById(R.id.stylist_galleryThird);
        galleryFourth = (ImageView) findViewById(R.id.stylist_galleryFourth);
        galleryFifth = (ImageView) findViewById(R.id.stylist_galleryFifth);
        gallerySixth = (ImageView) findViewById(R.id.stylist_gallerySixth);

        fbIcon = (ImageView) findViewById(R.id.fashion_stylist_facebook_icon);
        twIcon = (ImageView) findViewById(R.id.fashion_stylist_twitter_icon);
        instaIcon = (ImageView) findViewById(R.id.fashion_stylist_instagram_icon);
        webIcon = (ImageView) findViewById(R.id.fashion_stylist_website_icon);
        contactIcon = (ImageView) findViewById(R.id.fashion_stylist_contact_icon);

        name = (TextView) findViewById(R.id.stylist_name);
        yearActive = (TextView) findViewById(R.id.stylist_yearActive);
        aboutMe = (TextView) findViewById(R.id.stylist_aboutMe);
        experience = (TextView) findViewById(R.id.stylist_experience);

        firstYouTube = (YouTubePlayerView) findViewById(R.id.stylist_videoFirst);


        if(cd.isConnected())
        {
            get_details = profileFashionStylistGetValue.getvaluesFashionStylist(getId);

            nameTxt = get_details[0];
            profileImgTxt = get_details[1];
            yearActiveTxt = get_details[2];
            aboutMeTxt = get_details[3];
            experienceTxt = get_details[4];
            portfolioFirstTxt = get_details[5];
            portfolioSecondTxt = get_details[6];
            portfolioThirdTxt = get_details[7];
            portfolioFourthTxt = get_details[8];
            portfolioFifthTxt = get_details[9];
            portfolioSixthTxt = get_details[10];
            galleryFirstTxt = get_details[11];
            gallerySecondTxt = get_details[12];
            galleryThirdTxt = get_details[13];
            galleryFourthTxt = get_details[14];
            galleryFifthTxt = get_details[15];
            gallerySixthTxt = get_details[16];
            videoFirstTxt = get_details[17];
            videoSecondTxt = get_details[18];
            videoThirdTxt = get_details[19];
            videoFourthTxt = get_details[20];
            videoFifthTxt = get_details[21];
            videoSixthTxt = get_details[22];
            codeTxt = get_details[23];
            fbTxt = get_details[24];
            twTxt = get_details[25];
            instaTxt = get_details[26];
            webTxt = get_details[27];


        } else {
            Toast.makeText(ProfileFashionStylist.this, "No internet connection", Toast.LENGTH_SHORT).show();
        }

        name.setText(nameTxt);
        yearActive.setText(yearActiveTxt);
        aboutMe.setText(aboutMeTxt);
        experience.setText(experienceTxt);

        PicassoClient.downloadImgae(ProfileFashionStylist.this,IMAGE_URL + profileImgTxt,profileImg);

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

        if(!portfolioFirstTxt.equals("null"))
        {
            portfolioFirst.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFashionStylist.this,IMAGE_URL + portfolioFirstTxt,portfolioFirst);
        }
        if(!portfolioSecondTxt.equals("null"))
        {
            portfolioSecond.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFashionStylist.this,IMAGE_URL + portfolioSecondTxt,portfolioSecond);
        }
        if(!portfolioThirdTxt.equals("null"))
        {
            portfolioThird.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFashionStylist.this,IMAGE_URL + portfolioThirdTxt,portfolioThird);
        }
        if(!portfolioFourthTxt.equals("null"))
        {
            portfolioFourth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFashionStylist.this,IMAGE_URL + portfolioFourthTxt,portfolioFourth);
        }
        if(!portfolioFifthTxt.equals("null"))
        {
            portfolioFifth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFashionStylist.this,IMAGE_URL + portfolioFifthTxt,portfolioFifth);
        }
        if(!portfolioSixthTxt.equals("null"))
        {
            portfolioSixth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFashionStylist.this,IMAGE_URL + portfolioSixthTxt,portfolioSixth);
        }
        if(!galleryFirstTxt.equals("null"))
        {
            galleryFirst.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFashionStylist.this,IMAGE_URL + galleryFirstTxt,galleryFirst);
        }
        if(!gallerySecondTxt.equals("null"))
        {
            gallerySecond.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFashionStylist.this,IMAGE_URL + gallerySecondTxt,gallerySecond);
        }
        if(!galleryThirdTxt.equals("null"))
        {
            galleryThird.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFashionStylist.this,IMAGE_URL + galleryThirdTxt,galleryThird);
        }
        if(!galleryFourthTxt.equals("null"))
        {
            galleryFourth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFashionStylist.this,IMAGE_URL + galleryFourthTxt,galleryFourth);
        }
        if(!galleryFifthTxt.equals("null"))
        {
            galleryFifth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFashionStylist.this,IMAGE_URL + galleryFifthTxt,galleryFifth);
        }
        if(!gallerySixthTxt.equals("null"))
        {
            gallerySixth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFashionStylist.this,IMAGE_URL + gallerySixthTxt,gallerySixth);
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
