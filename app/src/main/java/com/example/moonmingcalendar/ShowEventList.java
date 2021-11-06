package com.example.moonmingcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ShowEventList extends AppCompatActivity{
    Button btnBack,btnMutelu;
    FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_event_list);

        String day = getIntent().getExtras().getString("day");
        btnMutelu = findViewById(R.id.mutelu);
        btnMutelu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), ShowMuteluEvent.class);
                intent1.putExtra("day",day);
                startActivity(intent1);
            }
        });
        fabAdd = (FloatingActionButton ) findViewById(R.id.add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ShowEventList.this, AddUserEvent.class);
                startActivity(intent2);
            }
        });

        btnBack = findViewById(R.id.elBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent3);
            }
        });
    }
}
