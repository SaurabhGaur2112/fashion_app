package com.example.gaursaurabh.faspire;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.example.gaursaurabh.faspire.BoutiqueFile.BoutiqueAdapter;
import com.example.gaursaurabh.faspire.CoordinatorFile.CoordinatorAdapter;
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

public class FashionCoordinator extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private CoordinatorAdapter adapter;
    private List<DataList> dataLists;

    Intent intent;
    String getFaspire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion_coordinator);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        intent = getIntent();
        getFaspire = intent.getStringExtra("cityName");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_coordinator);
        dataLists = new ArrayList<>();
        load_data_from_server();
        gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new CoordinatorAdapter(this,dataLists);
        recyclerView.setAdapter(adapter);
    }

    private void load_data_from_server() {

        AsyncTask<Integer, Void, Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url("http://www.faspire.in/faspire_android/fashion_coordinator.php?city="+getFaspire).build();
                try {
                    Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    for (int i=0;i<array.length();i++){
                        JSONObject object = array.getJSONObject(i);

                        DataList data = new DataList(object.getString("boutique_id"),object.getString("boutique_name"),object.getString("boutique_image"));
                        dataLists.add(data);

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
