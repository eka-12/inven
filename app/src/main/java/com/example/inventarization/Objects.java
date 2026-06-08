package com.example.inventarization;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.inventarization.add.AddOrganization;

public class Objects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_objects);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
    public void clickButtonEquipment(View v){
        Intent intent = new Intent(this, Equipment.class);
        startActivity(intent);

    }
    public void clickButtonStaff(View v){
        Intent intent = new Intent(this, Staff.class);
        startActivity(intent);
    }
    public void clickButtonBuilding(View v){
        Intent intent = new Intent(this, Buildings.class);
        startActivity(intent);
    }
    public void clickButtonOrganization(View v){
        Intent intent = new Intent(this, AddOrganization.class);
        startActivity(intent);
    }

    public void clickButtonPost(View v){
        Intent intent = new Intent(this, Posts.class);
        startActivity(intent);
    }
    public void clickButtonType(View v){
        Intent intent = new Intent(this, EquipmentType.class);
        startActivity(intent);
    }
    public void clickButtonCabinets(View v){
        Intent intent = new Intent(this, Cabinets.class);
        startActivity(intent);
    }
}