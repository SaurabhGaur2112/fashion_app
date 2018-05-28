package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.gaursaurabh.faspire.Picasso.PicassoClient;

import de.hdodenhof.circleimageview.CircleImageView;

public class ModelCategory extends AppCompatActivity {

    CircleImageView imageFirst,imageSecond,imageThird;

    String DESIGNER_FIRST_URL = "http://www.faspire.in/faspire_android/model_category_image/professional_model.jpg";
    String DESIGNER_SECOND_URL = "http://www.faspire.in/faspire_android/model_category_image/youth_model.jpg";
    String DESIGNER_THIRD_URL = "http://www.faspire.in/faspire_android/model_category_image/kids_model.jpg";

    Intent intent;
    String getCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_category);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        intent = getIntent();
        getCity = intent.getStringExtra("cityName");

        imageFirst = (CircleImageView) findViewById(R.id.modelCategoryFirst);
        imageSecond = (CircleImageView) findViewById(R.id.modelCategorySecond);
        imageThird = (CircleImageView) findViewById(R.id.modelCategoryThird);

        PicassoClient.downloadImgae(ModelCategory.this,DESIGNER_FIRST_URL,imageFirst);
        PicassoClient.downloadImgae(ModelCategory.this,DESIGNER_SECOND_URL,imageSecond);
        PicassoClient.downloadImgae(ModelCategory.this,DESIGNER_THIRD_URL,imageThird);

        imageFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ModelCategory.this,FaspireProfessionalModel.class);
                i.putExtra("cityName",getCity);
                startActivity(i);
            }
        });

        imageSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ModelCategory.this,FaspireYouthModel.class);
                i.putExtra("cityName",getCity);
                startActivity(i);

            }
        });

        imageThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ModelCategory.this,FaspireSeniorModel.class);
                i.putExtra("cityName",getCity);
                startActivity(i);

            }
        });
    }
}
