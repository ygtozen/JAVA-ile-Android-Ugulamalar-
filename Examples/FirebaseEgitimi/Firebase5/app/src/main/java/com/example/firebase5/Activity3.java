package com.example.firebase5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Activity3 extends AppCompatActivity {

    private TextView txt_parola, txt_yas, txt_isim;
    FirebaseDatabase database;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        tanimla();
    }

    public void tanimla()
    {
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("users/"+User.getUsername());

        txt_parola = findViewById(R.id.txt_parola);
        txt_yas = findViewById(R.id.txt_yas);
        txt_isim = findViewById(R.id.txt_isim);


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("gelen",snapshot.getValue().toString());

                UserBilgi userBilgi = snapshot.getValue(UserBilgi.class);

                txt_parola.setText(userBilgi.getParola());
                txt_yas.setText(userBilgi.getYas());
                txt_isim.setText(userBilgi.getIsim());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}