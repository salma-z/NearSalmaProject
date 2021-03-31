package com.example.nearsalmaproject;


import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;

public class MyIntentService extends IntentService {


    private static final String CHANNEL_ID = "LOGIN_CHANNEL";
    private static final int REQUEST_CODE = 1;
    private static final int NOTIFICATION_ID =1 ;

    /**
     * @deprecated
     */
    public MyIntentService() { super("my service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        createNotificationChannel();
        Notification.Builder nBuilder = new Notification.Builder(this);
        nBuilder.setContentTitle("WELCOME");
        nBuilder.setContentText("you're now logged in");
        nBuilder.setSmallIcon(R.drawable.icons8);

        Intent intent1 = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, REQUEST_CODE, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        nBuilder.setContentIntent(pendingIntent);
        nBuilder.setChannelId(CHANNEL_ID);
        
        Notification notification = nBuilder.build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID, notification);
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}