package com.example.sqlwithimage;

import android.content.Intent;

public class pojocontact {

    private String name;
    private String email;
    private String number;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

public pojocontact(String name ,String email, String number)
{
    this.name=name;
    this.email=email;
    this.number=number;
}

}
