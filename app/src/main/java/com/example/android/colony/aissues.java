package com.example.android.colony;

public class aissues {
    public String issue;
    public String uid;
    public String issueno;

    public aissues(){


    }


    public aissues(String issue, String uid,String issueno) {

        this.uid = uid;
        this.issue=issue;
        this.issueno=issueno;
    }

    public String getuid() {
        return uid;
    }

    public String getissue() {
        return issue;
    }

    public String getissueno() {
        return issueno;
    }

    public void setissueno(String issueno) {
        this.issueno = issueno;
    }

    public void setuid(String uid) {
        this.uid = uid;
    }

    public void setissue(String issue) {
        this.issue= issue;
    }


}



