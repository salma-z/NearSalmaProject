package com.example.nearsalmaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class TopresActivity extends AppCompatActivity {
    private Button haifacafe;
    private Button haifabars;
    private Button reshaifa;
    private Button goback2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toprestelaviv);
        goback2 = findViewById(R.id.goback2);
        haifacafe = findViewById(R.id.haifacafe);
        haifabars = findViewById(R.id.haifabars);
        reshaifa = findViewById(R.id.reshaifa);
        goback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int8= new Intent(TopresActivity.this, AllPostsActivity.class);
                startActivity(int8);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}


