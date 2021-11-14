package com.example.moonmingcalendar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditUserEvent extends AppCompatActivity {
    Button btnSaveEditEvent,btnBackToShowUE;
    EditText textEventName, textEventDetail;
    TextView textEventDate;
    DbPayHelper pDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_user_event);

        textEventDate =  findViewById(R.id.editeventDate);
        String day = getIntent().getExtras().getString("day");
        String id = getIntent().getExtras().getString("userID");
        textEventDate.setText(day);
        textEventName = findViewById(R.id.eventname);
        pDatabaseHelper = new DbPayHelper(this);
        String[] data = GetData(id);
        textEventName.setText(data[0]);
        textEventDetail = findViewById(R.id.eventDetail);
        textEventDetail.setText(data[1]);

        btnSaveEditEvent = findViewById(R.id.editueSave);
        btnSaveEditEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent saveEditEvent = new Intent(EditUserEvent.this, ShowUserEvent.class);
                Toast.makeText(EditUserEvent.this, "แก้ไขเสร็จสิ้นจ้า :-D", Toast.LENGTH_SHORT).show();
                startActivity(saveEditEvent);
            }
        });

        btnBackToShowUE = findViewById(R.id.editueBack);
        btnBackToShowUE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToShowUserEvent = new Intent(EditUserEvent.this, ShowEventList.class);
                startActivity(backToShowUserEvent);
            }
        });


    }

    private String[] GetData(String id) {
        Cursor cursor = pDatabaseHelper.getData(id);
        cursor.moveToFirst();
        String[] data = {cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)};
        return data;
    }
}
