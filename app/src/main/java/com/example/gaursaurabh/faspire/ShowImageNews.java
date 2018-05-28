package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.CheckNetworkConnection.ConnectionDetector;
import com.example.gaursaurabh.faspire.NewsFile.NewsGetValues;
import com.example.gaursaurabh.faspire.Picasso.PicassoClient;

public class ShowImageNews extends AppCompatActivity {

    Intent intent;
    String getId;
    ConnectionDetector cd;
    NewsGetValues newsGetValues;
    String get_details[];

    String imageTxt,headlineTxt,descriptionTxt,representTxt;

    ImageView newsImg;
    TextView headline,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image_news);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        cd = new ConnectionDetector(this);
        intent = getIntent();
        getId = intent.getStringExtra("NewsId");
        newsGetValues = new NewsGetValues();

        newsImg = (ImageView) findViewById(R.id.newsimgshow_Image);
        headline = (TextView) findViewById(R.id.newsimgshow_headline);
        description = (TextView) findViewById(R.id.newsimgshow_description);

        if(cd.isConnected())
        {
            get_details = newsGetValues.getvaluesNews(getId);

            imageTxt = get_details[0];
            headlineTxt = get_details[1];
            descriptionTxt = get_details[2];
            representTxt = get_details[3];

        } else {
            Toast.makeText(ShowImageNews.this, "No internet connection", Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(ShowImageNews.this, imageTxt, Toast.LENGTH_SHORT).show();

        PicassoClient.downloadImgae(ShowImageNews.this,imageTxt,newsImg);

        headline.setText(headlineTxt);
        description.setText(descriptionTxt);
    }
}
