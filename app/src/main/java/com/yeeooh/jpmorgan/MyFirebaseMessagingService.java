package com.yeeooh.jpmorgan;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.yeeooh.jpmorgan.activities.HomeActivity;


import org.json.JSONObject;


/**
 * Created by Employee on 4/10/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {



    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.v("NO ", "Notification Triggered: onMessage receive" );
    }


    /*@Override
    public void handleIntent(Intent intent) {
        super.handleIntent(intent);
        Log.v("NO ", "Notification Triggered:" + intent.getExtras());
        String message = intent.getExtras().getString("message");
        String title = intent.getExtras().getString("title");
        callNotifications(title,message);
    }*/

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("NO ", "Notification Triggered: Destoryed ");
         Intent restartService = new Intent(getApplicationContext(), MyFirebaseMessagingService.class);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(),1,restartService,PendingIntent.FLAG_ONE_SHOT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME,1000,pendingIntent);
    }

    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }

    @Override
    public void onMessageSent(String s) {
        super.onMessageSent(s);
    }

    NotificationCompat.Builder notification;

    private void callNotifications(String title,String msg)
    {

        Intent in =  new Intent(getApplicationContext(), HomeActivity.class);
        in.addFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT);
      PendingIntent  pendingIntent = PendingIntent.getActivity(this, 0,in, PendingIntent.FLAG_CANCEL_CURRENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            notification = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent))
                    .setContentTitle("GotiT")
                    .setContentText(title)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notification.build());

        } else {
            notification = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("GotiT")
                    .setContentText(title)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notification.build());
        }
    }

    private void insertMessage(JSONObject obj,Bundle b)
    {



    }

    private void callDeliveryService(String message_id )
    {





    }
}
