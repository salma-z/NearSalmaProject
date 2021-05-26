package com.example.nearsalmaproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    private Bitmap bitmap;
    private Menu menu;

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
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.editprofile) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.profilepic) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 0);
        }

        return true;

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                bitmap = (Bitmap) data.getExtras().get("data");
                Drawable d = new BitmapDrawable(getResources(), bitmap);

                menu.getItem(1).setIcon(d);
            }
        }
    }


}