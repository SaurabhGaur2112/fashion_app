package com.example.gaursaurabh.faspire;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gaursaurabh.faspire.DesignerFile.DesignerAdapter;
import com.example.gaursaurabh.faspire.ListData.DataList;
import com.example.gaursaurabh.faspire.PhotographerFile.PhotographerAdapter;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Designer extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private DesignerAdapter adapter;
    private List<DataList> dataLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_designer);
        dataLists = new ArrayList<>();
        load_data_from_server();
        gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new DesignerAdapter(this,dataLists);
        recyclerView.setAdapter(adapter);
    }

    private void load_data_from_server() {

        AsyncTask<Integer, Void, Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url("http://www.faspire.in/faspire_android/faspire_designer.php").build();
                try {
                    Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    for (int i=0;i<array.length();i++){
                        JSONObject object = array.getJSONObject(i);

                        DataList data = new DataList(object.getString("designer_id"),object.getString("designer_name"),object.getString("designer_image"));
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
