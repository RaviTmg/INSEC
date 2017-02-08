package com.example.ravitmg.splash;

/**
 * Created by Ravi Tmg on 2/6/2017.
 */
public class Eveents {
    String title, date, desc;

    public Eveents() {
    }

    public Eveents(String title, String date, String desc) {
        this.title = title;
        this.date = date;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
