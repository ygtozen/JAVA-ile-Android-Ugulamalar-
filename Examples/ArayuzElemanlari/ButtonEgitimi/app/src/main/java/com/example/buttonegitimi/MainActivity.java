package com.example.buttonegitimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimlama();
        islevVer();

    }

    private void tanimlama(){
        button1 = findViewById(R.id.button1);
    }

    private void islevVer() {

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button a tıklandı");
                //Toast.makeText(getApplicationContext(),"Butona tıklandı.",Toast.LENGTH_SHORT).show();
            }
        });

    }
}