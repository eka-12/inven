package com.example.inventarization.model;

import androidx.annotation.NonNull;

public class Post {

    public Post (int _id, String _title){
        this.id = _id;
        this.title = _title;
    }

    public Post(){}
    private int id;
    private String title;

    public void setPost(int _id, String _title){
        this.id = _id;
        this.title = _title;
    }

    public Post getPost(int _id){
        if(this.id==_id){ return this;}
        else{return null;}
    }

    public int getID(){
        return this.id;
    }

    @NonNull
    @Override
    public String toString() {
        return this.title;
    }
}
