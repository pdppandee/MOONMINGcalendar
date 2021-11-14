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
    Button btnSaveEditEvent;
    EditText textEventName, textEventDetail, textEventDate;
    DbPayHelper pDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_user_event);

        textEventDate =  findViewById(R.id.editeventDate);
        String date = getIntent().getExtras().getString("day");
        String id = getIntent().getExtras().getString("userID");
        textEventDate.setText(date);
        textEventName = findViewById(R.id.eventname);
        pDatabaseHelper = new DbPayHelper(this);
        String[] data = GetData(id);
        //textEventName.setText(data[0]);
        textEventDetail = findViewById(R.id.eventDetail);
        //textEventDetail.setText(data[1]);

        btnSaveEditEvent = findViewById(R.id.editueSave);
        btnSaveEditEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newDate = textEventDate.getText().toString();
                if(!newDate.equals(data[0])){
                    pDatabaseHelper.updateDate(newDate,id,date);
                    toastMessage("Data Successfully Edit!");
                }else{
                    toastMessage("You must enter a data");
                }


                //Intent saveEditEvent = new Intent(EditUserEvent.this, ShowUserEvent.class);
                //toastMessage("แก้ไขเสร็จสิ้นจ้า :-D");
                //startActivity(saveEditEvent);
            }
        });

    }

    private String[] GetData(String id) {
        Cursor cursor = pDatabaseHelper.getData(id);
        cursor.moveToFirst();
        String[] data = {cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)};
        return data;
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }


}
