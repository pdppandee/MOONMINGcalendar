package com.example.moonmingcalendar;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
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
            textMTL.setText("สีกาลกิณี : ฟ้า/น้ำเงิน");
        }else if (dayN==2){
            textMTL.setText("สีกาลกิณี : แดง");
        }else if (dayN==3){
            textMTL.setText("สีกาลกิณี : เหลือง/ขาว/เทา");
        }else if (dayN==4){
            textMTL.setText("ีกาลกิณี : ชมพู");
        }else if (dayN==5){
            textMTL.setText("สีกาลกิณี : ม่วง/ดำ");
        }else if (dayN==6){
            textMTL.setText("สีกาลกิณี : ม่วงอ่อน");
        }else if (dayN==7){
            textMTL.setText("สีกาลกิณี : เขียว");
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
        ArrayList<String> eventListDetail=showEvent.getEventListDetail();

        listView=(ListView) findViewById(R.id.list);
        MyAdapter adapter = new MyAdapter(this, eventListName, eventListDetail);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String select=listView.getItemAtPosition(i).toString();
                String name = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(ShowEventList.this, eventListName.get(i), Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(ShowEventList.this,ShowMainEvent.class);
                intent.putExtra("day",day);
                startActivity(intent);*/
                Intent putdate1 = new Intent(ShowEventList.this, ShowUserEvent.class);
                putdate1.putExtra("day",day);
                startActivity(putdate1);
                Intent putdate2 = new Intent(ShowEventList.this, ShowMainEvent.class);
                putdate2.putExtra("day", day);
                startActivity(putdate2);
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

            /*Typeface childFont = Typeface.createFromAsset(getAssets(), "font/kanit.ttf");
            name.setTypeface(childFont);
            detail.setTypeface(childFont);*/


            //name.setTypeface(Typeface.createFromAsset(getAssets(), "kanit.ttf"));
            //detail.setTypeface(Typeface.createFromAsset(getAssets(), "kanit.ttf"));


            name.setText(rName.get(position));
            detail.setText(rDetail.get(position));
            return row;
        }


    }



}
