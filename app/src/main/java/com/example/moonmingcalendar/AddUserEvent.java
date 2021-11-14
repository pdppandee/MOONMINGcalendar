package com.example.moonmingcalendar;



import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class AddUserEvent extends AppCompatActivity {
    EditText eventName, eventDetail;
    Button addUserEventButton, selectTimeButton, btnBack;
    DbPayHelper pDatabaseHelper;
    int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user_event);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eventName = findViewById(R.id.eventname);
        eventDetail = findViewById(R.id.eventDetail);
        addUserEventButton = findViewById(R.id.addUserEventButton);
        selectTimeButton = findViewById(R.id.selectTimeButton);
        pDatabaseHelper = new DbPayHelper(this);

        String day = getIntent().getExtras().getString("day");

        addUserEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = eventName.getText().toString();
                final String detail = eventDetail.getText().toString();
                String time = selectTimeButton.getText().toString();
                String noti = "";

                if (eventName.length() != 0 && eventDetail.length() != 0 && !time.equals("เลือกเวลา")) {
                    AddData(day,name,detail,noti,time);
                    eventName.setText("");
                    eventDetail.setText("");
                    selectTimeButton.setText("เลือกเวลา");
                }else if(eventName.length() != 0 && eventDetail.length() != 0 && time.equals("เลือกเวลา")){
                    toastMessage("กรุณาระบุเวลาด้วยจ้า!");
                }

                else {
                    toastMessage("กรุณาใส่ข้อความที่ต้องการ!");
                }
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


    public void AddData(String day,String name,String detail,String noti,String time) {
        boolean insertData = pDatabaseHelper.addData(day,name,detail,noti,time);

        if (insertData) {
            toastMessage("เพิ่มกิจรรมเสร็จสิ้นจ้า :-D");
        } else {
            toastMessage("เพิ่มกิจรรมไม่สำเร็จ ;-;");
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void popTimePicker(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                hour = selectedHour;
                minute = selectedMinute;
                String time = makeTimeString(hour, minute);
                selectTimeButton.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);
        timePickerDialog.setTitle("เลือกเวลา");
        timePickerDialog.show();
    }

    private String makeTimeString(int hour, int minute){
        return hour + " : " + minute;
    }

}
