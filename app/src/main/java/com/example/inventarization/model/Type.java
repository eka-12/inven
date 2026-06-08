package com.example.inventarization.model;

import androidx.annotation.NonNull;

public class Type {
    public Type (int _id, String _title){
        this.id = _id;
        this.title = _title;
    }

    public Type(){}
    private int id;
    private String title;

    public void setType(int _id, String _title){
        this.id = _id;
        this.title = _title;
    }

    public Type getType(int _id){
        if(this.id==_id){ return this;}
        else{return null;}
    }

    public int getId(){
        return this.id;
    }
    public String getTitle(){return this.title;}

    @NonNull
    @Override
    public String toString() {
        return this.title;
    }
}
