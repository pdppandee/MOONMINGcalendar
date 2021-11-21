package com.example.moonmingcalendar;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
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

//public class AddUserEvent extends AppCompatActivity implements View.OnClickListener {
public class AddUserEvent extends AppCompatActivity{
    EditText eventName, eventDetail;
    Button addUserEventButton, selectTimeButton, btnBack;
    DbPayHelper pDatabaseHelper;
    TimePicker timePicker;
    CheckBox addNotiChkBox;
    int hour, minute;
    boolean addNotiisChecked, noti = false;
    String  id, day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user_event);

        //--------------------set FIND VIEW BY ID-------------------
        eventName = findViewById(R.id.eventname);
        eventDetail = findViewById(R.id.eventDetail);
        addUserEventButton = findViewById(R.id.addUserEventButton);
        pDatabaseHelper = new DbPayHelper(this);
        timePicker = findViewById(R.id.timePicker);

        addNotiChkBox = findViewById(R.id.addNotiChkbox);
        addNotiisChecked = addNotiChkBox.isChecked();

        day = getIntent().getExtras().getString("day");

        addUserEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = eventName.getText().toString();
                final String detail = eventDetail.getText().toString();
                String time = String.format(Locale.getDefault(), "%02d:%02d",hour, minute);

                if (eventName.length() != 0 && eventDetail.length() != 0) {
                    eventName.setText("");
                    eventDetail.setText("");

//                    setCheckbox(addNotiisChecked);
                        AddData(day, name, detail, noti, time);
                        setUserNotification(day, name);
                    noti = GetNoti(id);
                    System.out.println("add on click check noti "+ noti);
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

        addNotiChkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotiisChecked = addNotiChkBox.isChecked();
                setCheckbox(addNotiisChecked);
            }
        });
    }

//    -----------------------------end of Oncreate -----------------------

    private String makeTimeString(int hour, int minute){
        return hour + " : " + minute;
    }

    //    ----------------------------- Add data to db -----------------------
    public void AddData(String day, String name, String detail, boolean noti, String time) {
        addNotiisChecked = addNotiChkBox.isChecked();
        boolean insertData = pDatabaseHelper.addData(day,name,detail,addNotiisChecked,time);

        if (insertData) {
            toastMessage("เพิ่มกิจรรมเสร็จสิ้นจ้า :-D");
        } else {
            toastMessage("เพิ่มกิจรรมไม่สำเร็จ ;-;");
        }
    }

    public Boolean GetNoti(String id) {
        Cursor data = pDatabaseHelper.getEventNoti(id);
        data.moveToFirst();
        if (data.getString(0).equals("1")){
            return true;
        }
        return false;
    }

    private void toastMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    //    get id
    public String GetID(String date,String name) {
        Cursor data = pDatabaseHelper.getEventID(date,name);
        data.moveToFirst();
        String id = data.getString(0);

        return id;
    }
    //    get time
    public String GetTime(String id) {
        Cursor data = pDatabaseHelper.getTime(id);
        data.moveToFirst();
        String time = data.getString(0);

        return time;
    }

    public void setUserNotification(String day, String name) {
        //        Set noti & message

            id = GetID(day, name);
            Intent intent = new Intent(getApplicationContext(), Notifications.class);
            intent.putExtra("NotificationID", id);
            intent.putExtra("Message", name);
           // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            AlarmManager alarmManager;


            PendingIntent alarmIntent = PendingIntent.getBroadcast(
                    getApplicationContext(), Integer.parseInt(id), intent,
                    PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            if (GetNoti(id)) {
                String[] time2 = GetTime(id).split(":");
                int hr = Integer.parseInt(time2[0]);
                int min = Integer.parseInt(time2[1]);

//                String[] date = day.split("/");

                System.out.println(id);

                //        Create TIme
                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, hr);
                startTime.set(Calendar.MINUTE, min);
                startTime.set(Calendar.SECOND, 0);
//                startTime.set(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));

//                String date = getIntent().getExtras().getString("day");
//                String[] datearr = date.split("/");
//                Integer dayy = Integer.parseInt(datearr[0]);
//                Integer month = Integer.parseInt(datearr[1]);
//                Integer year = Integer.parseInt(datearr[2]);
//                Calendar calendar = Calendar.getInstance();
//                calendar.set(year, month, dayy, hr, min);

                long alarmStartTime = startTime.getTimeInMillis();

                //       Set Alarm
                alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);


        }
    }




    private void setCheckbox(boolean ischecked){

        System.out.println("setchkbox1"+ ischecked);
        if (ischecked) {
            noti = true;
            System.out.println("setchk"+ ischecked);
            Toast.makeText(getApplicationContext(), "ตั้งค่าแจ้งเตือน:-D", Toast.LENGTH_SHORT).show();


        }else {
            System.out.println(ischecked);
//            Toast.makeText(getApplicationContext(), "ยกเลิกแจ้งเตือน:-D", Toast.LENGTH_SHORT).show();
        }
    }

}



