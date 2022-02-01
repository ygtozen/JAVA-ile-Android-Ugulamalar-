package com.example.firebase2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    private EditText key, value;
    private Button ekle;
    private TextView result;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        goster();
        action();

    }

    public void tanimla()
    {
        database = FirebaseDatabase.getInstance();

        key = findViewById(R.id.key);
        value = findViewById(R.id.value);
        result = findViewById(R.id.result);
        ekle = findViewById(R.id.ekle);
    }

    public void action()
    {
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_key = key.getText().toString();
                String txt_value = value.getText().toString();

                reference = database.getReference(txt_key); // Edittexten key alır.
                reference.setValue(txt_value); // value edittexTen alıcak.

                key.setText(""); // Edittext içini siler
                value.setText(""); // Edittext içini siler
            }
        });
    }

    public void goster()
    {
        reference = database.getReference("adi");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                result.setText(datasnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}