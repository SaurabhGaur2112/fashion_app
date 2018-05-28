package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.HomeFile.HomeAdapter;
import com.example.gaursaurabh.faspire.HomeFile.HomeData;
import com.example.gaursaurabh.faspire.Session.Session;
import com.squareup.okhttp.OkHttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


public class FaspireHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private HomeAdapter adapter;
    private List<HomeData> homeDatas;

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faspire_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        session = new Session(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        homeDatas = new ArrayList<>();
        load_data_from_server();
        gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new HomeAdapter(this,homeDatas);
        recyclerView.setAdapter(adapter);

    }

    private void load_data_from_server() {

        AsyncTask<Integer, Void, Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url("http://www.faspire.in/faspire_android/faspire_home.php").build();
                try {
                    Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    for (int i=0;i<array.length();i++){
                        JSONObject object = array.getJSONObject(i);

                        HomeData data = new HomeData(object.getString("home_name"),object.getString("home_category"),object.getString("home_image"));
                        homeDatas.add(data);

                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.notifyDataSetChanged();
            }
        };
        task.execute();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_apply) {
            startActivity(new Intent(FaspireHome.this,FaspireJoin.class));
        } else if (id == R.id.nav_share_fasion) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "faspire.team@gmail.com"));
            startActivity(intent);
        } else if (id == R.id.nav_services) {
            startActivity(new Intent(FaspireHome.this,Services.class));
        } else if (id == R.id.nav_associates) {
            startActivity(new Intent(FaspireHome.this,AssociatesAndPartners.class));
        } else if (id == R.id.nav_sponsour) {
            startActivity(new Intent(FaspireHome.this,Sponsours.class));
        } else if (id == R.id.nav_aboutUs) {
            startActivity(new Intent(FaspireHome.this,AboutUs.class));
        } else if(id == R.id.nav_contact_us) {
            startActivity(new Intent(FaspireHome.this,ContactUs.class));
        } else if(id == R.id.nav_Terms_services) {
            startActivity(new Intent(FaspireHome.this,TermsAndConditions.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
