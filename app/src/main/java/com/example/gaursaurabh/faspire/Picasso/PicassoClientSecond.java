package com.example.gaursaurabh.faspire.Picasso;

import android.content.Context;
import android.widget.ImageView;

import com.example.gaursaurabh.faspire.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Saurabh Gaur on 5/14/2017.
 */
public class PicassoClientSecond {

    public static void downloadImgae(Context c, String url, ImageView img)
    {
        if(url != null && url.length()>0)
        {
            Picasso.with(c).load(url).placeholder(R.drawable.placeholder_fourth).into(img);
        }else {
            Picasso.with(c).load(R.drawable.placeholder_fourth).into(img);
        }
    }
}
