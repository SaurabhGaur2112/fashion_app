package com.example.gaursaurabh.faspire;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.gaursaurabh.faspire.Cache.AppController;
import com.example.gaursaurabh.faspire.CheckNetworkConnection.ConnectionDetector;
import com.example.gaursaurabh.faspire.FlashBackFile.FlashListAdapter;
import com.example.gaursaurabh.faspire.ListData.FeedItem;
import com.example.gaursaurabh.faspire.NewsFile.NewsListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class FlashBack extends AppCompatActivity {

    private static final String TAG = FaspireNews.class.getSimpleName();
    private ListView listView;
    private ProgressBar progressBar;
    private FlashListAdapter listAdapter;
    private List<FeedItem> feedItems;
    private String URL_FEED = "http://www.faspire.in/faspire_android/flash_back.php";
    ConnectionDetector cd;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_back);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        cd = new ConnectionDetector(this);
        listView = (ListView) findViewById(R.id.flashListView);
        progressBar = (ProgressBar) findViewById(R.id.flash_progressbar);

        feedItems = new ArrayList<FeedItem>();

        listAdapter = new FlashListAdapter(this,feedItems);
        listView.setAdapter(listAdapter);

        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(URL_FEED);

        if(cd.isConnected())
        {
            JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET, URL_FEED , null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    VolleyLog.d(TAG, "Response: " + response.toString());
                    if (response != null) {
                        progressBar.setVisibility(View.GONE);
                        parseJsonFeed(response);
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                }
            });

            AppController.getInstance().addToRequestQueue(jsonReq);
        } else {
            if (entry != null) {
                try {
                    String data = new String(entry.data, "UTF-8");
                    try {
                        progressBar.setVisibility(View.GONE);
                        parseJsonFeed(new JSONObject(data));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private void parseJsonFeed(JSONObject response){
        try {
            JSONArray feedArray = response.getJSONArray("feed");

            for(int i=0; i<feedArray.length(); i++){
                JSONObject feedObj = (JSONObject) feedArray.get(i);

                FeedItem item = new FeedItem();

                item.setId(feedObj.getString("flash_id"));
                item.setImage(feedObj.getString("flash_image"));
                item.setHeadline(feedObj.getString("flash_headline"));
                //item.setDescription(feedObj.getString("flash_description"));
                item.setLink(feedObj.getString("flash_link"));
                item.setImageVideo(feedObj.getString("flash_image_video"));
                item.setRepresent(feedObj.getString("flash_represent"));

                feedItems.add(item);
            }
            listAdapter.notifyDataSetChanged();
        } catch (JSONException e){
            e.printStackTrace();
        }
    }
}
