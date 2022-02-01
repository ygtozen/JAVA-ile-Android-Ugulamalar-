package com.example.mailgonderme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mailAdres, icerik, konu;
    private Button mailGonder;

    private String icerikText, konuText, mailAdresText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        mailUygulamalariniGorveGonder();
    }

    public void tanimla()
    {
        mailAdres = findViewById(R.id.editTextMailAdres);
        icerik = findViewById(R.id.editTextMailIcerik);
        konu = findViewById(R.id.editTextMailKonu);
        mailGonder = findViewById(R.id.mailGonder);
    }

    public void bilgiAl()
    {
        icerikText = icerik.getText().toString();
        konuText = konu.getText().toString();
        mailAdresText = mailAdres.getText().toString();
    }

    public void mailUygulamalariniGorveGonder() {
        mailGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bilgiAl();

                try {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL, mailAdresText);
                    intent.putExtra(Intent.EXTRA_SUBJECT, konuText);
                    intent.putExtra(Intent.EXTRA_TEXT, icerikText);
                    startActivity(Intent.createChooser(intent,"Mail Gönderiniz..."));
                } catch (Exception e) {
                    System.out.println("" + e);
                }
            }
        });
    }
}