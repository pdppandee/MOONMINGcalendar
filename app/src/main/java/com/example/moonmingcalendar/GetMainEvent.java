package com.example.moonmingcalendar;

import java.util.ArrayList;

public class GetMainEvent {
    ArrayList<MainEvent> arrayList = new ArrayList<>();
    String[] dmy;

    public GetMainEvent(String day){
        arrayList.add(new MainEvent("วันปีใหม่", "วันขึ้นปีใหม่สากล", "NO", "1", "1"));
        arrayList.add(new MainEvent("วันสงกรานต์", "วันขึ้นปีใหม่ไทย", "NO", "13", "4"));
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

    public ArrayList<String> getEventList(){
        ArrayList<String> eventLst = new ArrayList<>();
        for (int i=0;i<arrayList.size();i++){
            if (dmy[0].equals(arrayList.get(i).getDay()) && dmy[1].equals(arrayList.get(i).getMonth())){
                eventLst.add(arrayList.get(i).getName());
            }
        }
        return eventLst;
    }
}
