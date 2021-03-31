package com.example.nearsalmaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ToprestelavivActivity extends AppCompatActivity {
    private Button cafetelaviv;
    private Button barstelaviv;
    private Button restelaviv;
    private  Button goback3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toprestelaviv);
        cafetelaviv = findViewById(R.id.cafetelaviv);
        barstelaviv = findViewById(R.id.barstelaviv);
        restelaviv = findViewById(R.id.restelaviv);
        goback3 = findViewById(R.id.goback3);
        cafetelaviv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int4 = new Intent(ToprestelavivActivity.this, Telcafe.class);
                startActivity(int4);
            }
        });
        barstelaviv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int6 = new Intent(ToprestelavivActivity.this,TelbarsActivity.class);
            startActivity(int6);
            }
        });
        restelaviv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int7 = new Intent(ToprestelavivActivity.this,TelresActivity.class);
                startActivity(int7);
            }
        });
        goback3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int5 = new Intent(ToprestelavivActivity.this,AllPostsActivity.class);
                startActivity(int5);
            }
        });

    }
}