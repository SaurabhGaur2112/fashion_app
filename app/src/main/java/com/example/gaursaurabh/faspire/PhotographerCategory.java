package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.gaursaurabh.faspire.Picasso.PicassoClient;

import de.hdodenhof.circleimageview.CircleImageView;

public class PhotographerCategory extends AppCompatActivity {

    CircleImageView imageFirst,imageSecond,imageThird;

    String DESIGNER_FIRST_URL = "http://www.faspire.in/faspire_android/photographer_category_image/fashion_studio.jpg";
    String DESIGNER_SECOND_URL = "http://www.faspire.in/faspire_android/photographer_category_image/professional_photographer.jpg";
    String DESIGNER_THIRD_URL = "http://www.faspire.in/faspire_android/photographer_category_image/youth_photographer.jpg";

    Intent intent;
    String getCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photographer_category);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        intent = getIntent();
        getCity = intent.getStringExtra("cityName");

        imageFirst = (CircleImageView) findViewById(R.id.photographerCategoryFirst);
        imageSecond = (CircleImageView) findViewById(R.id.photographerCategorySecond);
        imageThird = (CircleImageView) findViewById(R.id.photographerCategoryThird);

        PicassoClient.downloadImgae(PhotographerCategory.this,DESIGNER_FIRST_URL,imageFirst);
        PicassoClient.downloadImgae(PhotographerCategory.this,DESIGNER_SECOND_URL,imageSecond);
        PicassoClient.downloadImgae(PhotographerCategory.this,DESIGNER_THIRD_URL,imageThird);

        imageFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PhotographerCategory.this,FaspireFashionStudio.class);
                i.putExtra("cityName",getCity);
                startActivity(i);

            }
        });

        imageSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PhotographerCategory.this,FaspireProfessionalPhotographer.class);
                i.putExtra("cityName",getCity);
                startActivity(i);

            }
        });

        imageThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PhotographerCategory.this,FaspireYouthPhotographer.class);
                i.putExtra("cityName",getCity);
                startActivity(i);

            }
        });
    }
}
