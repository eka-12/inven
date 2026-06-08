package com.example.inventarization.model;

import androidx.annotation.NonNull;

public class Worker {
    public Worker(int _id, String _name, Post _post){
        this.id = _id;
        this.name = _name;
        this.post = _post;
    }

    public Worker(){}
    public int id;
    private String name;
    private Post post;

    public void setStaff(int _id, String _name, Post _post ){
        this.id = _id;
        this.name = _name;
        this.post = _post;
    }

    public Worker getStaff(int _id){
        if(this.id==_id){ return this;}
        else{return null;}
    }
    public int getID(){
        return this.id;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
