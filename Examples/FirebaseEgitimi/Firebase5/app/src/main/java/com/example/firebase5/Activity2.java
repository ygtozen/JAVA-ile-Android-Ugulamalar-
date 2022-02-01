package com.example.firebase5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity2 extends AppCompatActivity {

    private EditText parola, yas, isim;
    private Button kaydet;
    FirebaseDatabase database;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tanimla();
    }

    public void tanimla()
    {
        database = FirebaseDatabase.getInstance();

        parola = findViewById(R.id.parola);
        yas = findViewById(R.id.yas);
        isim = findViewById(R.id.isim);
        kaydet = findViewById(R.id.kaydet);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref = database.getReference("users/"+User.getUsername());
                UserDetails u1 = new UserDetails(parola.getText().toString(),
                        yas.getText().toString(), isim.getText().toString());
                ref.setValue(u1);

                Intent intent = new Intent(Activity2.this,Activity3.class);
                startActivity(intent);
            }
        });
    }
}