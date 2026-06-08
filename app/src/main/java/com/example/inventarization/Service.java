package com.example.inventarization;

import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.inventarization.model.Model;

public class Service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_service);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void clickButtonAddDB(View v){
        Model globalVariablec = (Model)getApplicationContext();
        SQLiteDatabase db = globalVariablec.getDB();
        Resources res = getResources();
        String [] queryLine = res.getStringArray(R.array.query);

        for (String s : queryLine) {
            db.execSQL(s);
        }
        Toast.makeText(this, db.getPath(), Toast.LENGTH_LONG).show();
        db.close();


    }
}