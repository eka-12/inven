package com.example.inventarization.model;

import androidx.annotation.NonNull;

public class Cabinet {
    public Cabinet(int _id, String _title, Building _building){
        this.id = _id;
        this.title = _title;
        this.building = _building;
    }

    public Cabinet(){}
    public int id;
    private String title;
    private Building building;

    public void setCabinet(int _id, String _title, Building _building ){
        this.id = _id;
        this.title = _title;
        this.building = _building;
    }


    public int getID(){
        return this.id;
    }

    @NonNull
    @Override
    public String toString() {
        return this.title+" ("+this.building.getTitle()+')';
    }
}
