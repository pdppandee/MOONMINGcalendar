package com.example.moonmingcalendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ShowMainEvent extends AppCompatActivity {

    TextView textMainEventName, textMainEventDate, textMainEventDetail;
    String lunarPhase, day;
    CheckBox addNotiChkBox;
    Boolean ischecked, noti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_main_event);
        textMainEventName = findViewById(R.id.maineventname);
        textMainEventDetail = findViewById(R.id.maineventdetail);
        textMainEventDate = findViewById(R.id.maineventdete);

        day = getIntent().getExtras().getString("day");
        int position = getIntent().getExtras().getInt("position");
        GetMainEvent showEvent = new GetMainEvent(day);

        String eventName = showEvent.getEventListName().get(position);
        String eventDetail = showEvent.getEventListDetail().get(position);

        textMainEventName.setText(eventName);
        textMainEventDetail.setText(eventDetail);
        textMainEventDate.setText(day);

        addNotiChkBox = findViewById(R.id.addNotiChkbox);
        System.out.println(ischecked);


        addNotiChkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ischecked = addNotiChkBox.isChecked();
               setCheckbox(ischecked);
            }
        });
    }

    private void setCheckbox(boolean ischecked){
        if (ischecked) {
            noti = true;
            System.out.println(ischecked);
            setUserNotification(day);
            Toast.makeText(getApplicationContext(), "ตั้งค่าแจ้งเตือน:-D", Toast.LENGTH_SHORT).show();


        }else {
            System.out.println(ischecked);
            Toast.makeText(getApplicationContext(), "ยกเลิกแจ้งเตือน:-D", Toast.LENGTH_SHORT).show();
        }
    }

    public void setUserNotification(String day) {
        //        Set noti & message

            String[] date = day.split("/");
            Intent intent = new Intent(getApplicationContext(), Notifications.class);
            intent.putExtra("NotificationID", date[0]);
            intent.putExtra("Message", textMainEventName.getText().toString());
            // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            AlarmManager alarmManager;


            PendingIntent alarmIntent = PendingIntent.getBroadcast(
                    getApplicationContext(), 1, intent,
                    PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            if (noti) {
//                int hr = timePicker.getCurrentHour();
//                int min = timePicker.getCurrentMinute();

                //        Create TIme
                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 20);
                startTime.set(Calendar.MINUTE, 49);
                startTime.set(Calendar.SECOND, 0);
//                startTime.set(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
                System.out.println(startTime);
                long alarmStartTime = startTime.getTimeInMillis();
                System.out.println(alarmStartTime + " alarmStartTime");
                //       Set Alarm
                alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);
                System.out.println("hihi");
            }
        }
    }

//    public void lunarPhaseCal(){
//        ArrayList<ArrayList<Integer>> pakKhaNaTable = new ArrayList<>();
//
//        String sumpayuha = "1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2";
//        String payuha1 = "2,2,2,2,2,2,2,2,2,2,1";
//        String payaha2 = "2,2,2,2,2,2,2,2,2,1";
//        String samuha1 = "1,1,1,1,1,1,2";
//        String samuha2 = "1,1,1,1,1,2";
//        String vak1 = "2,2,2,1";
//        String vak2 = "2,2,1";
//        String pak1 = "1,1,1,1,2";
//        String pak2 = "1,1,1,2";
//        String[] arr1 = sumpayuha.split(",");
//        String[] arr2 = payuha1.split(",");
//        String[] arr3 = payaha2.split(",");
//        String[] arr4 = samuha1.split(",");
//        String[] arr5 = samuha2.split(",");
//        String[] arr6 = vak1.split(",");
//        String[] arr7 = vak2.split(",");
//        String[] arr8 = pak1.split(",");
//        String[] arr9 = pak2.split(",");
//        ArrayList<Integer> sumpa = new ArrayList<Integer>();
//        ArrayList<Integer> pa1 = new ArrayList<Integer>();
//        ArrayList<Integer> pa2 = new ArrayList<Integer>();
//        ArrayList<Integer> samu1 = new ArrayList<Integer>();
//        ArrayList<Integer> samu2 = new ArrayList<Integer>();
//        ArrayList<Integer> vak_1 = new ArrayList<Integer>();
//        ArrayList<Integer> vak_2 = new ArrayList<Integer>();
//        ArrayList<Integer> pak_1 = new ArrayList<Integer>();
//        ArrayList<Integer> pak_2 = new ArrayList<Integer>();
//
//        // 1=มหา 2=จุล
//        //สัมพยุหะ
//        for(String a:arr1){
//            sumpa.add(Integer.parseInt(a));
//        }
//        //พยุหะ : มหาสัมพยุหะ
//        for(String a:arr2){
//            pa1.add(Integer.parseInt(a));
//        }
//        //พยุหะ : จุลสัมพยุหะ
//        for(String a:arr3){
//            pa2.add(Integer.parseInt(a));
//        }
//        //สมุหะ : มหาพยุหะ
//        for(String a:arr4){
//            samu1.add(Integer.parseInt(a));
//        }
//        //สมุหะ : จุลพยุหะ
//        for(String a:arr5){
//            samu2.add(Integer.parseInt(a));
//        }
//        //วรรค : มหาสมุหะ
//        for(String a:arr6){
//            vak_1.add(Integer.parseInt(a));
//        }
//        //วรรค : จุลสมุหะ
//        for(String a:arr7){
//            vak_2.add(Integer.parseInt(a));
//        }
//        //ปักข์ : มหาวรรค
//        for(String a:arr8){
//            pak_1.add(Integer.parseInt(a));
//        }
//        //ปักข์ : จุลวรรค
//        for(String a:arr9){
//            pak_2.add(Integer.parseInt(a));
//        }
//        //ตารางปักขคณนา
//        pakKhaNaTable.add(sumpa);
//        pakKhaNaTable.add(pa1);
//        pakKhaNaTable.add(pa2);
//        pakKhaNaTable.add(samu1);
//        pakKhaNaTable.add(samu2);
//        pakKhaNaTable.add(vak_1);
//        pakKhaNaTable.add(vak_2);
//        pakKhaNaTable.add(pak_1);
//        pakKhaNaTable.add(pak_2);
//
//        int day = 0;
//        int month = 0;
//        int year = 0;
//        double a=0,b=0,c=0,d=0,e=0;
//        double R1=0,R2=0,R3=0,R4=0,R5=0;
//        double A = 0, B = 0, JD = 0, pakDay = 0;
//
//        //1. Julian Day
//        if(month <= 2){
//            year = year-1;
//            month = month + 12;
//        }
//        A = floor(year/100);
//        B = 2 - A + floor(A/4);
//        JD = floor (365.25* (year + 4716)) + floor (30.6001* (month+1)) + day + B - 1524.5;
//        //2. วันปักข์
//        pakDay = JD - 2355147;
//        //3. ตำแหน่งสัมพยุหะ
//        a = pakDay/16168;
//        R1 = pakDay%16168;
//        //4. ตำแหน่งพยุหะ
//        b = R1/1447;
//        R2 = R1%1447;
//        //5. ตำแหน่งสมุหะ
//        c = R2/251;
//        R3 = R2%251;
//        //6. ตำแหน่งวรรค
//        d = R3/59;
//        R4 = R3%59;
//        //7. ตำแหน่งปักษ์
//        e = R4/15;
//        R5 = R4%15;
//        //8. ตำแหน่งวัน




//    }


