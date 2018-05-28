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
import com.example.gaursaurabh.faspire.FlashBackFile.FlashGetValues;
import com.example.gaursaurabh.faspire.Picasso.PicassoClient;

public class ShowImageFlash extends AppCompatActivity {

    Intent intent;
    String getId;
    ConnectionDetector cd;
    FlashGetValues flashGetValues;
    String get_details[];

    String imageTxt,headlineTxt,descriptionTxt,representTxt;

    ImageView flashImg;
    TextView headline,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image_flash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        cd = new ConnectionDetector(this);
        intent = getIntent();
        getId = intent.getStringExtra("FlashId");

        flashGetValues = new FlashGetValues();

        flashImg = (ImageView) findViewById(R.id.flashshow_image);
        headline = (TextView) findViewById(R.id.flashshow_headline);
        description = (TextView) findViewById(R.id.flashshow_description);

        if(cd.isConnected())
        {
            get_details = flashGetValues.getvaluesFlash(getId);

            imageTxt = get_details[0];
            headlineTxt = get_details[1];
            descriptionTxt = get_details[2];
            representTxt = get_details[3];

        } else {
            Toast.makeText(ShowImageFlash.this, "No internet connection", Toast.LENGTH_SHORT).show();
        }

        PicassoClient.downloadImgae(ShowImageFlash.this,imageTxt,flashImg);

        headline.setText(headlineTxt);
        description.setText(descriptionTxt);

    }
}
