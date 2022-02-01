package com.example.firebase6;

import com.google.firebase.database.DatabaseReference;

public class GetKeys {

    public static String getKey(DatabaseReference ref)
    {
        DatabaseReference push =  ref.child("message").push();
        String key = push.getKey();
        return key;
    }

}
