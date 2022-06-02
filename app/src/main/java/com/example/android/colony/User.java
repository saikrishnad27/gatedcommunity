package com.example.android.colony;

public class User {
    public  String name;
    public String id;
    public String mobile;
    public String flatno;
    public String email;
    public String key;

    public User(){}

    public User(String email,String flatno, String id,String key,String mobile,String name) {
        this.mobile=mobile;
        this.id = id;
        this.flatno=flatno;
        this.key=key;
        this.email=email;
        this.name=name;

    }

    public String getflatno() {
        return flatno;
    }

    public String getkey() {
        return key;
    }

    public String getname() {
        return name;
    }

    public String getemail() {
        return email;
    }

    public String getid() {
        return id;
    }



    public String getmobile() {
        return mobile;
    }

    public void setmobile(String mobile) {
        this.mobile = mobile;
    }

    public void setid(String id) {
        this.id = id;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public void setflatno(String flatno) {
        this.flatno = flatno;
    }

    public void setkey(String key) {
        this.key = key;
    }

    public void setname(String name) {
        this.name = name;
    }
}
