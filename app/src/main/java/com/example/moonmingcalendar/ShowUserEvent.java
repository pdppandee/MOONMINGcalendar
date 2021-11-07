package com.example.moonmingcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowUserEvent extends AppCompatActivity {
    Button btnUlBack,btnUlEdit,btnUlDelete;
    TextView textEventName,textDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_user_event);
        textDate = findViewById(R.id.ueDate);
        String day = getIntent().getExtras().getString("day");
        textDate.setText(day);
        textEventName = findViewById(R.id.eventName);
        //textEventName.setText(eventName);
        btnUlBack = findViewById(R.id.ueBack);
        btnUlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToShowEventList = new Intent(ShowUserEvent.this, ShowEventList.class);
                startActivity(backToShowEventList);
            }
        });

        btnUlEdit = findViewById(R.id.ueEdit);
        btnUlEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editUserEvent = new Intent(ShowUserEvent.this, EditUserEvent.class);
                editUserEvent.putExtra("day", day);
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
}


