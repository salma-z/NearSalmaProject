package com.example.nearsalmaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class haifares extends AppCompatActivity {
    private Button goback4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haifares);
        goback4 = findViewById(R.id.goback4);
        goback4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int11 = new Intent(haifares.this, HaifaNav.class);
                startActivity(int11);
            }
        });
    }
}