package com.example.inventarization.model;

public class Organization {
    public int id;
    private String title;
    private String addr;
    public Organization(int _id, String _title, String _addr){

        this.id = _id;
        this.title = _title;
        this.addr = _addr;
    }

    public String getTitle(){
        return this.title;
    }
    public String getAddr(){
        return this.addr;
    }

    public int getID(){
        return this.id;
    }

}
