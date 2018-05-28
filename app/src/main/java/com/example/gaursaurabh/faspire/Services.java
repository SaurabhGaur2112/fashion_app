package com.example.gaursaurabh.faspire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.example.gaursaurabh.faspire.Picasso.PicassoClientSecond;

public class Services extends AppCompatActivity {

    ImageView imageView;
    String Image_Url = "http://www.faspire.in/faspire_android/faspire_service/services.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        imageView = (ImageView) findViewById(R.id.poster_service);
        PicassoClientSecond.downloadImgae(Services.this,Image_Url,imageView);

    }
}
