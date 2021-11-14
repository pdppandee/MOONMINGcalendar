package com.example.moonmingcalendar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowUserEvent extends AppCompatActivity {
    Button btnUlBack,btnUlEdit,btnUlDelete;
    TextView textEventName,textDate;
    DbPayHelper pDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_user_event);
        textDate = findViewById(R.id.eventDate);
        String day = getIntent().getExtras().getString("day");
        String id = getIntent().getExtras().getString("userID");
        textDate.setText(day);
        textEventName = findViewById(R.id.eventName);
        pDatabaseHelper = new DbPayHelper(this);
        String[] data = GetData(id);
        textEventName.setText(data[0]);


        btnUlBack = findViewById(R.id.ueBack);
        btnUlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToShowEventList = new Intent(ShowUserEvent.this, ShowEventList.class);
                backToShowEventList.putExtra("day",day);
                startActivity(backToShowEventList);
            }
        });

        btnUlEdit = findViewById(R.id.ueEdit);
        btnUlEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editUserEvent = new Intent(ShowUserEvent.this, EditUserEvent.class);
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


