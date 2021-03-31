package com.example.nearsalmaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class AllPostsActivity extends AppCompatActivity  {
    private Button HaifaRes;
    private Button Telavivres;
    private Button goback1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_posts);

        HaifaRes = findViewById(R.id.HaifaRes);
        Telavivres = findViewById(R.id.Telavivres);
        goback1 = findViewById(R.id.goback1);
       HaifaRes.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent int1 = new Intent(AllPostsActivity.this,TopresActivity.class);
               startActivity(int1);
           }
       });

       Telavivres.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent int2 = new Intent(AllPostsActivity.this, ToprestelavivActivity.class);
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