package com.example.moonmingcalendar;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
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
    DbPayHelper pDatabaseHelper;
    ImageView image;

    private static final String TAG = "ShowEventList";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_event_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String day = getIntent().getExtras().getString("day");
        pDatabaseHelper = new DbPayHelper(this);
        getSupportActionBar().setTitle(day);
        //textDate = findViewById(R.id.date);
        textMTL = findViewById(R.id.textMTLdt);
        //textDate.setText(day);
        image = findViewById(R.id.imageMTL);
        int dayN = dayOfWeek(day);
        if (dayN==1){
            textMTL.setText("สีกาลกิณี : ฟ้า/น้ำเงิน");
            image.setImageResource(R.drawable.asun);
        }else if (dayN==2){
            textMTL.setText("สีกาลกิณี : แดง");
            image.setImageResource(R.drawable.amon);
        }else if (dayN==3){
            textMTL.setText("สีกาลกิณี : เหลือง/ขาว/เทา");
            image.setImageResource(R.drawable.atue);
        }else if (dayN==4){
            textMTL.setText("ีกาลกิณี : ชมพู");
            image.setImageResource(R.drawable.awed);
        }else if (dayN==5){
            textMTL.setText("สีกาลกิณี : ม่วง/ดำ");
            image.setImageResource(R.drawable.athu);
        }else if (dayN==6){
            textMTL.setText("สีกาลกิณี : ม่วงอ่อน");
            image.setImageResource(R.drawable.afri);
        }else if (dayN==7){
            textMTL.setText("สีกาลกิณี : เขียว");
            image.setImageResource(R.drawable.asat);
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
                intent2.putExtra("day",day);
                startActivity(intent2);
            }
        });
        GetMainEvent showEvent = new GetMainEvent(day);
        ArrayList<String> eventListName=showEvent.getEventListName();
        ArrayList<String> eventListDetail=showEvent.getEventListN();

        ArrayList<String> userEventName=GetName(day);
        ArrayList<String> userEventDetail=GetDetail(day);

        for (int n=0;n<userEventName.size();n++){
            eventListName.add(userEventName.get(n));
        }
        for (int d=0;d<userEventDetail.size();d++){
            eventListDetail.add(userEventDetail.get(d));
        }



        listView=(ListView) findViewById(R.id.list);
        MyAdapter adapter = new MyAdapter(this, eventListName, eventListDetail);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {

                String select=listView.getItemAtPosition(i).toString();
                String name = adapterView.getItemAtPosition(i).toString();

                if(userEventName.contains(eventListName.get(i))){
                    Intent intent1 = new Intent(ShowEventList.this, ShowUserEvent.class);
                    String userID = GetID(day,eventListName.get(i));
                    intent1.putExtra("day",day);
                    intent1.putExtra("userID",userID);
                    startActivity(intent1);
                }else {
                    Intent intent2 = new Intent(ShowEventList.this, ShowMainEvent.class);
                    intent2.putExtra("day",day);
                    intent2.putExtra("position",i);
                    startActivity(intent2);
                }

            }
        });

    }

    public int dayOfWeek(String dmyST) {
        String[] dmy = dmyST.split("/");
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(dmy[2]), Integer.parseInt(dmy[1])-1, Integer.parseInt(dmy[0]));
        return c.get(Calendar.DAY_OF_WEEK);
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        ArrayList<String> rName;
        ArrayList<String> rDetail;

        MyAdapter (Context c, ArrayList<String> name, ArrayList<String> detail) {
            super(c, R.layout.event_list, R.id.eventName, name);
            this.context = c;
            this.rName = name;
            this.rDetail = detail;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.event_list, parent, false);
            TextView name = row.findViewById(R.id.eventName);
            TextView detail = row.findViewById(R.id.eventDetail);


            name.setText(rName.get(position));
            detail.setText(rDetail.get(position));
            return row;
        }
    }

    public ArrayList GetName(String date) {
        Cursor data = pDatabaseHelper.getEventListName(date);
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(0));
        }
        return listData;
    }

    public ArrayList GetDetail(String date) {
        Cursor data = pDatabaseHelper.getEventListDetail(date);
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(0));
        }
        return listData;
    }

    public String GetID(String date,String name) {
        Cursor data = pDatabaseHelper.getEventID(date,name);
        data.moveToFirst();
        String id = data.getString(0);
        return id;
    }



}
