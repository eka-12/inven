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
import com.example.inventarization.model.Post;

import java.util.ArrayList;

public class AddWorker extends AppCompatActivity {
    EditText workerName;
    Model globalVariables;
    ArrayList<Post> posts;
    Spinner spinnerPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_staff);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        workerName = findViewById(R.id.textWorkerName);
        spinnerPost = findViewById(R.id.spinnerPosts);
        globalVariables = (Model) getApplicationContext();
        this.posts = globalVariables.getPosts();
        ArrayAdapter<Post> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, posts);
        spinnerPost.setAdapter(adapter);
    }
    public void clickAddWorker(View v){
        Post post = (Post)spinnerPost.getSelectedItem();

        globalVariables.addWorker(workerName.getText().toString(), post.getID());
        Toast.makeText(AddWorker.this, "ok", Toast.LENGTH_LONG).show();



    }

}