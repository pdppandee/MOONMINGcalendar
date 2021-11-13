package com.example.moonmingcalendar;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowMainEvent extends AppCompatActivity {

    TextView textMainEventName, textMainEventDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_user_event);
        textMainEventName = findViewById(R.id.maineventname);
        textMainEventDate = findViewById(R.id.date);
        String day = getIntent().getExtras().getString("day");
        textMainEventDate.setText(day);
    }
}
