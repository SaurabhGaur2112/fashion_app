package com.example.gaursaurabh.faspire.NewsFile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.ListData.FeedItem;
import com.example.gaursaurabh.faspire.Picasso.PicassoClient;
import com.example.gaursaurabh.faspire.ProfileDesigner;
import com.example.gaursaurabh.faspire.R;
import com.example.gaursaurabh.faspire.ShowImageNews;
import com.example.gaursaurabh.faspire.ShowVideoNews;

import java.util.List;

/**
 * Created by Saurabh Gaur on 2/6/2017.
 */
public class NewsListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<FeedItem> feedItems;

    public NewsListAdapter(Activity activity,List<FeedItem> feedItems){
        this.activity = activity;
        this.feedItems = feedItems;
    }

    @Override
    public int getCount() {
        return feedItems.size();
    }

    @Override
    public Object getItem(int location) {
        return feedItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {

        if(inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(converView == null)
            converView = inflater.inflate(R.layout.faspire_news_list,null);

        ImageView profileImg = (ImageView) converView.findViewById(R.id.profileImage);
        TextView headTxt = (TextView) converView.findViewById(R.id.headline);
        //TextView descTxt = (TextView) converView.findViewById(R.id.description);
        TextView represntTxt = (TextView) converView.findViewById(R.id.represnttext);
        LinearLayout layout = (LinearLayout) converView.findViewById(R.id.layoutClickable);

        final FeedItem item = feedItems.get(position);

        headTxt.setText(item.getHeadline());
        //descTxt.setText(item.getDescription());

        if(!item.getRepresent().equals("null"))
        {
            represntTxt.setText(item.getRepresent());
        } else {
            represntTxt.setVisibility(View.GONE);
        }

        PicassoClient.downloadImgae(activity,item.getImage(),profileImg);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(item.getImageVideo().equals("link"))
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getLink()));
                    activity.startActivity(intent);
                }
                if(item.getImageVideo().equals("image"))
                {
                    Intent intent = new Intent(activity, ShowImageNews.class);
                    intent.putExtra("NewsId",item.getId());
                    activity.startActivity(intent);
                }
                if(item.getImageVideo().equals("video"))
                {
                    Intent intent = new Intent(activity, ShowVideoNews.class);
                    intent.putExtra("NewsId",item.getId());
                    activity.startActivity(intent);
                }
            }
        });

        return converView;
    }
}
