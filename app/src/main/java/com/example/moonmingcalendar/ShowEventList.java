package com.example.moonmingcalendar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class ShowEventList extends AppCompatActivity{
    FloatingActionButton fabAdd;
    TextView textDate, textMTL;
    LinearLayout mutelu;
    ListView listView;

    String[] eventName = {"วันสิ้นปี","วันขึ้นปีใหม่","วันสงกรานต์"};
    String[] eventDetail = {"31/12","01/01","13/04"};



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
            textMTL.setText("    สีกาลกิณี : เขียว");
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
        GetMainEvent showEvent = new GetMainEvent(day);
        ArrayList<String> eventLst=showEvent.getEventList();

        listView=(ListView) findViewById(R.id.list);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,eventLst);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String select=listView.getItemAtPosition(i).toString();
                Intent intent = new Intent(ShowEventList.this,ShowUserEvent.class);
                intent.putExtra("select",select);
                startActivity(intent);
                //dd.setText(getIntent().getStringExtra("select"));
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
