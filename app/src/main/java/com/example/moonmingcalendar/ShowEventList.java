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

        listView=(ListView) findViewById(R.id.eventlist);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,eventName);
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
        /*listView=(ListView) findViewById(R.id.eventlist);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(ShowEventList.this,eventName,eventDetail);
        listView.setAdapter(customBaseAdapter);*/

    }

    public int dayOfWeek(String dmyST) {
        String[] dmy = dmyST.split("/");
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(dmy[2]), Integer.parseInt(dmy[1])-1, Integer.parseInt(dmy[0]));
        return c.get(Calendar.DAY_OF_WEEK);
    }
    /*public class CustomBaseAdapter extends BaseAdapter{

        Context context;
        String[] rName;
        String[] rDetail;
        LayoutInflater inflater;

        public CustomBaseAdapter(Context ctx,String[] Name,String[] Detail){
            this.context=ctx;
            this.rName=Name;
            this.rDetail=Detail;


        }

        @Override
        public int getCount() {
            return rName.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(inflater==null){
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            if (convertView==null){
                convertView=inflater.inflate(R.layout.eventlist,null);
            }
            //convertView=LayoutInflater.from(context).inflate(R.layout.eventlist,parent,false);
            TextView name= convertView.findViewById(R.id.eventName);
            TextView detail= convertView.findViewById(R.id.eventDetail);
            name.setText(rName[position]);
            detail.setText(rDetail[position]);

            return convertView;
        }
    }*/


}
