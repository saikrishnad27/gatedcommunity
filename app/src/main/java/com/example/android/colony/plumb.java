package com.example.android.colony;

import java.util.HashMap;
import java.util.Map;

public class plumb {
    public String description;
    public String number;
    public String name;

    public plumb(){}

    public plumb(String description, String name,String number) {
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
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("description", this.description);
        result.put("name",this.name);
        result.put("number",this.number);

        return result;
    }




}


