package com.example.moonmingcalendar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;


public class ShowMuteluEvent extends AppCompatActivity {
    Button btnBack;
    TextView textWork,textLove,textMoney,textMercy,textBad,textDate,
            zodiacGood, zodiacBad; //---------------------------v------------------มป พาร์ทวันชง---------------------------v------------------
    String[] zodiacYear = {"ชวด", "ฉลู", "ขาล", "เถาะ", "มะโรง", "มะเส็ง", "มะเมีย", "มะแม", "วอก", "ระกา", "จอ", "กุน"};
    //---------------------------^------------------มป พาร์ทวันชง----------------------^-----------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_mutelu_event);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textWork = findViewById(R.id.work);
        textLove = findViewById(R.id.love);
        textMoney = findViewById(R.id.money);
        textMercy = findViewById(R.id.mercy);
        textBad = findViewById(R.id.bad);
        textDate = findViewById(R.id.date);
        zodiacGood = findViewById(R.id.zodiacGoodTv);
        zodiacBad = findViewById(R.id.zodiacBadTv);
        String day = getIntent().getExtras().getString("day");
        textDate.setText(day);
        int dayN = dayOfWeek(day);
        if (dayN==1){
            textWork.setText("ม่วง/ดำ");
            textLove.setText("ชมพู");
            textMoney.setText("เขียว");
            textMercy.setText("ม่วงอ่อน");
            textBad.setText("ฟ้า/น้ำเงิน");
        }else if (dayN==2){
            textWork.setText("ส้ม/น้ำตาล");
            textLove.setText("เขียว");
            textMoney.setText("ม่วง/ดำ");
            textMercy.setText("ฟ้า/น้ำเงิน");
            textBad.setText("แดง");
        }else if (dayN==3){
            textWork.setText("ม่วงอ่อน");
            textLove.setText("ม่วง/ดำ");
            textMoney.setText("ส้ม/น้ำตาล");
            textMercy.setText("แดง");
            textBad.setText("เหลือง/ขาว/เทา");
        }else if (dayN==4){
            textWork.setText("ฟ้า/น้ำเงิน");
            textLove.setText("ส้ม/น้ำตาล");
            textMoney.setText("ม่วงอ่อน");
            textMercy.setText("เหลือง/ขาว/เทา");
            textBad.setText("ชมพู");
        }else if (dayN==5){
            textWork.setText("เหลือง/ขาว/เทา");
            textLove.setText("ฟ้า/น้ำเงิน");
            textMoney.setText("แดง");
            textMercy.setText("เขียว");
            textBad.setText("ม่วง/ดำ");
        }else if (dayN==6){
            textWork.setText("เขียว");
            textLove.setText("เหลือง/ขาว/เทา");
            textMoney.setText("ชมพู");
            textMercy.setText("ส้ม/น้ำตาล");
            textBad.setText("ม่วงอ่อน");
        }else if (dayN==7){
            textWork.setText("แดง");
            textLove.setText("ม่วงอ่อน");
            textMoney.setText("ฟ้า/น้ำเงิน");
            textMercy.setText("ชมพู");
            textBad.setText("เขียว");
        }
//-------------------------v-------------------มป พาร์ทวันชง----------------------v-----------------------
        int dayChong = dayOfYear(day);
        int currentYear = getYear(day);
        int modNum = modWanchong(dayChong);
        if (currentYear == 2020) { // มี 365 วัน
            modNum = (modNum + 11) % 12;
            zodiacGood.setText(zodiacYear[modNum]);
            modNum = (modNum + 6) % 12;
            zodiacBad.setText(zodiacYear[modNum]);
        }
        if (currentYear == 2021){ // มี 366 วัน
            modNum = (modNum + 8) % 12;
            zodiacGood.setText(zodiacYear[modNum]);
            modNum = (modNum + 6) % 12;
            zodiacBad.setText(zodiacYear[modNum]);
        }
        else if (currentYear == 2022){ // มี 365 วัน
            modNum = (modNum + 1) % 12;
            zodiacGood.setText(zodiacYear[modNum]);
            modNum = (modNum + 6) % 12;
            zodiacBad.setText(zodiacYear[modNum]);
        }
    }
//---------------------------^------------------มป พาร์ทวันชง----------------^-----------------------------

    public int dayOfWeek(String dmyST) {
        String[] dmy = dmyST.split("/");
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(dmy[2]), Integer.parseInt(dmy[1])-1, Integer.parseInt(dmy[0]));
        return c.get(Calendar.DAY_OF_WEEK);
    }

//---------------------------v------------------มป พาร์ทวันชง----------------------v-----------------------
    public int dayOfYear(String dmyST){
        String[] dmy = dmyST.split("/");
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(dmy[2]), Integer.parseInt(dmy[1])-1, Integer.parseInt(dmy[0]));
        return c.get(Calendar.DAY_OF_YEAR);
    }

    public int getYear(String dmyST){
        String[] dmy = dmyST.split("/");
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(dmy[2]), Integer.parseInt(dmy[1])-1, Integer.parseInt(dmy[0]));
        return c.get(Calendar.YEAR); //dmy[2]
    }

    public int modWanchong(Integer doy){
        return doy % 12;
    }
//--------------------------^-------------------มป พาร์ทวันชง------------------------^---------------------
}

