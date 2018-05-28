package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.CheckNetworkConnection.ConnectionDetector;

public class ContactMe extends AppCompatActivity {

    Intent intent;
    String codeGet;
    EditText contactEdTxt,numberEdTxt,emailEdTxt,queryEdTxt;
    ConnectionDetector cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_me);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        cd = new ConnectionDetector(this);
        intent = getIntent();

        Toast.makeText(ContactMe.this, codeGet, Toast.LENGTH_SHORT).show();
        contactEdTxt = (EditText) findViewById(R.id.contact_name);
        numberEdTxt = (EditText) findViewById(R.id.contact_number);
        emailEdTxt = (EditText) findViewById(R.id.contact_email);
        queryEdTxt = (EditText) findViewById(R.id.contact_query);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.submit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.joinSubmit)
        {
            if(cd.isConnected())
            {
                String name,number,email,query;
                name = contactEdTxt.getText().toString();
                number = numberEdTxt.getText().toString();
                email = emailEdTxt.getText().toString();
                query = queryEdTxt.getText().toString();

                Toast.makeText(ContactMe.this, codeGet, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ContactMe.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }


        }

        return false;
    }
}
