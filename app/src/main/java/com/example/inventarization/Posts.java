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

import com.example.inventarization.add.AddPost;
import com.example.inventarization.model.Model;
import com.example.inventarization.model.Post;

import java.util.ArrayList;

public class Posts extends AppCompatActivity {
    ListView postList;
    Model globalVariables;
    ArrayList<Post> posts;
    ArrayAdapter<Post> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_posts);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        postList = findViewById(R.id.PostList);
        globalVariables = (Model) getApplicationContext();
        posts = globalVariables.getPosts();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, posts);
        postList.setAdapter(adapter);
    }

    public void clickButtonAddPost(View v){
        Intent intent = new Intent(this, AddPost.class);
        startActivity(intent);
    }


    public void clickButtonUpdateListPost(View v){

    }

    public void clickButtonDeletePost(View v){
        SparseBooleanArray selectedPosts= postList.getCheckedItemPositions();
        ArrayList<Integer> id = new ArrayList<Integer>();

        for(int i = 0; i< posts.size(); i++){
            if(selectedPosts.get(i)){
                id.add(posts.get(i).getID());
                adapter.remove(posts.get(i));
            }
        }
        globalVariables.deletePost(id);

        Toast.makeText(Posts.this, "OK", Toast.LENGTH_LONG).show();
    }
}