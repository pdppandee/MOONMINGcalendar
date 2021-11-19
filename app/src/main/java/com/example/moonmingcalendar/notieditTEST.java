//package com.example.moonmingcalendar;
//
//
//import android.app.AlarmManager;
//import android.app.PendingIntent;
//import android.content.Intent;
//import android.database.Cursor;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.TimePicker;
//import android.widget.Toast;
//
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.Calendar;
//import java.util.Locale;
//
//public class AddUserEvent extends AppCompatActivity{
//    EditText eventName, eventDetail;
//    Button addUserEventButton, selectTimeButton, btnBack;
//    DbPayHelper pDatabaseHelper;
//    TimePicker timePicker;
//    CheckBox addNotiChkBox;
//    int hour, minute;
//    boolean addNotiisChecked, noti = false;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.add_user_event);
//
//        //--------------------set FIND VIEW BY ID-------------------
//        eventName = findViewById(R.id.eventname);
//        eventDetail = findViewById(R.id.eventDetail);
//        addUserEventButton = findViewById(R.id.addUserEventButton);
//        pDatabaseHelper = new DbPayHelper(this);
//        timePicker = findViewById(R.id.timePicker);
//
//        addNotiChkBox = findViewById(R.id.addNotiChkbox);
//        addNotiisChecked = addNotiChkBox.isChecked();
//
//        String day = getIntent().getExtras().getString("day");
//
//        addUserEventButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final String name = eventName.getText().toString();
//                final String detail = eventDetail.getText().toString();
//                String time = String.format(Locale.getDefault(), "%02d:%02d",hour, minute);
//
//                if (eventName.length() != 0 && eventDetail.length() != 0) {
//                    eventName.setText("");
//                    eventDetail.setText("");
//                    if(addNotiisChecked){
//                        noti = true;
//                        toastMessage("ตั้งแจ้งเตือน:-D");
//                    }
//                    AddData(day,name,detail,noti,time);
//
//                    //        Set noti & message
//                    String id = GetID(day,name);
//                    Intent intent = new Intent(getApplicationContext(), Notifications.class);
//                    intent.putExtra("NotificationID", id);
//                    intent.putExtra("Message", name);
//                    AlarmManager alarmManager;
//                    PendingIntent alarmIntent = PendingIntent.getBroadcast(
//                            getApplicationContext(),0,intent,
//                            PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);
//                    //        AlarmManager
//                    alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//                    if (GetNoti(id)){
//
//                        String[] time2 = GetTime(id).split(":");
//                        int hr = Integer.parseInt(time2[0]);
//                        int min = Integer.parseInt(time2[1]);
//
//                        //        Create TIme
//                        Calendar startTime = Calendar.getInstance();
//                        startTime.set(Calendar.HOUR_OF_DAY, hr);
//                        startTime.set(Calendar.MINUTE,min);
//                        startTime.set(Calendar.SECOND, 0);
//                        long alarmStartTime = startTime.getTimeInMillis();
//
//                        //       Set Alarm
//                        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);
//
//                    }
//                }else {
//                    toastMessage("กรุณาใส่ข้อความที่ต้องการ!");
//                }
//            }
//        });
//
//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker timePicker, int selectedHour, int selectedMinute) {
//                hour = selectedHour;
//                minute = selectedMinute;
//                String timeSelected = makeTimeString(hour, minute);
//            }
//        });
//
//
//        btnBack = findViewById(R.id.addBack);
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent showeventlist = new Intent(AddUserEvent.this, ShowEventList.class);
//                showeventlist.putExtra("day",day);
//                startActivity(showeventlist);
//            }
//        });
//    }
//
////    -----------------------------end of Oncreate -----------------------
//
//    private String makeTimeString(int hour, int minute){
//        return hour + " : " + minute;
//    }
//
//    //    ----------------------------- Add data to db -----------------------
//    public void AddData(String day, String name, String detail, boolean noti, String time) {
//        addNotiisChecked = addNotiChkBox.isChecked();
//        boolean insertData = pDatabaseHelper.addData(day,name,detail,addNotiisChecked,time);
//
//        if (insertData) {
//            toastMessage("เพิ่มกิจรรมเสร็จสิ้นจ้า :-D");
//        } else {
//            toastMessage("เพิ่มกิจรรมไม่สำเร็จ ;-;");
//        }
//    }
//
//    public Boolean GetNoti(String id) {
//        Cursor data = pDatabaseHelper.getEventNoti(id);
//        data.moveToFirst();
//        if (data.getString(0).equals("1")){
//            return true;
//        }
//        return false;
//    }
//
//    private void toastMessage(String message) {
//        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
//    }
//
//    //    get id
//    public String GetID(String date,String name) {
//        Cursor data = pDatabaseHelper.getEventID(date,name);
//        data.moveToFirst();
//        String id = data.getString(0);
//
//        return id;
//    }
//    //    get time
//    public String GetTime(String id) {
//        Cursor data = pDatabaseHelper.getTime(id);
//        data.moveToFirst();
//        String time = data.getString(0);
//
//        return time;
//    }
//
//}
