package com.example.nearsalmaproject;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class post {
    public String key;
    public String uid;
    public String username;
    public post(){

    }
    public post (String key, String uid, String username){
        this.key = key;
        this.uid = uid;
        this.username = username;
    }

}
