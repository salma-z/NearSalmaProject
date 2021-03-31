package com.example.nearsalmaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addsugg;
    private ImageView profilephoto;
    private TextView addpost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profilephoto = findViewById(R.id.profilephoto);
        addsugg = findViewById(R.id.addsugg);
        addpost = findViewById(R.id.addpost);
        addsugg.setOnClickListener(this);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onClick(View view) {

    }
}