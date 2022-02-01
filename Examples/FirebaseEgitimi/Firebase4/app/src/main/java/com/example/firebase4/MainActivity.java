package com.example.firebase4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref1, ref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        ref1 = database.getReference("Users/ygt");
        ref2 = database.getReference("Users/umut");

        UserDetails userDetails = new UserDetails("yigit","ozen","22");
        ref1.setValue(userDetails);


        Map map = new HashMap();
        map.put("sehir","bandirma");
        map.put("ulke","turkiye");
        map.put("tcno","000000000000");
        ref2.setValue(map);
    }
}