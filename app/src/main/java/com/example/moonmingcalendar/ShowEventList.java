package com.example.moonmingcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ShowEventList extends AppCompatActivity{
    Button btnMutelu;
    FloatingActionButton fabAdd;
    TextView textDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_event_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textDate = findViewById(R.id.date);
        String day = getIntent().getExtras().getString("day");
        textDate.setText(day);
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




    }
}
