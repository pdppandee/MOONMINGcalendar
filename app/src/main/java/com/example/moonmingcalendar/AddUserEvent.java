package com.example.moonmingcalendar;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddUserEvent extends AppCompatActivity {
    EditText eventName, eventDetail;
    Button addUserEventButton;
    ListView userEventListView;
    DBmoonming databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user_event);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eventName = findViewById(R.id.eventname);
        eventDetail = findViewById(R.id.eventDetail);
        userEventListView = findViewById(R.id.userEventListView);
        addUserEventButton = findViewById(R.id.addUserEventButton);

        addUserEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEvent event1;
                try {
                    event1 = new UserEvent(eventName.getText().toString(), eventDetail.getText().toString());
                    Toast.makeText(getApplicationContext(), event1.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    event1 = new UserEvent("error", "error");
                }
//                    UserEvent event1 = new UserEvent(eventName.getText().toString(), eventDetail.getText().toString());


                databaseHelper = new DBmoonming(getApplicationContext());

                boolean success = databaseHelper.addUserEvent(event1);

                Toast.makeText(getApplicationContext(), "Success " + success, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
