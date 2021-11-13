package com.example.moonmingcalendar;

public class UserEvent {
    private int id;
    private String datetime;
    private String eventName;
    private String eventDetail;

    public UserEvent (String eventName, String eventDetail){
        this.eventDetail = eventDetail;
        this.eventName = eventName;
    }


    @Override
    public String toString() {
        return "UserEvent{" +
                "eventName='" + eventName + '\'' +
                ", eventDetail='" + eventDetail + '\'' +
                '}';
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail;
    }
}
