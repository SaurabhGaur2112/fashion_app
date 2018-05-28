package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FaspireStart extends AppCompatActivity {

    Button skipBtn,joinBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_faspire_start);
        skipBtn = (Button) findViewById(R.id.skipButton);
        joinBtn = (Button) findViewById(R.id.joinButton);
        skipBtn.setText("Let's Get FASPIRE");
        joinBtn.setText("Join");

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FaspireStart.this,FaspireJoin.class));
            }
        });

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FaspireStart.this,FaspireHome.class));
                finish();
            }
        });
    }
}
