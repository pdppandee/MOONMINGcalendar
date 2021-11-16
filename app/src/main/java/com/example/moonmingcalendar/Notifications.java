package com.example.moonmingcalendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Notifications extends BroadcastReceiver {

    Integer notificationID = 1;
    public String channelID = "channel 1";
    String titleExtra = "Ayy Yo";
    String contentText = "งว่วง";


    @Override
    public void onReceive(Context context, Intent intent) {

//        Intent intentadduserevent = new Intent(context,AddUserEvent.class);
//        intentadduserevent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent pendingIntent = PendingIntent.getActivity(context,0, intentadduserevent,0);


        NotificationCompat.Builder notification = new NotificationCompat.Builder(context,"channelID")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(intent.getStringExtra(titleExtra))
                .setContentText(intent.getStringExtra(contentText))
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH);
//                .setContentIntent(pendingIntent);


        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(notificationID,notification.build());


    }

    public String getChannelID(){
        return channelID;
    }

    public String getTitleExtra() {
        return titleExtra;
    }

    public String getContentText() {
        return contentText;
    }

    public Integer getNotificationID() {
        return notificationID;
    }
}
