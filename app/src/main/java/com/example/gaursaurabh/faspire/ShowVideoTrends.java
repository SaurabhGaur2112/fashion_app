package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.CheckNetworkConnection.ConnectionDetector;
import com.example.gaursaurabh.faspire.TrendFile.TrendsGetValues;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ShowVideoTrends extends YouTubeBaseActivity {

    Intent intent;
    String getId;
    ConnectionDetector cd;
    TrendsGetValues trendsGetValues;
    String get_details[];

    String videoTxt,headlineTxt,descriptionTxt,representTxt;

    TextView headline,description;
    public static final String API_KEY = "AIzaSyBCVo6DdJKv471NPfWDSgt1fP1tIUAY_F8";
    YouTubePlayerView firstYouTube;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video_trends);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        cd = new ConnectionDetector(this);
        intent = getIntent();
        getId = intent.getStringExtra("TrendId");
        trendsGetValues = new TrendsGetValues();

        firstYouTube = (YouTubePlayerView) findViewById(R.id.trendshow_video);
        headline = (TextView) findViewById(R.id.trendshow_headline_video);
        description = (TextView) findViewById(R.id.trendshow_description_video);

        if(cd.isConnected())
        {
            get_details = trendsGetValues.getvaluesTrends(getId);

            videoTxt = get_details[4];
            headlineTxt = get_details[1];
            descriptionTxt = get_details[2];
            representTxt = get_details[3];

        } else {
            Toast.makeText(ShowVideoTrends.this, "No internet connection", Toast.LENGTH_SHORT).show();
        }

        headline.setText(headlineTxt);
        description.setText(descriptionTxt);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if(!b){
                    if(!videoTxt.equals("null"))
                    {
                        firstYouTube.setVisibility(View.VISIBLE);
                        youTubePlayer.cueVideo(videoTxt);
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
