package com.example.android.colony;

public class Word {
    public String matter;
    public String number;
    public String place;
    public Word(){}


    public Word(String matter, String number,String place) {
        this.matter = matter;
        this.number = number;
        this.place=place;

    }

    public String getmatter() {
        return matter;
    }

    public String getnumber() {
        return number;

    }

    public String getplace() {
        return place;
    }
}