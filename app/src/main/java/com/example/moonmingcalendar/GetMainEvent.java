package com.example.moonmingcalendar;

import java.util.ArrayList;

public class GetMainEvent {
    ArrayList<MainEvent> arrayList = new ArrayList<>();
    String[] dmy;

    public GetMainEvent(String day){
//        eng
        arrayList.add(new MainEvent("วันปีใหม่", "วันขึ้นปีใหม่สากล", "NO", "1", "1"));
//        thai
//              4
        arrayList.add(new MainEvent("วันจักรี", "วันจักรี", "NO", "6", "4"));
        arrayList.add(new MainEvent("วันสงกรานต์", "วันขึ้นปีใหม่ไทย", "NO", "13", "4"));
        arrayList.add(new MainEvent("วันสงกรานต์", "วันขึ้นปีใหม่ไทย", "NO", "14", "4"));
        arrayList.add(new MainEvent("วันสงกรานต์", "วันขึ้นปีใหม่ไทย", "NO", "15", "4"));
//              5
        arrayList.add(new MainEvent("วันฉัตรมงคล", "วันฉัตรมงคล", "NO", "4", "5"));
        arrayList.add(new MainEvent("วันพืชมงคล", "วันพืชมงคล", "NO", "10", "5"));
//              6
        arrayList.add(new MainEvent("วันเฉลิมฯ พระราชินี", "วันเฉลิมพระชนมพรรษาพระราชินี", "NO", "3", "6"));
//              7
        arrayList.add(new MainEvent("วันเฉลิมฯ ร.10", "วันเฉลิมพระชนมพรรษา ร.10", "NO", "28", "7"));
//              8
        arrayList.add(new MainEvent("วันแม่", "วันแม่", "NO", "12", "8"));
//              9
        arrayList.add(new MainEvent("วันมหิดล", "วันมหิดล", "NO", "24", "9"));
//              10
        arrayList.add(new MainEvent("วันคล้ายวันสวรรคต ร.9", "วันคล้ายวันสวรรคต ร.9", "NO", "13", "10"));
//              12
        arrayList.add(new MainEvent("วันคล้ายวันเฉลิมฯ ร.9", "วันคล้ายวันเฉลิมฯ ร.9", "NO", "5", "12"));
        arrayList.add(new MainEvent("วันรัฐธรรมนูญ", "วันรัฐธรรมนูญ", "NO", "10", "12"));
        arrayList.add(new MainEvent("วันพ่อ", "วันพ่อ", "NO", "5", "12"));
        arrayList.add(new MainEvent("วันสิ้นปี", "วันสิ้นปี", "NO", "31", "12"));

        dmy = day.split("/");
    }
    public String getMainActivity(){
        String eventLst = "";
        for (int i=0;i<arrayList.size();i++){
            if (dmy[0].equals(arrayList.get(i).getDay()) && dmy[1].equals(arrayList.get(i).getMonth())){
                eventLst += arrayList.get(i).getName()+"\n";
            }
        }
        return eventLst;
    }

    public ArrayList<String> getEventListName(){
        ArrayList<String> eventLst = new ArrayList<>();
        for (int i=0;i<arrayList.size();i++){
            if (dmy[0].equals(arrayList.get(i).getDay()) && dmy[1].equals(arrayList.get(i).getMonth())){
                eventLst.add(arrayList.get(i).getName());
            }
        }
        return eventLst;
    }

    public ArrayList<String> getEventListDetail(){
        ArrayList<String> eventLst = new ArrayList<>();
        for (int i=0;i<arrayList.size();i++){
            if (dmy[0].equals(arrayList.get(i).getDay()) && dmy[1].equals(arrayList.get(i).getMonth())){
                eventLst.add(arrayList.get(i).getDetail());
            }
        }
        return eventLst;
    }

}
