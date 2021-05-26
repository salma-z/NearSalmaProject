package com.example.nearsalmaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AllPostsActivity extends AppCompatActivity  {
    private Button Haifabutton;
    private Button goback1;
    private Button Telavivbuton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_posts);

        Haifabutton = findViewById(R.id.Haifabutton);
        Telavivbuton = findViewById(R.id.Telavivbuton);
        goback1 = findViewById(R.id.goback1);
        Haifabutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent int1 = new Intent(AllPostsActivity.this, HaifaNav.class);
               startActivity(int1);
           }
       });

        Telavivbuton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent int2 = new Intent(AllPostsActivity.this, Telavivnav.class);
               startActivity(int2);
           }
       });

       goback1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent int3 = new Intent(AllPostsActivity.this, MainActivity.class);
               startActivity(int3);
           }
       });

    }

}