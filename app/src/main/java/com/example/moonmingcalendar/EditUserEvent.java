package com.example.moonmingcalendar;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class EditUserEvent extends AppCompatActivity {
    Button btnSaveEditEvent, btnBack,timeButton;
    EditText textEventName, textEventDetail;
    DbPayHelper pDatabaseHelper;
    private DatePickerDialog datePickerDialog;
    private Button dateBtn;

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
        //timeButton = findViewById(R.id.TimeButton);
        //timeButton.setText(data[3]);
        
        initDatePicker();
        dateBtn = findViewById(R.id.editDate);
        dateBtn.setText(data[4]);

        btnSaveEditEvent = findViewById(R.id.editueSave);
        btnSaveEditEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = textEventName.getText().toString();
                String newDetail = textEventDetail.getText().toString();
                String newDate = dateBtn.getText().toString();
                pDatabaseHelper.updateName(newName,id,data[0]);
                pDatabaseHelper.updateDetail(newDetail,id,data[1]);
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

    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                String date = makeDateString(day,month,year);
                dateBtn.setText(date);
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




}
