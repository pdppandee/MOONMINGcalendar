package com.example.moonmingcalendar;

import java.util.ArrayList;

public class MoonPhases {
    int Day, Month, Year;

    public MoonPhases(String date){
        String[] dmy = date.split("/");
        this.Day=Integer.parseInt(dmy[0]);
        this.Month=Integer.parseInt(dmy[1]);
        this.Year=Integer.parseInt(dmy[2]);
    }

    public double phases(){
        if(Month<=2){
            Month+=12;
            Year-=1;
        }
        double A = Math.floor(Year/100);
        double B = 2 - A + Math.floor(A/4);
        double jd = Math.floor(365.25*(Year+4716)) + Math.floor(30.6001 * (Month +1)) + Day + B - 1524.5;
        double ans = (((jd-2454000.98958)/29.530588*4000)%4000)/1000;
        if (ans>3.75){
            ans-=3.75;
        }
        return ans;
    }

    public boolean BuddhistHolyDay(){
        double ans = phases();
        if ((ans<0.25) || (ans>=0.75 && ans<1.25) || (ans>=1.75 && ans<2.25) || (ans>=2.75 && ans<3.25)){
            return true;
        }else{
            return false;
        }
    }

    public boolean BuddhistHolidays(){
        double ans = phases();
        if ((ans<0.25) || (ans>=0.75 && ans<1.25) || (ans>=1.75 && ans<2.25) || (ans>=2.75 && ans<3.25)){
            return true;
        }else{
            return false;
        }
    }



}

//    public ArrayList<String> getEventListName(){
//        ArrayList<String> eventLst = new ArrayList<>();
//        for (int i=0;i<arrayList.size();i++){
//            if (dmy[0].equals(arrayList.get(i).getDay()) && dmy[1].equals(arrayList.get(i).getMonth())){
//                eventLst.add(arrayList.get(i).getName());
//            }
//        }
//        for (int j=0;j<ChineseList.size();j++){
//            if (dmy[0].equals(ChineseList.get(j).getDay()) && dmy[1].equals(ChineseList.get(j).getMonth()) && dmy[2].equals(ChineseList.get(j).getYear())){
//                eventLst.add(ChineseList.get(j).getName());
//            }
//        }
//        if (BuddhistHolyDay(dmy)){
//            eventLst.add("วันพระ");
//        }
//        return eventLst;
//    }
//
//    public ArrayList<String> getEventListDetail(){
//        ArrayList<String> eventLst = new ArrayList<>();
//        for (int i=0;i<arrayList.size();i++){
//            if (dmy[0].equals(arrayList.get(i).getDay()) && dmy[1].equals(arrayList.get(i).getMonth())){
//                eventLst.add(arrayList.get(i).getDetail());
//            }
//        }
//        for (int j=0;j<ChineseList.size();j++){
//            if (dmy[0].equals(ChineseList.get(j).getDay()) && dmy[1].equals(ChineseList.get(j).getMonth()) && dmy[2].equals(ChineseList.get(j).getYear())){
//                eventLst.add(ChineseList.get(j).getDetail());
//            }
//        }
//        if (BuddhistHolyDay(dmy)){
//            eventLst.add("วันพระไทย");
//        }
//
//        return eventLst;
//    }
//
//    public ArrayList<String> getEventListN(){
//        ArrayList<String> eventLst = new ArrayList<>();
//        for (int i=0;i<arrayList.size();i++){
//            if (dmy[0].equals(arrayList.get(i).getDay()) && dmy[1].equals(arrayList.get(i).getMonth())){
//                eventLst.add("");
//            }
//        }
//        for (int j=0;j<ChineseList.size();j++){
//            if (dmy[0].equals(ChineseList.get(j).getDay()) && dmy[1].equals(ChineseList.get(j).getMonth()) && dmy[2].equals(ChineseList.get(j).getYear())){
//                eventLst.add("");
//            }
//        }
//        if (BuddhistHolyDay(dmy)){
//            eventLst.add("");
//        }
//        return eventLst;
//    }
//
//    public boolean BuddhistHolyDay(String[] date){
//        int day = Integer.parseInt(date[0]);
//        int month = Integer.parseInt(date[1]);
//        int year = Integer.parseInt(date[2]);
//        if(month<=2){
//            month+=12;
//            year-=1;
//        }
//        double A = Math.floor(year/100);
//        double B = 2 - A + Math.floor(A/4);
//        double jd = Math.floor(365.25*(year+4716)) + Math.floor(30.6001 * (month +1)) + day + B - 1524.5;
//        double ans = (((jd-2454000.98958)/29.530588*4000)%4000)/1000;
//        if (ans>3.75){
//            ans=ans-3.75;
//        }
//        if ((ans<0.25) || (ans>=0.75 && ans<1.25) || (ans>=1.75 && ans<2.25) || (ans>=2.75 && ans<3.25)){
//            return true;
//        }else{
//            return false;
//        }
//
//    }
//
//}
