package com.example.inventarization.add;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.inventarization.model.Model;
import com.example.inventarization.R;
import com.example.inventarization.model.Organization;

public class AddOrganization extends AppCompatActivity {
    EditText OrganizationName;
    EditText OrganizationAddr;
    Model globalVariables;
    Organization org;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_organization);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        OrganizationName = findViewById(R.id.textOrganizationName);
        OrganizationAddr = findViewById(R.id.textOrganizationAddr);
        globalVariables = (Model) getApplicationContext();
        org = globalVariables.getOrganization();
        OrganizationName.setText(org.getTitle());
        OrganizationAddr.setText(org.getAddr());
    }


    public void clickSaveOrganization(View v){
        globalVariables.updateOrganization(OrganizationName.getText().toString(), OrganizationAddr.getText().toString());
    }
}