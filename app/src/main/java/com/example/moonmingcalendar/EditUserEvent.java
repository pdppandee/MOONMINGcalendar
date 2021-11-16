package com.example.moonmingcalendar;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class EditUserEvent extends AppCompatActivity {
    Button btnSaveEditEvent, btnBack, timeButton;
    EditText textEventName, textEventDetail;
    DbPayHelper pDatabaseHelper;
//    TimePicker editTimePicker;
//    DatePicker editDatePicker;
    private DatePickerDialog datePickerDialog;
    private Button dateBtn;
    int hour, minute;

    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_user_event);

        String date = getIntent().getExtras().getString("day");
        String id = getIntent().getExtras().getString("userID");
        textEventName = findViewById(R.id.eventname);
        pDatabaseHelper = new DbPayHelper(this);
        String[] data = GetData(id);
        textEventName.setText(data[0]);
        textEventDetail = findViewById(R.id.eventDetail);
        textEventDetail.setText(data[1]);
//        editDatePicker = findViewById(R.id.datePicker);
//        editTimePicker = findViewById(R.id.timePicker);

//        String[] datearr = data[3].split("/");
//        Integer initday = Integer.parseInt(datearr[0]);
//        Integer initmonth = Integer.parseInt(datearr[1]);
//        Integer inityear = Integer.parseInt(datearr[2]);

        timeButton = findViewById(R.id.eventTime);
        timeButton.setText(data[3]);

//        String[] timearr = data[4].split(":");
//        Integer inithour = Integer.parseInt(timearr[0]);
//        Integer initminute = Integer.parseInt(timearr[1]);

        initDatePicker();
        dateBtn = findViewById(R.id.editDate);
        dateBtn.setText(data[4]);

        btnSaveEditEvent = findViewById(R.id.editueSave);
        btnSaveEditEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = textEventName.getText().toString();
                String newDetail = textEventDetail.getText().toString();
                //
                String newDate = dateBtn.getText().toString();
                String newTime = timeButton.getText().toString();
//                String newTime = makeTimeString(hour, minute);
                pDatabaseHelper.updateName(newName,id,data[0]);
                pDatabaseHelper.updateDetail(newDetail,id,data[1]);
                pDatabaseHelper.updateTime(newTime,id,data[3]);
                pDatabaseHelper.updateDate(newDate,id,data[4]);
                toastMessage("แก้ไขเสร็จสิ้นจ้า :-D");
            }
        });


        btnBack = findViewById(R.id.editBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent saveEditEvent = new Intent(EditUserEvent.this, ShowUserEvent.class);
                saveEditEvent.putExtra("day",date);
                saveEditEvent.putExtra("userID",id);
                startActivity(saveEditEvent);
            }
        });

//        editDatePicker.init(inityear, initmonth, initday, null);
//        editDatePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker editDatePicker, int i, int i1, int i2) {
//
//            }
//        });
//        editTimePicker.setHour(inithour);
//        editTimePicker.setMinute(initminute);
//        editTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker editTimePicker, int selectedHour, int selectedMinute) {
//                hour = selectedHour;
//                minute = selectedMinute;
//            }
//        });
    }


    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                String date = makeDateString(day,month,year);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,day);

    }

    private String makeDateString(int day, int month, int year) {
        return day+"/"+month+"/"+year;
    }

    public  void openDatePicker(View view){
        datePickerDialog.show();
    }

    private String[] GetData(String id) {
        Cursor cursor = pDatabaseHelper.getData(id);
        cursor.moveToFirst();
        String[] data = {cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)};
        return data;
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
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
                timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
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
