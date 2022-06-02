package com.example.android.colony;

public class Worker {
    public  String job;
    public String id;
    public String name;
    public String phno;


    public Worker(){}

    public Worker(String id,String job, String name,String phno) {

        this.id = id;
        this.phno=phno;
        this.job=job;

        this.name=name;

    }

    public String getphno() {
        return phno;
    }

    public String getjob() {
        return job;
    }

    public String getname() {
        return name;
    }


    public String getid() {
        return id;
    }




}
