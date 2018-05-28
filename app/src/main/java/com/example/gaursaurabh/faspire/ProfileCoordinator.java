package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.BoutiqueFile.ProfileBoutiqueGetValue;
import com.example.gaursaurabh.faspire.CheckNetworkConnection.ConnectionDetector;
import com.example.gaursaurabh.faspire.CoordinatorFile.ProfileCoordinatorGetValue;
import com.example.gaursaurabh.faspire.Picasso.PicassoClient;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ProfileCoordinator extends YouTubeBaseActivity {

    ImageView profileImg,trendyImgFirst,trendyImgSecond,trendyImgThird,trendyImgFourth,trendyImgFifth,trendyImgSixth;
    ImageView galleryImgFirst,galleryImgSecond,galleryImgThird,galleryImgFourth,galleryImgFifth,galleryImgSixth;
    TextView name,year,city,area,aboutus;
    String getId;
    Intent intent,intentCode;
    String get_details[];
    ProfileCoordinatorGetValue profileCoordinatorGetValue;
    ConnectionDetector cd;
    String nameTxt,profileImgTxt,yearTxt,cityTxt,areaTxt,codeTxt,aboutUsTxt,imageFirstTxt,imageSecondTxt,imageThirdTxt,imageFourthTxt,imageFifthTxt,imageSixthTxt,
            galleryFirstTxt,gallerySecondTxt,galleryThirdTxt,galleryFourthTxt,galleryFifthTxt,gallerySixthTxt,videoFirstTxt,videoSecondTxt,videoThirdTxt,videoFourthTxt,
            videoFifthTxt,videoSixthTxt,fbTxt,twTxt,instaTxt,webTxt;

    ImageView fbIcon,twIcon,instaIcon,webIcon,contactIcon;

    String IMAGE_URL = "http://www.faspire.in/faspire_android/fashion_coordinator_image/";

    ImageView contactOption;
    public static final String API_KEY = "AIzaSyBCVo6DdJKv471NPfWDSgt1fP1tIUAY_F8";
    YouTubePlayerView firstYouTube;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_coordinator);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        intent = getIntent();
        getId = intent.getStringExtra("coordinatorId");
        profileCoordinatorGetValue = new ProfileCoordinatorGetValue();
        cd = new ConnectionDetector(this);

        profileImg = (ImageView) findViewById(R.id.coor_profileImg);
        trendyImgFirst = (ImageView) findViewById(R.id.coor_trendyImgFirst);
        trendyImgSecond = (ImageView) findViewById(R.id.coor_trendyImgSecond);
        trendyImgThird = (ImageView) findViewById(R.id.coor_trendyImgThird);
        trendyImgFourth = (ImageView) findViewById(R.id.coor_trendyImgFourth);
        trendyImgFifth = (ImageView) findViewById(R.id.coor_trendyImgFifth);
        trendyImgSixth = (ImageView) findViewById(R.id.coor_trendyImgSixth);
        galleryImgFirst = (ImageView) findViewById(R.id.coor_galleryImgFirst);
        galleryImgSecond = (ImageView) findViewById(R.id.coor_galleryImgSecond);
        galleryImgThird = (ImageView) findViewById(R.id.coor_galleryImgThird);
        galleryImgFourth = (ImageView) findViewById(R.id.coor_galleryImgFourth);
        galleryImgFifth = (ImageView) findViewById(R.id.coor_galleryImgFifth);
        galleryImgSixth = (ImageView) findViewById(R.id.coor_galleryImgSixth);

        fbIcon = (ImageView) findViewById(R.id.coordinator_facebook_icon);
        twIcon = (ImageView) findViewById(R.id.coordinator_twitter_icon);
        instaIcon = (ImageView) findViewById(R.id.coordinator_instagram_icon);
        webIcon = (ImageView) findViewById(R.id.coordinator_website_icon);
        contactIcon = (ImageView) findViewById(R.id.coordinator_contact_icon);

        name = (TextView) findViewById(R.id.coor_name);
        year = (TextView) findViewById(R.id.coor_year);
        city = (TextView) findViewById(R.id.coor_city);
        area = (TextView) findViewById(R.id.coor_area);
        aboutus = (TextView) findViewById(R.id.coor_aboutus);

        contactOption = (ImageView) findViewById(R.id.coordinator_contact_icon);

        firstYouTube = (YouTubePlayerView) findViewById(R.id.coor_videoFirst);


        if(cd.isConnected())
        {
            get_details = profileCoordinatorGetValue.getvaluesCoordinator(getId);
            nameTxt = get_details[0];
            profileImgTxt = get_details[1];
            yearTxt = get_details[2];
            cityTxt = get_details[3];
            areaTxt = get_details[4];
            codeTxt = get_details[5];
            aboutUsTxt = get_details[6];
            imageFirstTxt = get_details[7];
            imageSecondTxt = get_details[8];
            imageThirdTxt = get_details[9];
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
            fbTxt = get_details[25];
            twTxt = get_details[26];
            instaTxt = get_details[27];
            webTxt = get_details[28];


        } else {
            Toast.makeText(ProfileCoordinator.this, "No internet connection", Toast.LENGTH_SHORT).show();
        }

        contactOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCode = new Intent(getApplicationContext(),ContactMe.class);
                intentCode.putExtra("CodeSend",codeTxt);
                startActivity(intentCode);
            }
        });

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
        year.setText(yearTxt);
        city.setText(cityTxt);
        area.setText(areaTxt);
        aboutus.setText(aboutUsTxt);


        PicassoClient.downloadImgae(ProfileCoordinator.this,IMAGE_URL + profileImgTxt,profileImg);
        if(!imageFirstTxt.equals("null"))
        {
            trendyImgFirst.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileCoordinator.this,IMAGE_URL + imageFirstTxt,trendyImgFirst);
        }
        if(!imageSecondTxt.equals("null"))
        {
            trendyImgSecond.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileCoordinator.this,IMAGE_URL + imageSecondTxt,trendyImgSecond);
        }
        if(!imageThirdTxt.equals("null"))
        {
            trendyImgThird.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileCoordinator.this,IMAGE_URL + imageThirdTxt,trendyImgThird);
        }
        if(!imageFourthTxt.equals("null"))
        {
            trendyImgFourth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileCoordinator.this,IMAGE_URL + imageFourthTxt,trendyImgFourth);
        }
        if(!imageFifthTxt.equals("null"))
        {
            trendyImgFifth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileCoordinator.this,IMAGE_URL + imageFifthTxt,trendyImgFifth);
        }
        if(!imageSixthTxt.equals("null"))
        {
            trendyImgSixth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileCoordinator.this,IMAGE_URL + imageSixthTxt,trendyImgSixth);
        }
        if(!galleryFirstTxt.equals("null"))
        {
            galleryImgFirst.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileCoordinator.this,IMAGE_URL + galleryFirstTxt,galleryImgFirst);
        }
        if(!gallerySecondTxt.equals("null"))
        {
            galleryImgSecond.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileCoordinator.this,IMAGE_URL + gallerySecondTxt,galleryImgSecond);
        }
        if(!galleryThirdTxt.equals("null"))
        {
            galleryImgThird.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileCoordinator.this,IMAGE_URL + galleryThirdTxt,galleryImgThird);
        }
        if(!galleryFourthTxt.equals("null"))
        {
            galleryImgFourth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileCoordinator.this,IMAGE_URL + galleryFourthTxt,galleryImgFourth);
        }
        if(!galleryFifthTxt.equals("null"))
        {
            galleryImgFifth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileCoordinator.this,IMAGE_URL + galleryFifthTxt,galleryImgFifth);
        }
        if(!gallerySixthTxt.equals("null"))
        {
            galleryImgSixth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileCoordinator.this,IMAGE_URL + gallerySixthTxt,galleryImgSixth);
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
