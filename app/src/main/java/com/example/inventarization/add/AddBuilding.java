package com.example.inventarization.add;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.inventarization.model.Model;
import com.example.inventarization.R;

public class AddBuilding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_building);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void clickAddBuilding(View v){
        EditText buildingName = findViewById(R.id.textBuildingName);
        Model globalVariables = (Model) getApplicationContext();
        globalVariables.addBuilding(buildingName.getText().toString());
        Toast.makeText(AddBuilding.this, "ok", Toast.LENGTH_LONG).show();



    }
}