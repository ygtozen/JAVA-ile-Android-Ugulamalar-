package com.example.aramayapma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPhone;
    private Button buttonArama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        aramaYap();
    }

    public void tanimla()
    {
        editTextPhone = findViewById(R.id.editTextPhone);
        buttonArama = findViewById(R.id.buttonArama);
    }

    public void aramaYap()
    {
        buttonArama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String veriAl = editTextPhone.getText().toString();

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + veriAl));
                startActivity(intent);
            }
        });
    }
}






