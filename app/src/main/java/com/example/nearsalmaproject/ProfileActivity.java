package com.example.nearsalmaproject;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private Button submit;
    private EditText addusername;
    private ImageView profilephoto;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference usernameRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseDatabase = FirebaseDatabase.getInstance();
        profilephoto = findViewById(R.id.profilephoto);
        addusername = findViewById(R.id.addusername);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
    post username = new post("",uid,addusername.getText().toString());
    usernameRef = firebaseDatabase.getReference("username").push();
    username.key=usernameRef.getKey();
    usernameRef.setValue(username);
    Toast.makeText(this, "saved",Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }



}