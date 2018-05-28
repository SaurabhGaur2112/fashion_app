package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.gaursaurabh.faspire.Picasso.PicassoClient;

import de.hdodenhof.circleimageview.CircleImageView;

public class MakeupArtistCategory extends AppCompatActivity {

    CircleImageView imageFirst,imageSecond;

    String DESIGNER_FIRST_URL = "http://www.faspire.in/faspire_android/makeup_artist_category_image/professional_artist.jpg";
    String DESIGNER_SECOND_URL = "http://www.faspire.in/faspire_android/makeup_artist_category_image/youth_artist.jpg";

    Intent intent;
    String getCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup_artist_category);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        intent = getIntent();
        getCity = intent.getStringExtra("cityName");

        imageFirst = (CircleImageView) findViewById(R.id.makeupCategoryFirst);
        imageSecond = (CircleImageView) findViewById(R.id.makeupCategorySecond);

        PicassoClient.downloadImgae(MakeupArtistCategory.this,DESIGNER_FIRST_URL,imageFirst);
        PicassoClient.downloadImgae(MakeupArtistCategory.this,DESIGNER_SECOND_URL,imageSecond);

        imageFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MakeupArtistCategory.this,FaspireProfessionalMakeup.class);
                i.putExtra("cityName",getCity);
                startActivity(i);

            }
        });

        imageSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MakeupArtistCategory.this,FaspireYouthMakeup.class);
                i.putExtra("cityName",getCity);
                startActivity(i);

            }
        });

    }
}
