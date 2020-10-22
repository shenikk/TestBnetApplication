package com.example.testapplication;

import java.util.Calendar;

public class Note {
   // private Calendar da; // дата создания
   // private Calendar dm; //дата модификации
    private String text;

    //временно изменила конструктор
    public Note(String text) {
       // this.da = da;
        //this.dm = dm;
        this.text = text;
    }

//    public Calendar getDa() {
//        return da;
//    }
//
//    public void setDa(Calendar da) {
//        this.da = da;
//    }
//
//    public Calendar getDm() {
//        return dm;
//    }
//
//    public void setDm(Calendar dm) {
//        this.dm = dm;
//    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
