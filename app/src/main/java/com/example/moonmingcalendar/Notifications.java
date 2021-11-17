package com.example.moonmingcalendar;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class Notifications extends BroadcastReceiver {

    private  static  final Integer notificationID = 1;
    private  static final String channelID = "channel 1";
    private  static final String titleExtra = "Ayy Yo";
    private  static final String contentText = "งว่วง";


    @Override
    public void onReceive(Context context, Intent intent) {

        //       call adduserevent when noti is tapped
        Intent intentadduserevent = new Intent(context,AddUserEvent.class);
        intentadduserevent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0, intentadduserevent,0);


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

//  ลอง
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            CharSequence channelName = "My Notification";
            NotificationChannel channel = new NotificationChannel(channelID,channelName, importance);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,channelID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(intent.getStringExtra(titleExtra))
                .setContentText(intent.getStringExtra(contentText))
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        notificationManager.notify(notificationID, builder.build());
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
