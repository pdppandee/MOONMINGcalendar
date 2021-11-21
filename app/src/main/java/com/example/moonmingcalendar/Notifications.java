package com.example.moonmingcalendar;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class Notifications extends BroadcastReceiver {

//    private  static  final Integer notificationID = 0;
    public String channelID = "eventChannel";
    String titleExtra = "Ayy Yo";


    DbPayHelper pDatabaseHelper;
//    String[] data = GetData(id);


    @Override
    public void onReceive(Context context, Intent intent) {

        //       call adduserevent when noti is tapped
        Intent intentadduserevent = new Intent(context,AddUserEvent.class);
        intentadduserevent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);


//https://www.youtube.com/watch?v=F3IFF8A-ewE&t=595s

//        get message get id from intent
        String content = intent.getStringExtra("Message");
        String eventid = intent.getStringExtra("NotificationID"); // event channel id
//         สร้าง channel
        channelID = eventid;
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String groupID = "User Event Noti";
            String groupName = "EventNotification";
            NotificationChannelGroup group = new NotificationChannelGroup(groupID, groupName);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            CharSequence channelName = "Event";
            NotificationChannel channel = new NotificationChannel(channelID,channelName, importance);
            channel.setGroup(groupID);

            notificationManager.createNotificationChannelGroup(group);
            notificationManager.createNotificationChannel(channel);
        }



        NotificationCompat.Builder notification = new NotificationCompat.Builder(context,channelID)
                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle(eventid)
                .setContentText(content)
//                .setContentText(intent.getStringExtra(contentText))
                .setAutoCancel(true)
//                .setChannelId(channelID)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        notificationManager.notify(Integer.parseInt(channelID), notification.build());


    }



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

}
