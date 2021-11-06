package com.example.moonmingcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowUserEvent extends AppCompatActivity {
    Button btnUlBack,btnUlEdit,btnUldelete;
    TextView textEventName,textDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_user_event);
        textDate = findViewById(R.id.ulDate);
        String day = getIntent().getExtras().getString("day");
        textDate.setText(day);

        textEventName = findViewById(R.id.eventName);
        //textEventName.setText(eventName);

        btnUlBack = findViewById(R.id.ulBack);
        btnUlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), ShowEventList.class);
                startActivity(intent1);
            }
        });

        btnUlEdit = findViewById(R.id.ulEdit);
        btnUlEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ShowUserEvent.this, EditUserEvent.class);
                intent2.putExtra("day", day);
                startActivity(intent2);
            }
        });

        btnUldelete = findViewById(R.id.ulDelete);
    }
}


