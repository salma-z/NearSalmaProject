package com.example.nearsalmaproject;


import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences sp;
    private Button buttonlogin;
    private Button buttonsignup;
    private EditText editTextTextEmailAddress;
    private EditText editTextTextPassword;
    private  Bitmap bitmap;




    private FirebaseAuth mAuth;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("users", 0);
        buttonlogin = findViewById(R.id.buttonlogin);
        buttonsignup = findViewById(R.id.buttonsignup);
        buttonsignup.setOnClickListener(this);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);

        mAuth = FirebaseAuth.getInstance();
        buttonlogin.setOnClickListener(this);

        Intent notification = new Intent(this, MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,1,notification,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager =(AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC, System.currentTimeMillis(),1000*60*60*20, pendingIntent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        for (int i =0; i<menu.size();i++) {
            MenuItem item = menu.getItem(i);
            if (item.getItemId()==R.id.profilepic){
               if (bitmap!=null){
                 //  item.setIcon()
               }
            }
        }return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.editprofile) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.camera) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 0);
        }
        else{
            //todo
        }

        return true;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                 bitmap = (Bitmap) data.getExtras().get("data");

            }
        }
    }

    @Override
    public void onClick(View view) {
        if (editTextTextEmailAddress.getText().toString().equals("") || editTextTextPassword.getText().toString().equals(""))
            Toast.makeText(this, "password or email is empty", Toast.LENGTH_LONG).show();
        else {
            if (view == buttonlogin) {
                signin(editTextTextEmailAddress.getText().toString(), editTextTextPassword.getText().toString());

                SharedPreferences.Editor editor = sp.edit();
                String user = editTextTextEmailAddress.getText().toString();
                String password = editTextTextPassword.getText().toString();
                editor.putString("user", user);
                editor.putString("password", password);
                editor.commit();
            } else
                createuser(editTextTextEmailAddress, editTextTextPassword);
        }
    }

    private void signin(String email, String password) {
        mAuth.signInWithEmailAndPassword(email ,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this, "Authentication success.",
                                    Toast.LENGTH_SHORT).show();
                            // Sign in success, update UI with the signed-in user's information
                            Intent i = new Intent(MainActivity.this, AllPostsActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }

    public void createLoginDialog(){
        Dialog d = new Dialog(this);
        d.setContentView(R.layout.activity_main);
        d.setCancelable(true);
        editTextTextPassword = d.findViewById(R.id.editTextTextPassword);
        editTextTextEmailAddress = d.findViewById(R.id.editTextTextEmailAddress);
        buttonlogin.setOnClickListener(this);
        d.show();
    }

    private void createuser(EditText editTextTextEmailAddress, EditText editTextTextPassword) {
        mAuth.createUserWithEmailAndPassword(editTextTextEmailAddress.getText().toString() , editTextTextPassword.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent i = new Intent(MainActivity.this, AllPostsActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            Log.d("FIREBASESALMA",task.getException().toString());

                        }

                        // ...
                    }
                });
    }
}
