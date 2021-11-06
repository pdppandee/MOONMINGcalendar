package com.example.moonmingcalendar;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddUserEvent extends AppCompatActivity {
    EditText eventName, eventDetail;

    DBmoonming databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user_event);

            eventName = findViewById(R.id.eventname);
            eventDetail = findViewById(R.id.eventDetail);
    }

}
