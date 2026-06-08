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

import com.example.inventarization.add.AddCabinet;
import com.example.inventarization.model.Cabinet;
import com.example.inventarization.model.Model;

import java.util.ArrayList;

public class Cabinets extends AppCompatActivity {
    ListView cabinetsList;
    Model globalVariables;
    ArrayList<Cabinet> cabinets;
    ArrayAdapter<Cabinet> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cabinets);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cabinetsList = findViewById(R.id.CabinetsList);
        globalVariables = (Model) getApplicationContext();
        cabinets = globalVariables.getCabinets();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, cabinets);
        cabinetsList.setAdapter(adapter);
    }

    public void clickButtonAddCabinet(View v){
        Intent intent = new Intent(this, AddCabinet.class);
        startActivity(intent);
    }


    public void clickButtonUpdateListCabinets(View v){

    }

    public void clickButtonDeleteCabinet(View v){
        SparseBooleanArray selectedCabinets= cabinetsList.getCheckedItemPositions();
        ArrayList<Cabinet> delete = new ArrayList<Cabinet>();

        for(int i = 0; i< cabinets.size(); i++){
            if(selectedCabinets.get(i)){
                delete.add(cabinets.get(i));
                adapter.remove(cabinets.get(i));
            }
        }
        globalVariables.deleteCabinets(delete);

        Toast.makeText(Cabinets.this, "OK", Toast.LENGTH_LONG).show();
    }
}