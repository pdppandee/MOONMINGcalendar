package com.example.moonmingcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UserEvent extends AppCompatActivity {
    EditText eventName, eventDetail;

    DBmoonming databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user_event);

            eventName = findViewById(R.id.eventName);
            eventDetail = findViewById(R.id.eventDetail);
    }

}
