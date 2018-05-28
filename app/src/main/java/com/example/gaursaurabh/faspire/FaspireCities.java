package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.Picasso.PicassoClient;

import de.hdodenhof.circleimageview.CircleImageView;

public class FaspireCities extends AppCompatActivity {

    CircleImageView mumbai,delhi,banglore,jaipur;
    Intent intent;
    Intent faspireIntent;
    String getFaspire;

    String CITY_FIRST_URL = "http://www.faspire.in/faspire_android/city_image/mumbai.jpg";
    String CITY_SECOND_URL = "http://www.faspire.in/faspire_android/city_image/delhi.jpg";
    String CITY_THIRD_URL = "http://www.faspire.in/faspire_android/city_image/bangalore.jpg";
    String CITY_FOURTH_URL = "http://www.faspire.in/faspire_android/city_image/jaipur.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faspire_cities);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        intent = getIntent();
        getFaspire = intent.getStringExtra("fileName");

        mumbai = (CircleImageView) findViewById(R.id.mumbai);
        delhi = (CircleImageView) findViewById(R.id.delhi);
        banglore = (CircleImageView) findViewById(R.id.banglore);
        jaipur = (CircleImageView) findViewById(R.id.jaipur);

        PicassoClient.downloadImgae(FaspireCities.this,CITY_FIRST_URL,mumbai);
        PicassoClient.downloadImgae(FaspireCities.this,CITY_SECOND_URL,delhi);
        PicassoClient.downloadImgae(FaspireCities.this,CITY_THIRD_URL,banglore);
        PicassoClient.downloadImgae(FaspireCities.this,CITY_FOURTH_URL,jaipur);

        mumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(getFaspire.equals("boutique")){
//                    faspireIntent = new Intent(FaspireCities.this, Boutique.class);
//                    faspireIntent.putExtra("cityName","mumbai");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("designer")){
//                    faspireIntent = new Intent(FaspireCities.this, DesignerCategory.class);
//                    faspireIntent.putExtra("cityName","mumbai");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("fashion_stylist")){
//                    faspireIntent = new Intent(FaspireCities.this, FashionStylist.class);
//                    faspireIntent.putExtra("cityName","mumbai");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("actor")){
//                    faspireIntent = new Intent(FaspireCities.this, ActorCategory.class);
//                    faspireIntent.putExtra("cityName","mumbai");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("model")){
//                    faspireIntent = new Intent(FaspireCities.this, ModelCategory.class);
//                    faspireIntent.putExtra("cityName","mumbai");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("makeup_artist")){
//                    faspireIntent = new Intent(FaspireCities.this, MakeupArtistCategory.class);
//                    faspireIntent.putExtra("cityName","mumbai");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("photographer")){
//                    faspireIntent = new Intent(FaspireCities.this, PhotographerCategory.class);
//                    faspireIntent.putExtra("cityName","mumbai");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("fashion_coordinator")){
//                    faspireIntent = new Intent(FaspireCities.this, FashionCoordinator.class);
//                    faspireIntent.putExtra("cityName","mumbai");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("faspire_people")){
//                    faspireIntent = new Intent(FaspireCities.this, FaspirePeople.class);
//                    faspireIntent.putExtra("cityName","mumbai");
//                    startActivity(faspireIntent);
//
//                }  else {}
            }
        });

        delhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getFaspire.equals("boutique")){
                    faspireIntent = new Intent(FaspireCities.this, Boutique.class);
                    faspireIntent.putExtra("cityName","delhi");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("designer")){
                    faspireIntent = new Intent(FaspireCities.this, DesignerCategory.class);
                    faspireIntent.putExtra("cityName","delhi");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("fashion_stylist")){
                    faspireIntent = new Intent(FaspireCities.this, FashionStylist.class);
                    faspireIntent.putExtra("cityName","delhi");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("actor")){
                    faspireIntent = new Intent(FaspireCities.this, ActorCategory.class);
                    faspireIntent.putExtra("cityName","delhi");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("model")){
                    faspireIntent = new Intent(FaspireCities.this, ModelCategory.class);
                    faspireIntent.putExtra("cityName","delhi");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("makeup_artist")){
                    faspireIntent = new Intent(FaspireCities.this, MakeupArtistCategory.class);
                    faspireIntent.putExtra("cityName","delhi");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("photographer")){
                    faspireIntent = new Intent(FaspireCities.this, PhotographerCategory.class);
                    faspireIntent.putExtra("cityName","delhi");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("fashion_coordinator")){
                    faspireIntent = new Intent(FaspireCities.this, FashionCoordinator.class);
                    faspireIntent.putExtra("cityName","delhi");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("faspire_people")){
                    faspireIntent = new Intent(FaspireCities.this, FaspirePeople.class);
                    faspireIntent.putExtra("cityName","delhi");
                    startActivity(faspireIntent);

                }  else {}
            }
        });

        banglore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(getFaspire.equals("boutique")){
//                    faspireIntent = new Intent(FaspireCities.this, Boutique.class);
//                    faspireIntent.putExtra("cityName","banglore");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("designer")){
//                    faspireIntent = new Intent(FaspireCities.this, DesignerCategory.class);
//                    faspireIntent.putExtra("cityName","banglore");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("fashion_stylist")){
//                    faspireIntent = new Intent(FaspireCities.this, FashionStylist.class);
//                    faspireIntent.putExtra("cityName","banglore");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("actor")){
//                    faspireIntent = new Intent(FaspireCities.this, ActorCategory.class);
//                    faspireIntent.putExtra("cityName","banglore");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("model")){
//                    faspireIntent = new Intent(FaspireCities.this, ModelCategory.class);
//                    faspireIntent.putExtra("cityName","banglore");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("makeup_artist")){
//                    faspireIntent = new Intent(FaspireCities.this, MakeupArtistCategory.class);
//                    faspireIntent.putExtra("cityName","banglore");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("photographer")){
//                    faspireIntent = new Intent(FaspireCities.this, PhotographerCategory.class);
//                    faspireIntent.putExtra("cityName","banglore");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("fashion_coordinator")){
//                    faspireIntent = new Intent(FaspireCities.this, FashionCoordinator.class);
//                    faspireIntent.putExtra("cityName","banglore");
//                    startActivity(faspireIntent);
//
//                } else if(getFaspire.equals("faspire_people")){
//                    faspireIntent = new Intent(FaspireCities.this, FaspirePeople.class);
//                    faspireIntent.putExtra("cityName","banglore");
//                    startActivity(faspireIntent);
//
//                }  else {}
            }
        });

        jaipur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getFaspire.equals("boutique")){
                    faspireIntent = new Intent(FaspireCities.this, Boutique.class);
                    faspireIntent.putExtra("cityName","jaipur");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("designer")){
                    faspireIntent = new Intent(FaspireCities.this, DesignerCategory.class);
                    faspireIntent.putExtra("cityName","jaipur");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("fashion_stylist")){
                    faspireIntent = new Intent(FaspireCities.this, FashionStylist.class);
                    faspireIntent.putExtra("cityName","jaipur");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("actor")){
                    faspireIntent = new Intent(FaspireCities.this, ActorCategory.class);
                    faspireIntent.putExtra("cityName","jaipur");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("model")){
                    faspireIntent = new Intent(FaspireCities.this, ModelCategory.class);
                    faspireIntent.putExtra("cityName","jaipur");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("makeup_artist")){
                    faspireIntent = new Intent(FaspireCities.this, MakeupArtistCategory.class);
                    faspireIntent.putExtra("cityName","jaipur");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("photographer")){
                    faspireIntent = new Intent(FaspireCities.this, PhotographerCategory.class);
                    faspireIntent.putExtra("cityName","jaipur");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("fashion_coordinator")){
                    faspireIntent = new Intent(FaspireCities.this, FashionCoordinator.class);
                    faspireIntent.putExtra("cityName","jaipur");
                    startActivity(faspireIntent);

                } else if(getFaspire.equals("faspire_people")){
                    faspireIntent = new Intent(FaspireCities.this, FaspirePeople.class);
                    faspireIntent.putExtra("cityName","jaipur");
                    startActivity(faspireIntent);

                }  else {}
            }
        });
    }
}
