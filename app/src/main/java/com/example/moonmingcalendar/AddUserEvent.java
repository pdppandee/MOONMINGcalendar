package com.example.moonmingcalendar;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class AddUserEvent extends AppCompatActivity implements View.OnClickListener {
    EditText eventName, eventDetail;
    Button addUserEventButton, selectTimeButton, btnBack;
    DbPayHelper pDatabaseHelper;
    TimePicker timePicker;
    CheckBox addNotiChkBox;
    int hour, minute;
    boolean addNotiisChecked;


//    private AddUserEventBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user_event);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //        binding = AddUserEventBinding.inflate(getLayoutInflater());
        //        setContentView(binding.getRoot());

        //        createNotificationChannel();

        //        binding.openNoti.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //
        ////                scheduleNotification();
        //            }
        //        });

    //--------------------set FIND VIEW BY ID-------------------
        eventName = findViewById(R.id.eventname);
        eventDetail = findViewById(R.id.eventDetail);
        addUserEventButton = findViewById(R.id.addUserEventButton);
        pDatabaseHelper = new DbPayHelper(this);
        timePicker = findViewById(R.id.timePicker);

        addNotiChkBox = findViewById(R.id.addNotiChkbox);
        addNotiChkBox.setOnClickListener(this);

        addNotiisChecked = addNotiChkBox.isChecked();

        String day = getIntent().getExtras().getString("day");

        addUserEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = eventName.getText().toString();
                final String detail = eventDetail.getText().toString();
        //     String time = selectTimeButton.getText().toString();
                String time = String.format(Locale.getDefault(), "%02d:%02d",hour, minute);
                String noti = "";

                if (eventName.length() != 0 && eventDetail.length() != 0) {
                    AddData(day,name,detail,noti,time);
                    eventName.setText("");
                    eventDetail.setText("");
                    if(addNotiisChecked){
                        onClick(addNotiChkBox);
                    }
                }else {
                    toastMessage("กรุณาใส่ข้อความที่ต้องการ!");
                }

            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                String timeSelected = makeTimeString(hour, minute);
            }
        });


        btnBack = findViewById(R.id.addBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showeventlist = new Intent(AddUserEvent.this, ShowEventList.class);
                showeventlist.putExtra("day",day);
                startActivity(showeventlist);
            }
        });
    }

//    -----------------------------end of Oncreate -----------------------

    private String makeTimeString(int hour, int minute){
        return hour + " : " + minute;
    }

//    ----------------------------- Add data to db -----------------------
    public void AddData(String day,String name,String detail,String noti,String time) {
        boolean insertData = pDatabaseHelper.addData(day,name,detail,noti,time);

        if (insertData) {
            toastMessage("เพิ่มกิจรรมเสร็จสิ้นจ้า :-D");
        } else {
            toastMessage("เพิ่มกิจรรมไม่สำเร็จ ;-;");
        }
    }



    public void addNoti(Boolean noti){

    }

    private void toastMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

//    ------------------------------set noti--------------------------
    private  int notificationID = 1;
    AlarmManager alarmManager;
    PendingIntent alarmIntent;


    @Override
    public void onClick(View v) {
        eventName = findViewById(R.id.eventname);
        timePicker = findViewById(R.id.timePicker);

    //        Set noti & message
        Intent intent = new Intent(getApplicationContext(), Notifications.class);
        intent.putExtra("notificationID", notificationID);
        intent.putExtra("message", eventName.getText().toString());

    //        PendingIntent
        PendingIntent alarmIntent = PendingIntent.getBroadcast(
                getApplicationContext(),0,intent,
                PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);

    //        AlarmManager
       alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        addNotiisChecked = addNotiChkBox.isChecked();

        if (addNotiisChecked){
            int hr = timePicker.getCurrentHour();
            int min = timePicker.getCurrentMinute();

            //        Create TIme
            Calendar startTime = Calendar.getInstance();
            startTime.set(Calendar.HOUR_OF_DAY, hr);
            startTime.set(Calendar.MINUTE,min);
            startTime.set(Calendar.SECOND, 0);
            long alarmStartTime = startTime.getTimeInMillis();

            //       Set Alarm
            alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);
            Toast.makeText(this,"ตั้งแจ้งเตือน", Toast.LENGTH_SHORT).show();

        }
        else {
            alarmManager.cancel(alarmIntent);
            Toast.makeText(this,"ยกเลิกตั้งแจ้งเตือน", Toast.LENGTH_SHORT).show();
        }


        //        switch (v.getId()){
        //            case  R.id.addNotiChkbox :
        //                int hr = timePicker.getCurrentHour();
        //                int min = timePicker.getCurrentMinute();
        //
        ////                Create TIme
        //                Calendar startTime = Calendar.getInstance();
        //                startTime.set(Calendar.HOUR_OF_DAY, hr);
        //                startTime.set(Calendar.MINUTE,min);
        //                startTime.set(Calendar.SECOND, 0);
        //                long alarmStartTime = startTime.getTimeInMillis();
        //
        ////               Set Alarm
        //                alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);
        //
        //                Toast.makeText(this,"สำเร็จ", Toast.LENGTH_SHORT).show();
        //                break;
        //
        //
        //
        //            case R.id.addUserEventButton:
        ////                cancle Alarm เดะมาแก้ปุ่มน้า
        //                alarmManager.cancel(alarmIntent);
        //                Toast.makeText(this,"อิตาบ้า",Toast.LENGTH_SHORT).show();
        //                break;
        //
        //        }
    }
