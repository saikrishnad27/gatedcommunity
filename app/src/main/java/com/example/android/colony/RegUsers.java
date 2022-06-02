package com.example.android.colony;

import java.util.HashMap;
import java.util.Map;

public class RegUsers {
    public String mid;
    public String mmobileno;
    public String mname;
    public String mflatno;
    public String memail;
    public String muid;
    public RegUsers(){


    }


    public RegUsers(String memail,String mflatno, String mmobileno,String mname, String mid,String muid) {
        this.memail=memail;
        this.mname=mname;
        this.mflatno=mflatno;
        this.muid=muid;
        this.mid = mid;

        this.mmobileno=mmobileno;
    }

    public String getmuid() {
        return muid;
    }

    public void setmuid(String muid) {
        this.muid = muid;
    }

    public String getmid() {
        return mid;
    }

    public String getmflatno() {
        return mflatno;
    }

    public String getmemail() {

        return memail;
    }




    public String getmmobileno() {
        return mmobileno;

    }

    public String getmname() {
        return mname;
    }

    public void setmmobileno(String mmobileno) {
        this.mmobileno = mmobileno;
    }

    public void setmid(String mid) {
        this.mid = mid;
    }


    public void setmemail(String memail) {
        this.memail = memail;
    }

    public void setmflatno(String mflatno) {
        this.mflatno = mflatno;
    }

    public void setmname(String mname) {
        this.mname = mname;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("id", this.mid);
        result.put("email",this.memail);
        result.put("name",this.mname);
        result.put("flatno",this.mflatno);
        result.put("mobile",this.mmobileno);
        result.put("key",this.muid);
        return result;
    }

}
