package com.example.android.colony;

import java.util.HashMap;
import java.util.Map;

public class Announcements{
    public String missue;
    public String mno;
    public String mplace;

    public Announcements(){


    }


    public Announcements(String missue,String mno,String mplace) {

this.mplace=mplace;
        this.missue=missue;
        this.mno=mno;
    }


    public String getmissue() {
        return missue;
    }

    public String getmno() {
        return mno;
    }

    public void setmno(String mno) {
        this.mno = mno;
    }

    public void setmissue(String missue) {
        this.missue= missue;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();


        result.put("matter", this.missue);
        result.put("number",this.mno);
        result.put("place",this.mplace);
        return result;
    }

}