//    private  void  removeNoti(){
//        alarmManager.cancel(alarmIntent);
//        Toast.makeText(this,"ยกเลิกตั้งแจ้งเตือน", Toast.LENGTH_SHORT).show();
//    }

//    private void addNoti() {
//        addNotiisChecked = addNotiChkBox.isChecked();
//
//        if (addNotiisChecked){
//
//            Toast.makeText(this,"ตั้งแจ้งเตือน", Toast.LENGTH_SHORT).show();
//
//            int hr = timePicker.getCurrentHour();
//            int min = timePicker.getCurrentMinute();
//
//            //        Create TIme
//            Calendar startTime = Calendar.getInstance();
//            startTime.set(Calendar.HOUR_OF_DAY, hr);
//            startTime.set(Calendar.MINUTE,min);
//            startTime.set(Calendar.SECOND, 0);
//            long alarmStartTime = startTime.getTimeInMillis();
//
//            //       Set Alarm
//            alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);
//
//        }
//        else {
//            Toast.makeText(this,"ยกเลิกตั้งแจ้งเตือน", Toast.LENGTH_SHORT).show();
//        }
//
//    }
// ------------------------------test noti-----------------------------------------------
//    private void scheduleNotification() {
//        Intent intent = new Intent(getApplicationContext(), Notifications.class);
//        String title = binding.eventname.getText().toString();
//        String content = binding.eventDetail.getText().toString();
//        Notifications noti = new Notifications();
//
//        intent.putExtra(noti.getTitleExtra(), title);
//        intent.putExtra(noti.getContentText() , content);
//
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(
//          getApplicationContext(), noti.getNotificationID(),intent,
//                PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT
//        );
//        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        Long time = getTime();
////        alarmManager.setExact(AlarmManager.RTC_WAKEUP, time, pendingIntent);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, time,pendingIntent);
//
//        Toast.makeText(getApplicationContext(),"ตั้งแจ้งเตือน" + time, Toast.LENGTH_SHORT).show();
////        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
////            alarmManager.setExactAndAllowWhileIdle(
////                    AlarmManager.RTC_WAKEUP, time, pendingIntent
////
////            );
////        }
//////        showAlert(time, title, content);
//
//    }
//
////    private void showAlert(Long time, String title, String content) {
////        Date date = new Date(time);
////
////    }
//
//    private Long getTime() {
////        Integer minute = null;
////        Integer hours = null;
////        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
////            minute = binding.timePicker.getMinute();
////            hours = binding.timePicker.getHour();
////        }
//        int hr = binding.timePicker.getCurrentHour();
//        int min = binding.timePicker.getCurrentMinute();
//        String date = getIntent().getExtras().getString("day");
//        String[] datearr = date.split("/");
//        Integer day = Integer.parseInt(datearr[0]);
//        Integer month = Integer.parseInt(datearr[1]);
//        Integer year = Integer.parseInt(datearr[2]);
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, month, day, hr, min);
//        return calendar.getTimeInMillis();
//    }
//
//    private void createNotificationChannel() {
//        Notifications noti = new Notifications();
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            CharSequence name = "Notif Channel";
//            String desc = "desc";
//            int importance = NotificationManager.IMPORTANCE_HIGH;
//            NotificationChannel channel = new NotificationChannel(noti.getChannelID(),name,importance);
//            channel.setDescription(desc);
//
//            NotificationManager notificationManager = getSystemService(NotificationManager.class);
//            notificationManager.createNotificationChannel(channel);
//        }
//
//
//    }



// ------------------------------test poptimepicker mp-----------------------------------------------
//    public void popTimePicker(View view)
//    {
//        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
//        {
//            @Override
//            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
//            {
//                hour = selectedHour;
//                minute = selectedMinute;
//                String time = makeTimeString(hour, minute);
//                selectTimeButton.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
//            }
//        };
//
//        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);
//        timePickerDialog.setTitle("เลือกเวลา");
//        timePickerDialog.show();
//    }

}
