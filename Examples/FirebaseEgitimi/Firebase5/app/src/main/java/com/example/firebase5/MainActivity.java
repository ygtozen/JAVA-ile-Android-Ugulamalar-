package com.example.firebase5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private Button ekle;
    FirebaseDatabase database;
    DatabaseReference ref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
    }

    public void tanimla()
    {
        database = FirebaseDatabase.getInstance();

        username = findViewById(R.id.username);
        ekle = findViewById(R.id.ekle);

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref1 = database.getReference("users/"+username.getText().toString());
                ref1.setValue("");
                User.setUsername(username.getText().toString());

                Intent intent = new Intent(MainActivity.this,Activity2.class);
                startActivity(intent);
            }
        });
    }




}