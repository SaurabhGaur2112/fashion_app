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
import com.example.gaursaurabh.faspire.PeopleFile.ProfilePeopleGetValue;
import com.example.gaursaurabh.faspire.Picasso.PicassoClient;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ProfileFaspirePeople extends YouTubeBaseActivity {

    ImageView profileImg,galleryFirst,gallerySecond,galleryThird,galleryFourth,galleryFifth,gallerySixth,gallerySeventh
            ,galleryEighth,galleryNinth,galleryTenth;

    TextView name,occupation,city,biography;

    String profileImgTxt,galleryFirstTxt,gallerySecondTxt,galleryThirdTxt,galleryFourthTxt,galleryFifthTxt,gallerySixthTxt
            ,gallerySeventhTxt,galleryEighthTxt,galleryNinthTxt,galleryTenthTxt,nameTxt,occupationTxt,cityTxt,biographyTxt
            ,videoFirstTxt,videoSecondTxt,videoThirdTxt,videoFourthTxt,videoFifthTxt,videoSixthTxt,codeTxt,fbTxt,twTxt,instaTxt,webTxt;

    ImageView fbIcon,twIcon,instaIcon,webIcon,contactIcon;

    ConnectionDetector cd;
    Intent intent;
    String getId;
    String IMAGE_URL = "http://www.faspire.in/faspire_android/people_image/";
    ProfilePeopleGetValue profilePeopleGetValue;
    String get_details[];

    public static final String API_KEY = "AIzaSyBCVo6DdJKv471NPfWDSgt1fP1tIUAY_F8";
    YouTubePlayerView firstYouTube;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_faspire_people);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        cd = new ConnectionDetector(this);
        profilePeopleGetValue = new ProfilePeopleGetValue();
        intent = getIntent();
        getId = intent.getStringExtra("faspirePeopleId");

        profileImg = (ImageView) findViewById(R.id.people_profileImg);
        galleryFirst = (ImageView) findViewById(R.id.people_galleryFirst);
        gallerySecond = (ImageView) findViewById(R.id.people_gallerySecond);
        galleryThird = (ImageView) findViewById(R.id.people_galleryThird);
        galleryFourth = (ImageView) findViewById(R.id.people_galleryFourth);
        galleryFifth = (ImageView) findViewById(R.id.people_galleryFifth);
        gallerySixth = (ImageView) findViewById(R.id.people_gallerySixth);
        gallerySeventh = (ImageView) findViewById(R.id.people_gallerySeventh);
        galleryEighth = (ImageView) findViewById(R.id.people_galleryEighth);
        galleryNinth = (ImageView) findViewById(R.id.people_galleryNinth);
        galleryTenth = (ImageView) findViewById(R.id.people_galleryTenth);

        fbIcon = (ImageView) findViewById(R.id.faspire_people_facebook_icon);
        twIcon = (ImageView) findViewById(R.id.faspire_people_twitter_icon);
        instaIcon = (ImageView) findViewById(R.id.faspire_people_instagram_icon);
        webIcon = (ImageView) findViewById(R.id.faspire_people_website_icon);
        contactIcon = (ImageView) findViewById(R.id.faspire_people_contact_icon);

        name = (TextView) findViewById(R.id.people_name);
        occupation = (TextView) findViewById(R.id.people_occupation);
        city = (TextView) findViewById(R.id.people_city);
        biography = (TextView) findViewById(R.id.people_biography);

        firstYouTube = (YouTubePlayerView) findViewById(R.id.people_videoFirst);

        if(cd.isConnected())
        {
            get_details = profilePeopleGetValue.getvaluesPeople(getId);

            nameTxt = get_details[0];
            profileImgTxt = get_details[1];
            occupationTxt = get_details[2];
            biographyTxt = get_details[3];
            cityTxt = get_details[4];
            galleryFirstTxt = get_details[5];
            gallerySecondTxt = get_details[6];
            galleryThirdTxt = get_details[7];
            galleryFourthTxt = get_details[8];
            galleryFifthTxt = get_details[9];
            gallerySixthTxt = get_details[10];
            gallerySeventhTxt = get_details[11];
            galleryEighthTxt = get_details[12];
            galleryNinthTxt = get_details[13];
            galleryTenthTxt = get_details[14];
            videoFirstTxt = get_details[15];
            videoSecondTxt = get_details[16];
            videoThirdTxt = get_details[17];
            videoFourthTxt = get_details[18];
            videoFifthTxt = get_details[19];
            videoSixthTxt = get_details[20];
            codeTxt = get_details[21];
            fbTxt = get_details[22];
            twTxt = get_details[23];
            instaTxt = get_details[24];
            webTxt = get_details[25];

        } else {
            Toast.makeText(ProfileFaspirePeople.this, "No internet connection", Toast.LENGTH_SHORT).show();
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
        occupation.setText(occupationTxt);
        city.setText(cityTxt);
        biography.setText(biographyTxt);

        PicassoClient.downloadImgae(ProfileFaspirePeople.this,IMAGE_URL + profileImgTxt,profileImg);

        if(!galleryFirstTxt.equals("null"))
        {
            galleryFirst.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFaspirePeople.this,IMAGE_URL + galleryFirstTxt,galleryFirst);
        }
        if(!gallerySecondTxt.equals("null"))
        {
            gallerySecond.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFaspirePeople.this,IMAGE_URL + gallerySecondTxt,gallerySecond);
        }
        if(!galleryThirdTxt.equals("null"))
        {
            galleryThird.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFaspirePeople.this,IMAGE_URL + galleryThirdTxt,galleryThird);
        }
        if(!galleryFourthTxt.equals("null"))
        {
            galleryFourth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFaspirePeople.this,IMAGE_URL + galleryFourthTxt,galleryFourth);
        }
        if(!galleryFifthTxt.equals("null"))
        {
            galleryFifth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFaspirePeople.this,IMAGE_URL + galleryFifthTxt,galleryFifth);
        }
        if(!gallerySixthTxt.equals("null"))
        {
            gallerySixth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFaspirePeople.this,IMAGE_URL + gallerySixthTxt,gallerySixth);
        }
        if(!gallerySeventhTxt.equals("null"))
        {
            gallerySeventh.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFaspirePeople.this,IMAGE_URL + gallerySeventhTxt,gallerySeventh);
        }
        if(!galleryEighthTxt.equals("null"))
        {
            galleryEighth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFaspirePeople.this,IMAGE_URL + galleryEighthTxt,galleryEighth);
        }
        if(!galleryNinthTxt.equals("null"))
        {
            galleryNinth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFaspirePeople.this,IMAGE_URL + galleryNinthTxt,galleryNinth);
        }
        if(!galleryTenthTxt.equals("null"))
        {
            galleryTenth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileFaspirePeople.this,IMAGE_URL + galleryTenthTxt,galleryTenth);
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
