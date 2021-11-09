package com.example.moonmingcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class ShowEventList extends AppCompatActivity{
    FloatingActionButton fabAdd;
    TextView textDate, textMTL;
    LinearLayout mutelu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_event_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String day = getIntent().getExtras().getString("day");
        getSupportActionBar().setTitle(day);
        //textDate = findViewById(R.id.date);
        textMTL = findViewById(R.id.textMTLdt);
        //textDate.setText(day);
        int dayN = dayOfWeek(day);
        if (dayN==1){
            textMTL.setText("    สีกาลกิณี : ฟ้า/น้ำเงิน");
        }else if (dayN==2){
            textMTL.setText("    สีกาลกิณี : แดง");
        }else if (dayN==3){
            textMTL.setText("    สีกาลกิณี : เหลือง/ขาว/เทา");
        }else if (dayN==4){
            textMTL.setText("    สีกาลกิณี : ชมพู");
        }else if (dayN==5){
            textMTL.setText("    สีกาลกิณี : ม่วง/ดำ");
        }else if (dayN==6){
            textMTL.setText("    สีกาลกิณี : ม่วงอ่อน");
        }else if (dayN==7){
            textMTL.setText("    สีกาลกิณี : ขียว");
        }
        mutelu = findViewById(R.id.MTL);
        mutelu.setOnClickListener(new View.OnClickListener() {
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

    public int dayOfWeek(String dmyST) {
        String[] dmy = dmyST.split("/");
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(dmy[2]), Integer.parseInt(dmy[1])-1, Integer.parseInt(dmy[0]));
        return c.get(Calendar.DAY_OF_WEEK);
    }
}
