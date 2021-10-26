package com.example.moonmingcalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CalendarView mCalendar;
    Button btnDetail;
    TextView textDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDate = findViewById(R.id.Date);
        mCalendar = findViewById(R.id.calendarView);
        mCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                final String day = dayOfMonth+"/"+(month+1)+"/"+year;
                textDate.setText(day);

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
}