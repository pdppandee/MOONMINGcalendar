package com.example.moonmingcalendar;

public class ChineseEvent {
    String Name, Detail, notification, Day, Month, Year;
    public ChineseEvent(String name, String detail, String noti, String day, String month, String year) {
        this.Name = name;
        this.Detail = detail;
        this.notification = noti;
        this.Day = day;
        this.Month = month;
        this.Year = year;
    }

    public String getName() {
        return Name;
    }
    public String getDetail() {
        return Detail;
    }
    public String getNotification() {
        return notification;
    }
    public void setNotification(String notification) {
        this.notification = notification;
    }
    public String getDay() {
        return Day;
    }
    public String getMonth() {
        return Month;
    }
    public String getYear() {
        return Year;
    }

}
