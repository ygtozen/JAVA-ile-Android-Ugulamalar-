package com.example.firebase6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference();

        // 1. adım = > ana child ismi belirleme
        String mainChild = "messages/";

        // 2. adım = > key üretme
        DatabaseReference push = ref.child("message").push();
        String key = push.getKey();

        // 3. adım = > key'e ait cocuk key ve value ların belirlenmesi.
        Map icerik = new HashMap();
        icerik.put("icerik","merhaba");
        icerik.put("date","10.02.2021");


        Map add = new HashMap();
        add.put(mainChild + key, icerik);

        ref.updateChildren(add, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(getApplicationContext(),"Başarıyla eklendi.",Toast.LENGTH_LONG).show();
            }
        });

    }
}