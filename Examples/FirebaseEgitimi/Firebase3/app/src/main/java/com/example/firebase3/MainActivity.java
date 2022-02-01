package com.example.firebase3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref1, id, isim, soyisim, yas, durum, x;
    List<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        oku("ygtozen");
    }

    public void tanimla()
    {
        database = FirebaseDatabase.getInstance();
        ref1 = database.getReference("ygtozen"); // Ana key
        ref1.setValue("yigit");

        id = ref1.child("id");
        id.setValue("1");

        isim = ref1.child("isim");
        isim.setValue("yigit");

        soyisim = ref1.child("soyisim");
        soyisim.setValue("ozen");

        yas = ref1.child("yas");
        yas.setValue(22);

        durum = ref1.child("durum");
        durum.setValue(true);

        /*x = id.child("x"); // Çocuğa çocuk key ekleme
        x.setValue("deneme");*/
    }

    public void oku(String anaKey)
    {
        ref1 = database.getReference(anaKey);
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("isim",snapshot.getValue().toString());
                User d = snapshot.getValue(User.class);

                if (d.isDurum())
                {
                    Log.i("isim","yaşıyor");
                }
                else
                {
                    Log.i("isim","no");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}