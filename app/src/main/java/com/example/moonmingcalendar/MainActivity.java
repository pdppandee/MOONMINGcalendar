package com.example.moonmingcalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CalendarView mCalendar;
    Button btnDetail;
    TextView textDate;
    ListView miniEventList;
    DbPayHelper pDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDate = findViewById(R.id.Date);
        mCalendar = findViewById(R.id.calendarView);
        miniEventList = findViewById(R.id.eventList);
        pDatabaseHelper = new DbPayHelper(this);

        mCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                final String day = dayOfMonth+"/"+(month+1)+"/"+year;
                ArrayList<String> userEvent=GetName(day);
                textDate.setText(day);
                GetMainEvent ShowEvent = new GetMainEvent(day);
                ArrayList<String> eventListName=ShowEvent.getEventListName();
                for(int i=0;i<userEvent.size();i++){
                    eventListName.add(userEvent.get(i));
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, eventListName);
                miniEventList.setAdapter(arrayAdapter);

                btnDetail = findViewById(R.id.btnDetail);
                btnDetail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, ShowEventList.class);
                        intent.putExtra("day",day);
                        startActivity(intent);
                    }
                });
            }
        });

    }
    public ArrayList GetName(String date) {
        Cursor data = pDatabaseHelper.getEventListName(date);
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(0));
        }
        return listData;
    }
}