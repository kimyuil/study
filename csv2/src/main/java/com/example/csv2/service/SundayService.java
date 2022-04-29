package com.example.csv2.service;

public class SundayService extends WorshipList {
    String preacher;

    public SundayService(String attendanceName, String depart, String rank, int age, String preacher) {
        super("주일예배", attendanceName, depart, rank, age);
        this.preacher = preacher;
    }    

    public String getPreacher() {
        return this.preacher;
    }

    public void setPreacher(String preacher) {
        this.preacher = preacher;
    }
}
