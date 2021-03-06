package com.example.gaursaurabh.faspire;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gaursaurabh.faspire.ActorFile.ActorAdapter;
import com.example.gaursaurabh.faspire.AssociatesAndSponsourFile.Associates;
import com.example.gaursaurabh.faspire.AssociatesAndSponsourFile.SponsoursFile;
import com.example.gaursaurabh.faspire.ListData.AssociatesSponsoursList;
import com.example.gaursaurabh.faspire.ListData.DataList;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sponsours extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private SponsoursFile adapter;
    private List<AssociatesSponsoursList> associatesSponsoursLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsours);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_sponsours);
        associatesSponsoursLists = new ArrayList<>();
        load_data_from_server();
        gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new SponsoursFile(this,associatesSponsoursLists);
        recyclerView.setAdapter(adapter);
    }

    private void load_data_from_server() {

        AsyncTask<Integer, Void, Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url("http://www.faspire.in/faspire_android/sponsours.php").build();
                try {
                    Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    for (int i=0;i<array.length();i++){
                        JSONObject object = array.getJSONObject(i);

                        AssociatesSponsoursList data = new AssociatesSponsoursList(object.getString("sponsours_image"),object.getString("sponsours_name"),object.getString("sponsours_link"));
                        associatesSponsoursLists.add(data);

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
}
