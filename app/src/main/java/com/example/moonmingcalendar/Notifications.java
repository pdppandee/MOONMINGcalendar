package com.example.moonmingcalendar;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class Notifications extends BroadcastReceiver {

    private  static  final Integer notificationID = 0;
    public final String channelID = "eventChannel";
    String titleExtra = "Ayy Yo";


    DbPayHelper pDatabaseHelper;
//    String[] data = GetData(id);


    @Override
    public void onReceive(Context context, Intent intent) {

        //       call adduserevent when noti is tapped
        Intent intentadduserevent = new Intent(context,AddUserEvent.class);
        intentadduserevent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent pendingIntent = PendingIntent.getActivity(context,0, intentadduserevent,0);


//        NotificationCompat.Builder notification = new NotificationCompat.Builder(context,channelID)
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle(intent.getStringExtra(titleExtra))
//                .setContentText(intent.getStringExtra(contentText))
//                .setAutoCancel(true)
//                .setDefaults(NotificationCompat.DEFAULT_ALL)
//                .setPriority(NotificationCompat.PRIORITY_HIGH);
//                .setContentIntent(pendingIntent);

//      noti manager
//        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
//        notificationManagerCompat.notify(notificationID,notification.build());


//https://www.youtube.com/watch?v=F3IFF8A-ewE&t=595s

//        get message get id from intent
        String content = intent.getStringExtra("Message");
        String eventid = intent.getStringExtra("NotificationID");
//         สร้าง channel
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            int importance = NotificationManager.IMPORTANCE_HIGH;
            CharSequence channelName = "Event Notification";
            NotificationChannel channel = new NotificationChannel(channelID,channelName, importance);
            notificationManager.createNotificationChannel(channel);
        }



        NotificationCompat.Builder notification = new NotificationCompat.Builder(context,channelID)
                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle(eventid)
                .setContentText(content)
//                .setContentText(intent.getStringExtra(contentText))
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        notificationManager.notify(notificationID, notification.build());
    }


//    private String[] GetData(String id) {
//        Cursor cursor = pDatabaseHelper.getData(id);
//        cursor.moveToFirst();
//        String[] data = {cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)};
//        return data;
//    }

    public String getName(String date) {
        Cursor data = pDatabaseHelper.getEventListName(date);
        String name = data.getString(0);
        return name;
    }


    public String GetID(String date,String name) {
        Cursor data = pDatabaseHelper.getEventID(date,name);
        data.moveToFirst();
        String id = data.getString(0);

        return id;
    }



    public String getChannelID(){ return channelID; }

    public String getTitleExtra() {
        return titleExtra;
    }

//    public String getContentText() {
//        return contentText;
//    }

    public Integer getNotificationID() {
        return notificationID;
    }
}
