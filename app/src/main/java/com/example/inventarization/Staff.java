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

import com.example.inventarization.add.AddWorker;
import com.example.inventarization.model.Model;
import com.example.inventarization.model.Worker;

import java.util.ArrayList;

public class Staff extends AppCompatActivity {
    ListView staffList;
    Model globalVariables;
    ArrayList<Worker> staff;
    ArrayAdapter<Worker> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_staff);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        staffList = findViewById(R.id.StaffList);
        globalVariables = (Model) getApplicationContext();
        staff = globalVariables.getStaff();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, staff);
        staffList.setAdapter(adapter);
    }
    public void clickButtonAddWorker(View v){
        Intent intent = new Intent(this, AddWorker.class);
        startActivity(intent);
    }


    public void clickButtonUpdateListStaff(View v){

    }

    public void clickButtonDeleteStaff(View v){
        SparseBooleanArray selectedStaff= staffList.getCheckedItemPositions();
        ArrayList<Worker> delete = new ArrayList<Worker>();

        for(int i = 0; i< staff.size(); i++){
            if(selectedStaff.get(i)){
                delete.add(staff.get(i));
                adapter.remove(staff.get(i));
            }
        }
        globalVariables.deleteStaff(delete);

        Toast.makeText(Staff.this, "OK", Toast.LENGTH_LONG).show();
    }
}
