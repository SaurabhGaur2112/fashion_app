package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.gaursaurabh.faspire.Picasso.PicassoClient;

import de.hdodenhof.circleimageview.CircleImageView;

public class DesignerCategory extends AppCompatActivity {

    CircleImageView imageFirst,imageSecond,imageThird;

    String DESIGNER_FIRST_URL = "http://www.faspire.in/faspire_android/designer_category_image/celebrity_designer.jpg";
    String DESIGNER_SECOND_URL = "http://www.faspire.in/faspire_android/designer_category_image/professional_designer.jpg";
    String DESIGNER_THIRD_URL = "http://www.faspire.in/faspire_android/designer_category_image/youth_designer.jpg";

    Intent intent;
    String getCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_category);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        intent = getIntent();
        getCity = intent.getStringExtra("cityName");

        imageFirst = (CircleImageView) findViewById(R.id.designerCategoryFirst);
        imageSecond = (CircleImageView) findViewById(R.id.designerCategorySecond);
        imageThird = (CircleImageView) findViewById(R.id.designerCategoryThird);

        PicassoClient.downloadImgae(DesignerCategory.this,DESIGNER_FIRST_URL,imageFirst);
        PicassoClient.downloadImgae(DesignerCategory.this,DESIGNER_SECOND_URL,imageSecond);
        PicassoClient.downloadImgae(DesignerCategory.this,DESIGNER_THIRD_URL,imageThird);

        imageFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DesignerCategory.this,CelebrityDesigner.class);
                i.putExtra("cityName",getCity);
                startActivity(i);

            }
        });

        imageSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DesignerCategory.this,FaspireProfessionalDesigner.class);
                i.putExtra("cityName",getCity);
                startActivity(i);

            }
        });

        imageThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DesignerCategory.this,FaspireYouthDesigner.class);
                i.putExtra("cityName",getCity);
                startActivity(i);

            }
        });
    }
}
