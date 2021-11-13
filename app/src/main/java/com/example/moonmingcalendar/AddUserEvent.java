package com.example.moonmingcalendar;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddUserEvent extends AppCompatActivity {
    EditText eventName, eventDetail;
    Button addUserEventButton;
    ListView userEventListView;
    DbPayHelper pDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user_event);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eventName = findViewById(R.id.eventname);
        eventDetail = findViewById(R.id.eventDetail);
        userEventListView = findViewById(R.id.userEventListView);
        addUserEventButton = findViewById(R.id.addUserEventButton);
        pDatabaseHelper = new DbPayHelper(this);

        String day = getIntent().getExtras().getString("day");

        addUserEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = eventName.getText().toString();
                final String detail = eventDetail.getText().toString();
                String noti = "";
                String time = "";
                if (eventName.length() != 0) {
                    AddData(day,name,detail,noti,time);
                    eventName.setText("");
                    eventDetail.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }
            }
        });
    }


    public void AddData(String day,String name,String detail,String noti,String time) {
        boolean insertData = pDatabaseHelper.addData(day,name,detail,noti,time);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
