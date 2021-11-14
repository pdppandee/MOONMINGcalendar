package com.example.moonmingcalendar;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowUserEvent extends AppCompatActivity {
    Button btnUlBack,btnUlEdit,btnUlDelete;
    TextView textEventName,textDate, textEventDetail, textTime;
    DbPayHelper pDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_user_event);
        textDate = findViewById(R.id.editeventDate);
        String day = getIntent().getExtras().getString("day");
        String id = getIntent().getExtras().getString("userID");
        textDate.setText(day);
        textEventName = findViewById(R.id.eventName);
        pDatabaseHelper = new DbPayHelper(this);
        String[] data = GetData(id);
        textEventName.setText(data[0]);
        textEventDetail = findViewById(R.id.eventDetail);
        textEventDetail.setText(data[1]);
        textTime = findViewById(R.id.eventTime);
        textTime.setText(data[3]);

        btnUlBack = findViewById(R.id.ueBack);
        btnUlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showeventlist = new Intent(ShowUserEvent.this, ShowEventList.class);
                showeventlist.putExtra("day",day);
                startActivity(showeventlist);
            }
        });

        btnUlEdit = findViewById(R.id.ueEdit);
        btnUlEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editUserEvent = new Intent(ShowUserEvent.this, EditUserEvent.class);
                editUserEvent.putExtra("day",day);
                editUserEvent.putExtra("userID",id);
                startActivity(editUserEvent);
            }
        });

        btnUlDelete = findViewById(R.id.ueDelete);
        /**btnUlDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(ShowUserEvent.this, ShowEventList.class);
                startActivity(intent3);
            }
        });**/
    }

    public String[] GetData(String id) {
        Cursor cursor = pDatabaseHelper.getData(id);
        cursor.moveToFirst();
        String[] data = {cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)};
        return data;
    }
}


