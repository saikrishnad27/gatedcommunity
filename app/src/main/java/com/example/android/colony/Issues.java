package com.example.android.colony;

import java.util.HashMap;
import java.util.Map;

public class Issues {
    public String missue;
    public String miuid;
    public String mno;

    public Issues(){


    }


    public Issues(String missue, String miuid,String mno) {

        this.miuid = miuid;
        this.missue=missue;
        this.mno=mno;
    }

    public String getmiuid() {
        return miuid;
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

    public void setmid(String miuid) {
        this.miuid = miuid;
    }

    public void setmpassword(String missue) {
        this.missue= missue;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("uid", this.miuid);

        result.put("issue", this.missue);
        result.put("issueno",this.mno);
        return result;
    }

}


