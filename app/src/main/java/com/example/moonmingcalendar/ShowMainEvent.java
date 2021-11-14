package com.example.moonmingcalendar;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowMainEvent extends AppCompatActivity {

    TextView textMainEventName, textMainEventDate, textMainEventDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_main_event);
        textMainEventName = findViewById(R.id.maineventname);
        textMainEventDetail = findViewById(R.id.maineventdetail);
        textMainEventDate = findViewById(R.id.date);

        String day = getIntent().getExtras().getString("day");
        int position = getIntent().getExtras().getInt("position");
        GetMainEvent showEvent = new GetMainEvent(day);

        String eventName = showEvent.getEventListName().get(position);
        String eventDetail = showEvent.getEventListDetail().get(position);

        textMainEventName.setText(eventName);
        textMainEventDetail.setText(eventDetail);
        //textMainEventDate.setText(day);
    }
}
