package com.example.intentkavramiactivitylerarasigecis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonGecis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        gecisYap();
    }

    public void tanimla()
    {
        buttonGecis = findViewById(R.id.buttonGecis);
    }

    public void gecisYap()
    {
        buttonGecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Activity2.class);
                startActivity(intent);
            }
        });
    }
}