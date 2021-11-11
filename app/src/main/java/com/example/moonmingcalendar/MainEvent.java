package com.example.moonmingcalendar;

public class MainEvent {
    String Name, Detail, notification, Day, Month;

    public MainEvent(String name, String detail, String noti, String day, String month) {
        this.Name = name;
        this.Detail = detail;
        this.notification = noti;
        this.Day = day;
        this.Month = month;
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
}
