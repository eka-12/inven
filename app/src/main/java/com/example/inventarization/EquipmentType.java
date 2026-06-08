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

import com.example.inventarization.add.AddType;
import com.example.inventarization.model.Model;
import com.example.inventarization.model.Type;

import java.util.ArrayList;

public class EquipmentType extends AppCompatActivity {
    ListView typeList;
    Model globalVariables;
    ArrayList<Type> types;
    ArrayAdapter<Type> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_equipment_type);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        typeList = findViewById(R.id.TypeList);
        globalVariables = (Model) getApplicationContext();
        types = globalVariables.getTypes();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, types);
        typeList.setAdapter(adapter);

    }

    public void clickButtonAddType(View v){
        Intent intent = new Intent(this, AddType.class);
        startActivity(intent);
    }
    public void clickButtonUpdateListType(View v){


    }
    public void clickButtonDeleteType(View v){
        SparseBooleanArray selectedTypes= typeList.getCheckedItemPositions();
        ArrayList<Integer> id = new ArrayList<Integer>();

        for(int i = 0; i< types.size(); i++){
            if(selectedTypes.get(i)){
                id.add(types.get(i).getId());
                adapter.remove(types.get(i));
            }
        }
        globalVariables.deleteType(id);

        Toast.makeText(EquipmentType.this, "OK", Toast.LENGTH_LONG).show();

    }

}