//    private AddUserEventBinding binding;


//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.add_user_event);
//
//        //        binding = AddUserEventBinding.inflate(getLayoutInflater());
//        //        setContentView(binding.getRoot());
//
//        //        createNotificationChannel();
//
//        //        binding.openNoti.setOnClickListener(new View.OnClickListener() {
//        //            @Override
//        //            public void onClick(View v) {
//        //
//        ////                scheduleNotification();
//        //            }
//        //        });
//
//    //--------------------set FIND VIEW BY ID-------------------
//        eventName = findViewById(R.id.eventname);
//        eventDetail = findViewById(R.id.eventDetail);
//        addUserEventButton = findViewById(R.id.addUserEventButton);
//        pDatabaseHelper = new DbPayHelper(this);
//        timePicker = findViewById(R.id.timePicker);
//
//        addNotiChkBox = findViewById(R.id.addNotiChkbox);
//        addNotiChkBox.setOnClickListener(this);
//                addNotiisChecked = addNotiChkBox.isChecked();
//
//
//        day = getIntent().getExtras().getString("day");
//
//
//        addUserEventButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final String name = eventName.getText().toString();
//                final String detail = eventDetail.getText().toString();
//        //     String time = selectTimeButton.getText().toString();
//                String time = String.format(Locale.getDefault(), "%02d:%02d",hour, minute);
//
//
//                if (eventName.length() != 0 && eventDetail.length() != 0) {
//                    eventName.setText("");
//                    eventDetail.setText("");
//                    if(addNotiisChecked){
//                        noti = true;
//                        toastMessage("ตั้งแจ้งเตือน:-D");
//                    }
//                    AddData(day,name,detail,noti,time);
//                }else {
//                    toastMessage("กรุณาใส่ข้อความที่ต้องการ!");
//                }
//
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
////    ----------------------------- Add data to db -----------------------
//    public void AddData(String day, String name, String detail, Boolean noti, String time) {
//        addNotiisChecked = addNotiChkBox.isChecked();
//        boolean insertData = pDatabaseHelper.addData(day,name,detail,addNotiisChecked,time);
//        eventID = GetID(day,name);
////        System.out.println(eventID);
//
//        if (insertData) {
//            toastMessage("เพิ่มกิจรรมเสร็จสิ้นจ้า :-D");
//            System.out.println(eventID);
//            addNoti(eventID,day,name);
//            System.out.println(eventID);
//        } else {
//            toastMessage("เพิ่มกิจรรมไม่สำเร็จ ;-;");
//        }
//    }
//
//    public void addNoti(String id, String date, String name){
//        if(GetNoti(eventID)){
//            onClick(addUserEventButton);
//            System.out.print("mong Rainbow");
//        }
//    }
//
//
//
//    public Boolean GetNoti(String id) {
//        Cursor data = pDatabaseHelper.getEventNoti(id);
//        data.moveToFirst();
//        Boolean notifi = false;
//        if( data!= null && data.moveToFirst() ) {
//            notifi = Boolean.parseBoolean(data.getString(0));
//        }
////        if (noti.equals("true")){
////            return true;
////        }
//        return notifi;
//    }
//
//    private void toastMessage(String message) {
//        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
//    }
//
////    get id
//    public String GetID(String date,String name) {
//        Cursor data = pDatabaseHelper.getEventID(date,name);
//        data.moveToFirst();
//        String id = data.getString(0);
//
//        return id;
//    }
////    get date เอามาทำพรื้อ
////    public String GetDate(String id) {
////        Cursor data = pDatabaseHelper.getDate(id);
////        data.moveToFirst();
////        String date = data.getString(0);
////
////        return date;
////    }
////    get time
////    public String GetTime(String id) {
////        Cursor data = pDatabaseHelper.getTime(id);
////        data.moveToFirst();
////        String time = data.getString(0);
////
////        return time;
////    }
//
//
//
//
//    //    ------------------------------set noti--------------------------
//    private  int notificationID = 1;
//    AlarmManager alarmManager;
//    PendingIntent alarmIntent;
//    Notifications eventnoti = new Notifications();
//
//
//    @Override
//
//    public void onClick(View v) {
//        eventName = findViewById(R.id.eventname);
//        timePicker = findViewById(R.id.timePicker);
//
//    //        Set noti & message
//        Intent intent = new Intent(getApplicationContext(), Notifications.class);
//        intent.putExtra("NotificationID", eventID);
//        intent.putExtra("Message", eventName.getText().toString());
//
//
//    //        PendingIntent
//        PendingIntent alarmIntent = PendingIntent.getBroadcast(
//                getApplicationContext(),0,intent,
//                PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);
//
//    //        AlarmManager
//       alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//
////        addNotiisChecked = addNotiChkBox.isChecked();
//
//
//        if (GetNoti(eventID)){
////            String[] ddmmyyy =GetDate(eventID).split("/");;
////            String[] time = GetTime(eventID).split(":");
////            int hr = Integer.parseInt(time[0]);
////            int min = Integer.parseInt(time[1]);
////            System.out.println(hr);
////            System.out.println(min);
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
////            System.out.println(GetNoti(eventID));
//
////            System.out.println(eventName.getText().toString());
//
//        }
//        else {
////            String[] ddmmyyy =GetDate(eventID).split("/");;
////            String[] time = GetTime(eventID).split(":");
////            int hr = Integer.parseInt(time[0]);
////            int min = Integer.parseInt(time[1]);
////            System.out.println(hr);
////            System.out.println(min);
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
////            System.out.println(GetNoti(eventID));
//
////            System.out.println(eventName.getText().toString());
////            noti = false;
////            alarmManager.cancel(alarmIntent);
////            Toast.makeText(this,"ยกเลิกตั้งแจ้งเตือน", Toast.LENGTH_SHORT).show();
//        }
//
//
//        //        switch (v.getId()){
//        //            case  R.id.addNotiChkbox :
//        //                int hr = timePicker.getCurrentHour();
//        //                int min = timePicker.getCurrentMinute();
//        //
//        ////                Create TIme
//        //                Calendar startTime = Calendar.getInstance();
//        //                startTime.set(Calendar.HOUR_OF_DAY, hr);
//        //                startTime.set(Calendar.MINUTE,min);
//        //                startTime.set(Calendar.SECOND, 0);
//        //                long alarmStartTime = startTime.getTimeInMillis();
//        //
//        ////               Set Alarm
//        //                alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);
//        //
//        //                Toast.makeText(this,"สำเร็จ", Toast.LENGTH_SHORT).show();
//        //                break;
//        //
//        //
//        //
//        //            case R.id.addUserEventButton:
//        ////                cancle Alarm เดะมาแก้ปุ่มน้า
//        //                alarmManager.cancel(alarmIntent);
//        //                Toast.makeText(this,"อิตาบ้า",Toast.LENGTH_SHORT).show();
//        //                break;
//        //
//        //        }
//    }






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


