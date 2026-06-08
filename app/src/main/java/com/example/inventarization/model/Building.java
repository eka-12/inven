package com.example.inventarization.model;

import androidx.annotation.NonNull;

public class Building {
    private int id;
    private String title;
    private Organization organization;


    public Building(int _id, String _title, Organization _organization){
        this.id = _id;
        this.title = _title;
        this.organization = _organization;
    }

    public int getID(){
        return this.id;
    }
    public void setHousing(int _id, String _title, Organization _organization){
        this.id = _id;
        this.title = _title;
        this.organization = _organization;
    }
    public String getTitle(){
        return this.title;
    }

    public Building getHousing(int _id){
        if(this.id==_id){ return this;}
        else{return null;}
    }

    @NonNull
    @Override
    public String toString() {
        return this.title;
    }
}
