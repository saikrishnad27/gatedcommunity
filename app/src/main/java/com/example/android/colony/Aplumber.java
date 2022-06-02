package com.example.android.colony;

public class Aplumber {
        public String description;
        public String number;
       public String name;

        public Aplumber(){}

        public Aplumber(String description, String name,String number) {
            this.description=description;
            this.number = number;
            this.name=name;
        }

        public String getdescription() {
            return description;
        }

        public String getnumber() {
            return number;
        }

        public String getname() {
            return name;
        }



    }

