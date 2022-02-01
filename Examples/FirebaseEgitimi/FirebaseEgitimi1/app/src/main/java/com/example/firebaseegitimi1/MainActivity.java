package com.example.firebaseegitimi1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        //Database'ye ait örneği database nesnesine atıyoruz.

        // Key oluşturmak için
        // İstediğimiz key'i alırız, böyle bir key yoksa oluşturur
        ref1 = database.getReference("adi"); // adi isminde sütun oluşturdu
        ref1.setValue("yigit"); // adi içine yigit'i ekledi.

        //Okuma yapmak istiyorsanız
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Hata yoksa buraya
                Log.i("value",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Hata varsa buraya
            }
        });

        ref1.setValue("umut");

    }
}