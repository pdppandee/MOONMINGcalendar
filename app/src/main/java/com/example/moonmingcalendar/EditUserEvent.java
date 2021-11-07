package com.example.moonmingcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditUserEvent extends AppCompatActivity {
    Button btnSaveEditEvent,btnBackToShowUE;
    TextView textEditEventName,textEditDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_user_event);
        textEditDate = findViewById(R.id.editueDate);
        String day = getIntent().getExtras().getString("day");
        textEditDate.setText(day);
        textEditEventName = findViewById(R.id.editNameEvent);

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
}
