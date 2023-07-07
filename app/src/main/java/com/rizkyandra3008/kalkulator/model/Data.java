package com.rizkyandra3008.kalkulator.model;

public class Data {
    private String id, suhu, date, time;

    public Data() {

    }

    public Data(String id, String suhu, String date, String time) {
        this.id = id;
        this.suhu = suhu;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSuhu() {
        return suhu;
    }

    public void setSuhu(String suhu) {
        this.suhu = suhu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
