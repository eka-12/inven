package com.example.inventarization.add;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.inventarization.model.Model;
import com.example.inventarization.R;
import com.example.inventarization.model.Building;
import com.example.inventarization.model.Post;

import java.util.ArrayList;

public class AddCabinet extends AppCompatActivity {
    EditText cabinetTitle;
    Model globalVariables;
    ArrayList<Building> buildings;
    Spinner spinnerBuildings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_cabinet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cabinetTitle = findViewById(R.id.textCabinetTitle);
        spinnerBuildings = findViewById(R.id.spinnerBuildings);
        globalVariables = (Model) getApplicationContext();
        this.buildings = globalVariables.getBuildings();
        ArrayAdapter<Post> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, buildings);
        spinnerBuildings.setAdapter(adapter);
    }

    public void clickAddCabinet(View v){
        Building building = (Building)spinnerBuildings.getSelectedItem();

        globalVariables.addCabinet(cabinetTitle.getText().toString(), building);
        Toast.makeText(AddCabinet.this, "ok", Toast.LENGTH_LONG).show();



    }



}