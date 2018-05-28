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
import com.example.gaursaurabh.faspire.PhotographerFile.ProfilePhotographerGetValue;
import com.example.gaursaurabh.faspire.Picasso.PicassoClient;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ProfilePhotography extends YouTubeBaseActivity {

    ImageView profileImg,galleryImgFirst,galleryImgSecond,galleryImgThird,galleryImgFourth,galleryImgFifth
            ,galleryImgSixth,galleryImgSeventh,galleryImgEighth,galleryImgNinth,galleryImgTenth;

    TextView name,professional,yearActive,aboutUs,experience,clients;

    String nameTxt,professionalTxt,yearActiveTxt,aboutUsTxt,experienceTxt,clientsTxt,codeTxt,profileImgTxt,
    galleryFirstTxt,gallerySecondTxt,galleryThirdTxt,galleryFourthTxt,galleryFifthTxt,gallerySixthTxt,gallerySeventhTxt
            ,galleryEighthTxt,galleryNinthTxt,galleryTenthTxt,videoFirstTxt,videoSecondTxt,videoThirdTxt,videoFourthTxt
            ,videoFifthTxt,videoSixthTxt;

    ConnectionDetector cd;
    Intent intent;
    String getId;
    String IMAGE_URL = "http://www.faspire.in/faspire_android/photographer_image/";
    ProfilePhotographerGetValue profilePhotographerGetValue;
    String get_details[];

    public static final String API_KEY = "AIzaSyBCVo6DdJKv471NPfWDSgt1fP1tIUAY_F8";
    YouTubePlayerView firstYouTube;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_photography);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        cd = new ConnectionDetector(this);
        profilePhotographerGetValue = new ProfilePhotographerGetValue();
        intent = getIntent();
        getId = intent.getStringExtra("photographerId");

        profileImg = (ImageView) findViewById(R.id.photo_profileImg);
        galleryImgFirst = (ImageView) findViewById(R.id.photo_galleryImgFirst);
        galleryImgSecond = (ImageView) findViewById(R.id.photo_galleryImgSecond);
        galleryImgThird = (ImageView) findViewById(R.id.photo_galleryImgThird);
        galleryImgFourth = (ImageView) findViewById(R.id.photo_galleryImgFourth);
        galleryImgFifth = (ImageView) findViewById(R.id.photo_galleryImgFifth);
        galleryImgSixth = (ImageView) findViewById(R.id.photo_galleryImgSixth);
        galleryImgSeventh = (ImageView) findViewById(R.id.photo_galleryImgSeventh);
        galleryImgEighth = (ImageView) findViewById(R.id.photo_galleryImgEighth);
        galleryImgNinth = (ImageView) findViewById(R.id.photo_galleryImgNinth);
        galleryImgTenth = (ImageView) findViewById(R.id.photo_galleryImgTenth);

        name = (TextView) findViewById(R.id.photo_name);
        professional = (TextView) findViewById(R.id.photo_professional);
        yearActive = (TextView) findViewById(R.id.photo_yearActive);
        aboutUs = (TextView) findViewById(R.id.photo_aboutUs);
        experience = (TextView) findViewById(R.id.photo_experience);
        clients = (TextView) findViewById(R.id.photo_clients);

        firstYouTube = (YouTubePlayerView) findViewById(R.id.photo_videoFirst);


        if(cd.isConnected())
        {
            get_details = profilePhotographerGetValue.getvaluesPhotographer(getId);

            nameTxt = get_details[0];
            profileImgTxt = get_details[1];
            professionalTxt = get_details[2];
            yearActiveTxt = get_details[3];
            aboutUsTxt = get_details[4];
            experienceTxt = get_details[5];
            clientsTxt = get_details[6];
            galleryFirstTxt = get_details[7];
            gallerySecondTxt = get_details[8];
            galleryThirdTxt = get_details[9];
            galleryFourthTxt = get_details[10];
            galleryFifthTxt = get_details[11];
            gallerySixthTxt = get_details[12];
            gallerySeventhTxt = get_details[13];
            galleryEighthTxt = get_details[14];
            galleryNinthTxt = get_details[15];
            galleryTenthTxt = get_details[16];
            videoFirstTxt = get_details[17];
            videoSecondTxt = get_details[18];
            videoThirdTxt = get_details[19];
            videoFourthTxt = get_details[20];
            videoFifthTxt = get_details[21];
            videoSixthTxt = get_details[22];
            codeTxt = get_details[23];

        } else {
            Toast.makeText(ProfilePhotography.this, "No internet connection", Toast.LENGTH_SHORT).show();
        }

        name.setText(nameTxt);
        professional.setText(professionalTxt);
        yearActive.setText(yearActiveTxt);
        aboutUs.setText(aboutUsTxt);
        experience.setText(experienceTxt);
        clients.setText(clientsTxt);

        PicassoClient.downloadImgae(ProfilePhotography.this,IMAGE_URL + profileImgTxt,profileImg);

        if(!galleryFirstTxt.equals("null"))
        {
            galleryImgFirst.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfilePhotography.this,IMAGE_URL + galleryFirstTxt,galleryImgFirst);
        }
        if(!gallerySecondTxt.equals("null"))
        {
            galleryImgSecond.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfilePhotography.this,IMAGE_URL + gallerySecondTxt,galleryImgSecond);
        }
        if(!galleryThirdTxt.equals("null"))
        {
            galleryImgThird.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfilePhotography.this,IMAGE_URL + galleryThirdTxt,galleryImgThird);
        }
        if(!galleryFourthTxt.equals("null"))
        {
            galleryImgFourth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfilePhotography.this,IMAGE_URL + galleryFourthTxt,galleryImgFourth);
        }
        if(!galleryFifthTxt.equals("null"))
        {
            galleryImgFifth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfilePhotography.this,IMAGE_URL + galleryFifthTxt,galleryImgFifth);
        }
        if(!gallerySixthTxt.equals("null"))
        {
            galleryImgSixth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfilePhotography.this,IMAGE_URL + gallerySixthTxt,galleryImgSixth);
        }
        if(!gallerySeventhTxt.equals("null"))
        {
            galleryImgSeventh.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfilePhotography.this,IMAGE_URL + gallerySeventhTxt,galleryImgSeventh);
        }
        if(!galleryEighthTxt.equals("null"))
        {
            galleryImgEighth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfilePhotography.this,IMAGE_URL + galleryEighthTxt,galleryImgEighth);
        }
        if(!galleryNinthTxt.equals("null"))
        {
            galleryImgNinth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfilePhotography.this,IMAGE_URL + galleryNinthTxt,galleryImgNinth);
        }
        if(!galleryTenthTxt.equals("null"))
        {
            galleryImgTenth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfilePhotography.this,IMAGE_URL + galleryTenthTxt,galleryImgTenth);
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
