package com.example.inventarization.model;

import androidx.annotation.NonNull;

public class Inventory_number {
    private int id;
    private String title;

    public Inventory_number(int _id, String _title) {
        this.id = _id;
        this.title = _title;
    }

    public String getTitle(){
        return this.title;
    }


    @NonNull
    @Override
    public String toString() {
        return this.title;
    }
}
