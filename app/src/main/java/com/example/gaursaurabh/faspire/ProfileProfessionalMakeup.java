package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.media.Image;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.CheckNetworkConnection.ConnectionDetector;
import com.example.gaursaurabh.faspire.MakeupArtistFile.ProfileMakeupArtistGetValue;
import com.example.gaursaurabh.faspire.MakeupArtistFile.ProfileProfessionalMakeupArtistGetValue;
import com.example.gaursaurabh.faspire.Picasso.PicassoClient;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ProfileProfessionalMakeup extends YouTubeBaseActivity {

    ImageView profileImg,galleryFirst,gallerySecond,galleryThird,galleryFourth,galleryFifth,gallerySixth,gallerySeventh
            ,galleryEighth,galleryNinth,galleryTenth;

    TextView name,professionalSkills,yearActive,clients,experience,aboutUs;

    String profileImgTxt,galleryFirstTxt,gallerySecondTxt,galleryThirdTxt,galleryFourthTxt,galleryFifthTxt,gallerySixthTxt,
            gallerySeventhTxt,galleryEighthTxt,galleryNinthTxt,galleryTenthTxt,nameTxt,professionalSkillsTxt,yearActiveTxt,clientsTxt,
            experienceTxt,aboutUsTxt,codeTxt,videoFirstTxt,videoSecondTxt,videoThirdTxt,videoFourthTxt,videoFifthTxt,videoSixthTxt,
            fbTxt,twTxt,instaTxt,webTxt;

    ImageView fbIcon,twIcon,instaIcon,webIcon,contactIcon;

    ConnectionDetector cd;
    Intent intent;
    String getId;
    String IMAGE_URL = "http://www.faspire.in/faspire_android/professional_makeup_artist_image/";
    ProfileProfessionalMakeupArtistGetValue profileProfessionalMakeupArtistGetValue;
    String get_details[];

    public static final String API_KEY = "AIzaSyBCVo6DdJKv471NPfWDSgt1fP1tIUAY_F8";
    YouTubePlayerView firstYouTube;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_professional_makeup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        cd = new ConnectionDetector(this);
        profileProfessionalMakeupArtistGetValue = new ProfileProfessionalMakeupArtistGetValue();
        intent = getIntent();
        getId = intent.getStringExtra("professionalMakeupArtistId");

        profileImg = (ImageView) findViewById(R.id.profess_makeup_profileImg);
        galleryFirst = (ImageView) findViewById(R.id.profess_makeup_galleryFirst);
        gallerySecond = (ImageView) findViewById(R.id.profess_makeup_gallerySecond);
        galleryThird = (ImageView) findViewById(R.id.profess_makeup_galleryThird);
        galleryFourth = (ImageView) findViewById(R.id.profess_makeup_galleryFourth);
        galleryFifth = (ImageView) findViewById(R.id.profess_makeup_galleryFifth);
        gallerySixth = (ImageView) findViewById(R.id.profess_makeup_gallerySixth);
        gallerySeventh = (ImageView) findViewById(R.id.profess_makeup_gallerySeventh);
        galleryEighth = (ImageView) findViewById(R.id.profess_makeup_galleryEighth);
        galleryNinth = (ImageView) findViewById(R.id.profess_makeup_galleryNinth);
        galleryTenth = (ImageView) findViewById(R.id.profess_makeup_galleryTenth);

        fbIcon = (ImageView) findViewById(R.id.professional_makeup_facebook_icon);
        twIcon = (ImageView) findViewById(R.id.professional_makeup_twitter_icon);
        instaIcon = (ImageView) findViewById(R.id.professional_makeup_instagram_icon);
        webIcon = (ImageView) findViewById(R.id.professional_makeup_website_icon);
        contactIcon = (ImageView) findViewById(R.id.professional_makeup_contact_icon);

        name = (TextView) findViewById(R.id.profess_makeup_name);
        professionalSkills = (TextView) findViewById(R.id.profess_makeup_professionalSkills);
        yearActive = (TextView) findViewById(R.id.profess_makeup_yearActive);
        clients = (TextView) findViewById(R.id.profess_makeup_clients);
        experience = (TextView) findViewById(R.id.profess_makeup_experience);
        aboutUs = (TextView) findViewById(R.id.profess_makeup_aboutUs);

        firstYouTube = (YouTubePlayerView) findViewById(R.id.profess_makeup_videoFirst);


        if(cd.isConnected())
        {
            get_details = profileProfessionalMakeupArtistGetValue.getvaluesProfessionalMakeupArtists(getId);

            nameTxt = get_details[0];
            profileImgTxt = get_details[1];
            professionalSkillsTxt = get_details[2];
            yearActiveTxt = get_details[3];
            clientsTxt = get_details[4];
            aboutUsTxt = get_details[5];
            galleryFirstTxt = get_details[6];
            gallerySecondTxt = get_details[7];
            galleryThirdTxt = get_details[8];
            galleryFourthTxt = get_details[9];
            galleryFifthTxt = get_details[10];
            gallerySixthTxt = get_details[11];
            gallerySeventhTxt = get_details[12];
            galleryEighthTxt = get_details[13];
            galleryNinthTxt = get_details[14];
            galleryTenthTxt = get_details[15];
            videoFirstTxt = get_details[16];
            videoSecondTxt = get_details[17];
            videoThirdTxt = get_details[18];
            videoFourthTxt = get_details[19];
            videoFifthTxt = get_details[20];
            videoSixthTxt = get_details[21];
            codeTxt = get_details[22];
            experienceTxt = get_details[23];
            fbTxt = get_details[24];
            twTxt = get_details[25];
            instaTxt = get_details[26];
            webTxt = get_details[27];

        } else {
            Toast.makeText(ProfileProfessionalMakeup.this, "No internet connection", Toast.LENGTH_SHORT).show();
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
        professionalSkills.setText(professionalSkillsTxt);
        yearActive.setText(yearActiveTxt);
        clients.setText(clientsTxt);
        experience.setText(experienceTxt);
        aboutUs.setText(aboutUsTxt);

        PicassoClient.downloadImgae(ProfileProfessionalMakeup.this,IMAGE_URL + profileImgTxt,profileImg);

        if(!galleryFirstTxt.equals("null"))
        {
            galleryFirst.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileProfessionalMakeup.this,IMAGE_URL + galleryFirstTxt,galleryFirst);
        }
        if(!gallerySecondTxt.equals("null"))
        {
            gallerySecond.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileProfessionalMakeup.this,IMAGE_URL + gallerySecondTxt,gallerySecond);
        }
        if(!galleryThirdTxt.equals("null"))
        {
            galleryThird.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileProfessionalMakeup.this,IMAGE_URL + galleryThirdTxt,galleryThird);
        }
        if(!galleryFourthTxt.equals("null"))
        {
            galleryFourth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileProfessionalMakeup.this,IMAGE_URL + galleryFourthTxt,galleryFourth);
        }
        if(!galleryFifthTxt.equals("null"))
        {
            galleryFifth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileProfessionalMakeup.this,IMAGE_URL + galleryFifthTxt,galleryFifth);
        }
        if(!gallerySixthTxt.equals("null"))
        {
            gallerySixth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileProfessionalMakeup.this,IMAGE_URL + gallerySixthTxt,gallerySixth);
        }
        if(!gallerySeventhTxt.equals("null"))
        {
            gallerySeventh.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileProfessionalMakeup.this,IMAGE_URL + gallerySeventhTxt,gallerySeventh);
        }
        if(!galleryEighthTxt.equals("null"))
        {
            galleryEighth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileProfessionalMakeup.this,IMAGE_URL + galleryEighthTxt,galleryEighth);
        }
        if(!galleryNinthTxt.equals("null"))
        {
            galleryNinth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileProfessionalMakeup.this,IMAGE_URL + galleryNinthTxt,galleryNinth);
        }
        if(!galleryTenthTxt.equals("null"))
        {
            galleryTenth.setVisibility(View.VISIBLE);
            PicassoClient.downloadImgae(ProfileProfessionalMakeup.this,IMAGE_URL + galleryTenthTxt,galleryTenth);
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
