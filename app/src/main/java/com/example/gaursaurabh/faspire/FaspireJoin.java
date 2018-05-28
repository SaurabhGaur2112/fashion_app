package com.example.gaursaurabh.faspire;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.CheckNetworkConnection.ConnectionDetector;
import com.example.gaursaurabh.faspire.ContactAndJoinForm.FaspireJoinForm;

public class FaspireJoin extends AppCompatActivity {

    Spinner occupation;
    String occu[] = {"--Select--","Model","Actor","Designer","Photographer","Makup artist","Fashion Blogger","Fashion Coordinator","Other"};
    EditText joinTxt,joincheckEdtxt;
    EditText joinNameTxt,joinNumberTxt,joinEmailTxt,joinQueryTxt,joinCityTxt;
    CheckBox joinCheckTxt;
    ConnectionDetector cd;
    FaspireJoinForm faspireJoinForm;
    Button joinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faspire_join);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        cd = new ConnectionDetector(this);
        faspireJoinForm = new FaspireJoinForm();

        occupation = (Spinner) findViewById(R.id.joinOccupation);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,occu);
        occupation.setAdapter(adapter);

        joinTxt = (EditText) findViewById(R.id.joinOccupationEdtTxt);
        joinNameTxt = (EditText) findViewById(R.id.joinName);
        joinNumberTxt = (EditText) findViewById(R.id.joinNumber);
        joinEmailTxt = (EditText) findViewById(R.id.joinEmail);
        joinQueryTxt = (EditText) findViewById(R.id.joinQuery);
        joinCheckTxt = (CheckBox) findViewById(R.id.joinCheckBox);
        joincheckEdtxt = (EditText) findViewById(R.id.joinCheckBoxEditText);
        joinButton = (Button) findViewById(R.id.join_btn);
        joinCityTxt = (EditText) findViewById(R.id.joinCity);

        joinCheckTxt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {
                    joincheckEdtxt.setText("check");
                } else {
                    joincheckEdtxt.setText("not check");
                }
            }
        });

        occupation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                joinTxt.setText(occu[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cd.isConnected()){
                    String name,number,email,occupation,query,checkbox,city;
                    name = joinNameTxt.getText().toString();
                    number = joinNumberTxt.getText().toString();
                    email = joinEmailTxt.getText().toString();
                    occupation = joinTxt.getText().toString();
                    query = joinQueryTxt.getText().toString();
                    checkbox = joincheckEdtxt.getText().toString();
                    city = joinCityTxt.getText().toString();

                    if(checkbox.equals("check"))
                    {
                        if(!occupation.equals("--Select--"))
                        {
                            faspireJoinForm.submitJoinFormValue(name,number,email,occupation,query,city);
                            Toast.makeText(FaspireJoin.this, "Successfully Submit", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(FaspireJoin.this, "Select any one Occupation", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(FaspireJoin.this, "Agree Terms and Services", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(FaspireJoin.this, "No Internet connection", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
