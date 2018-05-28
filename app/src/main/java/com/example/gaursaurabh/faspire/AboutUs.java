package com.example.gaursaurabh.faspire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        TextView txt = (TextView) findViewById(R.id.aboutUsTxt);
        txt.setText("Faspire is a Jaipur based fashion federation, which too has a long story behind this initiative. Initiation of concept is just like putting raw eggs in the basket, and the real work or we can say hatching of eggs starts when we starts applying our effect with our team coordination and collaboration, as to make things move like a cake walk.");

        TextView textView = (TextView) findViewById(R.id.aboutUsTitle);
        textView.setText("Hence it took a great effort and teamwork to reach where we are standing today. After exploring many cities, we are looking forward to make a new history of fashion in India itself along with international approach, as we have an association with some of the top notch brands, companies and endowed by well known professionals. So, it is our faith that, this initiative by our industry will definitely bring an era of fashion among youth, and will also reflect an immense change in one’s personality and living standard in a positive way.");

        TextView txtObj = (TextView) findViewById(R.id.aboutUsObjective);
        txtObj.setText("The foremost thing for an industry is to have objective of their existence hence our main objective is to provide our customer or client a one stop fashion hub where they can get potential fashion services for their all requirement with a great ease, along with this, it also helps in endorsing many fashion designers/brands, to create and grow their exclusive brand both nationally and internationally.");
    }
}
