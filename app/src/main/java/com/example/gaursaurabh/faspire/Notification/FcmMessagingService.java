package com.example.gaursaurabh.faspire.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.example.gaursaurabh.faspire.FaspireHome;
import com.example.gaursaurabh.faspire.FaspireNews;
import com.example.gaursaurabh.faspire.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Saurabh Gaur on 1/13/2018.
 */

public class FcmMessagingService extends FirebaseMessagingService {

    Intent intent;
    Context context;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        if(remoteMessage.getData().size()>0){

            String title,message,img_url,page_type;
            title = remoteMessage.getData().get("title");
            message = remoteMessage.getData().get("message");
            img_url = remoteMessage.getData().get("img_url");
            page_type = remoteMessage.getData().get("page_type");

            if(page_type.equals("news")){
                Toast.makeText(this, page_type, Toast.LENGTH_SHORT).show();
                intent = new Intent(this, FaspireNews.class);
            } else if(page_type.equals("tips")){

            } else if(page_type.equals("trends")){

            } else {
                Toast.makeText(this, page_type, Toast.LENGTH_SHORT).show();
                intent = new Intent(this, FaspireHome.class);
            }

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
            Uri sounduri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setContentTitle(title);
            builder.setContentText(message);
            builder.setContentIntent(pendingIntent);
            //builder.setSound(sounduri);
            builder.setDefaults(Notification.DEFAULT_SOUND);
            builder.setSmallIcon(R.drawable.ic_notification);
            //builder.setColor(Color.GREEN)
            builder.setColor(ContextCompat.getColor(context,R.color.colorPrimary));

            ImageRequest imageRequest = new ImageRequest(img_url, new Response.Listener<Bitmap>() {

                @Override
                public void onResponse(Bitmap response) {

                    builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(response));
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.notify(0,builder.build());
                }
            }, 0, 0, null, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

            MySingleton.getmInstance(this).addToRequestQue(imageRequest);
        }
    }
}
