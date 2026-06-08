package com.example.inventarization;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.inventarization.add.AddBuilding;
import com.example.inventarization.model.Building;
import com.example.inventarization.model.Model;

import java.util.ArrayList;

public class Buildings extends AppCompatActivity {
    ListView buildingList;
    Model globalVariables;
    ArrayList<Building> buildings;
    ArrayAdapter<Building> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buildings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buildingList = findViewById(R.id.BuildingList);
        globalVariables = (Model) getApplicationContext();
        buildings = globalVariables.getBuildings();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, buildings);
        buildingList.setAdapter(adapter);
    }

    public void clickButtonAddBuilding(View v){
        Intent intent = new Intent(this, AddBuilding.class);
        startActivity(intent);
    }


    public void clickButtonUpdateListBuilding(View v){

    }

    public void clickButtonDeleteBuilding(View v){
        SparseBooleanArray selectedPosts= buildingList.getCheckedItemPositions();
        ArrayList<Integer> id = new ArrayList<Integer>();

        for(int i = 0; i< buildings.size(); i++){
            if(selectedPosts.get(i)){
                id.add(buildings.get(i).getID());
                adapter.remove(buildings.get(i));
            }
        }
        globalVariables.deleteBuilding(id);

        Toast.makeText(Buildings.this, "OK", Toast.LENGTH_LONG).show();
    }
}