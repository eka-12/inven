package com.example.inventarization.model;

public class Equipment {
    private int id;
    private String title;
    private String numder;
    private double cost;
    private String date;

    public Equipment (int _id, String _title, String _number, double _cost, String _date){
        this.id = _id;
        this.title = _title;
        this.numder = _number;
        this.cost = _cost;
        this.date = _date;

    }

    public Equipment(){}


    public void setEquipment(int _id, String _title, String _number, double _cost, String _date){
        this.id = _id;
        this.title = _title;
        this.numder = _number;
        this.cost = _cost;
        this.date = _date;

    }

    public Equipment getEquipment(int _id){
        if(this.id==_id){ return this;}
        else{return null;}
    }
}
