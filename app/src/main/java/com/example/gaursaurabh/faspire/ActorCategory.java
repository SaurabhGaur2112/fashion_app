package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.gaursaurabh.faspire.Picasso.PicassoClient;

import de.hdodenhof.circleimageview.CircleImageView;

public class ActorCategory extends AppCompatActivity {

    CircleImageView imageFirst,imageSecond,imageThird;

    String DESIGNER_FIRST_URL = "http://www.faspire.in/faspire_android/actor_category_image/bigscreen_artist_actor.jpg";
    String DESIGNER_SECOND_URL = "http://www.faspire.in/faspire_android/actor_category_image/theatre_artist_actor.jpg";
    String DESIGNER_THIRD_URL = "http://www.faspire.in/faspire_android/actor_category_image/youth_artist_actor.jpg";

    Intent intent;
    String getCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_category);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        intent = getIntent();
        getCity = intent.getStringExtra("cityName");

        imageFirst = (CircleImageView) findViewById(R.id.actorCategoryFirst);
        imageSecond = (CircleImageView) findViewById(R.id.actorCategorySecond);
        imageThird = (CircleImageView) findViewById(R.id.actorCategoryThird);

        PicassoClient.downloadImgae(ActorCategory.this,DESIGNER_FIRST_URL,imageFirst);
        PicassoClient.downloadImgae(ActorCategory.this,DESIGNER_SECOND_URL,imageSecond);
        PicassoClient.downloadImgae(ActorCategory.this,DESIGNER_THIRD_URL,imageThird);

        imageFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActorCategory.this,FaspireBigScreenActor.class);
                i.putExtra("cityName",getCity);
                startActivity(i);

            }
        });

        imageSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActorCategory.this,FaspireTheatorActor.class);
                i.putExtra("cityName",getCity);
                startActivity(i);

            }
        });

        imageThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActorCategory.this,FaspireYouthActor.class);
                i.putExtra("cityName",getCity);
                startActivity(i);

            }
        });
    }
}
