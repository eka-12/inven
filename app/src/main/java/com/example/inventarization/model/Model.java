package com.example.inventarization.model;

import android.app.Application;

import android.database.Cursor;
import android.database.sqlite.*;


import java.util.ArrayList;


public class Model extends Application {

    private SQLiteDatabase db;
    private ArrayList<Type> types;
    private ArrayList<Post> posts;
    private ArrayList<Building> buildings;
    private ArrayList<Worker> staff;
    private ArrayList<Cabinet> cabinets;
    private Organization organization;

    //заполнение объектной модели данными
    public void ini(){
       this.openDB();
       this.fillListPost();
       this.fillListType();
       this.fillOrganization();
       this.fillListBuilding();
       this.fillListStaff();
       this.fillListCabinets();

    }

    @Override
    protected void finalize() throws Throwable {
        this.db.close();
        super.finalize();
    }

    //удаление записи в таблице по id

    public SQLiteDatabase getDB() {
        return this.db;
    }

    private void openDB(){
        this.db = getBaseContext().openOrCreateDatabase("database.db", MODE_PRIVATE, null);
    }

    //Методы раздела "Тип оборудования"
    public ArrayList<Type> getTypes() {
        return types;
    }

    public void fillListType(){
        Cursor query = this.db.rawQuery("SELECT * FROM type", null);
        this.types = new ArrayList<>();
        while (query.moveToNext()) {
          this.types.add(new Type(query.getInt(0),query.getString(1) ));

        }
    }
    public void addType(String _title){
        this.db.execSQL("INSERT INTO type('title') VALUES ('"+_title+"');");
        fillListType();

    }
    public void deleteType(ArrayList<Integer> _id){
        for(int i=0; i<_id.size(); i++){
            this.db.execSQL("DELETE FROM type WHERE id = "+_id.get(i)+";");
        }
        this.fillListType();

    }


    // методы раздела "Организация"
    public void fillOrganization(){
        Cursor query = this.db.rawQuery("SELECT * FROM organization", null);
        query.moveToNext();
        this.organization = new Organization(query.getInt(0), query.getString(1), query.getString(2));
    }

    public Organization getOrganization(){
        return this.organization;
    }

    public void updateOrganization(String _title, String _addr)
    {
        this.db.execSQL("UPDATE organization set title = '"+_title+"',addr= '"+_addr+"' WHERE id = "+this.organization.id+" ;");
        this.fillOrganization();
    }
// методы раздела "Должность"

    public void fillListPost(){
        Cursor query = this.db.rawQuery("SELECT * FROM post", null);
        this.posts = new ArrayList<>();
        while(query.moveToNext()) {
            this.posts.add(new Post(query.getInt(0), query.getString(1)));

        }
    }

    public ArrayList<Post> getPosts(){
        return this.posts;
    }
    public Post getPostByID(int _id){
        Post rezult = null;

        for(int i=0; i<this.posts.size(); i++){
            if(_id==this.posts.get(i).getID()){
                rezult =  this.posts.get(i);
                break;
            }
        }
        return rezult;
    }

    public void addPost(String _title){
        this.db.execSQL("INSERT INTO post('title') VALUES ('"+_title+"');");
        this.fillListPost();

    }
    public void deletePost(ArrayList<Integer> _id){
        for(int i=0; i<_id.size(); i++){
            this.db.execSQL("DELETE FROM post WHERE id = "+_id.get(i)+";");
        }
        this.fillListPost();

    }

    //Методы раздела "Корпуса"
    public ArrayList<Building> getBuildings(){
        return this.buildings;
    }

    public void fillListBuilding(){
        Cursor query = this.db.rawQuery("SELECT * FROM housing", null);
        this.buildings = new ArrayList<>();
        while(query.moveToNext()) {
            this.buildings.add(new Building(query.getInt(0), query.getString(1), this.organization));

        }
    }
    public void deleteBuilding(ArrayList<Integer> _id){
        for(int i=0; i<_id.size(); i++){
            this.db.execSQL("DELETE FROM housing WHERE id = "+_id.get(i)+";");
        }
        this.fillListBuilding();

    }

    public void addBuilding(String _title){
        this.db.execSQL("INSERT INTO housing ('title', 'organization') VALUES ('"+_title+"',"+this.organization.getID()+");");
        this.fillListBuilding();

    }
    public Building getHousingByID(int _id){
        Building rezult = null;

        for(int i=0; i<this.buildings.size(); i++){
            if(_id==this.buildings.get(i).getID()){
                rezult =  this.buildings.get(i);
                break;
            }
        }
        return rezult;
    }

    //Методы раздела "Сотрудники"
    public void addWorker(String _name, int postID){
        this.db.execSQL("INSERT INTO staff ('name', 'post') VALUES ('"+_name+"',"+postID+");");
        this.fillListStaff();
    }

    public void fillListStaff(){
        Cursor query = this.db.rawQuery("SELECT * FROM staff", null);
        this.staff = new ArrayList<>();
        while(query.moveToNext()) {
            this.staff.add(new Worker(query.getInt(0), query.getString(1), this.getPostByID(query.getInt(2))));
        }
    }

    public ArrayList<Worker> getStaff(){return this.staff;}

    public void deleteStaff(ArrayList<Worker> _worker){
        for(int i=0; i<_worker.size(); i++){
            this.db.execSQL("DELETE FROM staff WHERE id = "+_worker.get(i).getID()+";");
        }
        this.fillListStaff();

    }
    //Методы раздела "Кабинеты"
    public void addCabinet(String _title, Building _building){
        this.db.execSQL("INSERT INTO cabinet ('title', 'housing') VALUES ('"+_title+"',"+_building.getID()+");");
        this.fillListCabinets();
    }

    public void fillListCabinets(){
        Cursor query = this.db.rawQuery("SELECT * FROM cabinet", null);
        this.cabinets = new ArrayList<>();
        while(query.moveToNext()) {
            this.cabinets.add(new Cabinet(query.getInt(0), query.getString(1), this.getHousingByID(query.getInt(2))));
        }
    }

    public ArrayList<Cabinet> getCabinets(){return this.cabinets;}

    public void deleteCabinets(ArrayList<Cabinet> _cabinets){
        for(int i=0; i<_cabinets.size(); i++){
            this.db.execSQL("DELETE FROM cabinet WHERE id = "+_cabinets.get(i).getID()+";");
        }
        this.fillListCabinets();

    }

    // методы класса номер инвентаризационного документа

}
