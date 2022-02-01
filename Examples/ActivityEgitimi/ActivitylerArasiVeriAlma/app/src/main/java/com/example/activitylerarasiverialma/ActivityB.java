package com.example.activitylerarasiverialma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    private TextView isim,sifre,cinsiyet;
    private String k_adi,k_sifre,k_cinsiyet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        tanimla();
        al();
    }

    public void tanimla()
    {
        isim = findViewById(R.id.isim);
        sifre = findViewById(R.id.sifre);
        cinsiyet = findViewById(R.id.cinsiyet);
    }

    public void al()
    {
        Bundle intent = getIntent().getExtras();

        k_adi = intent.getString("kullaniciAdi");
        k_sifre = intent.getString("kullaniciSifre");
        k_cinsiyet = intent.getString("kullaniciCinsiyet");



        isim.setText(isim.getText() + k_adi);
        sifre.setText(sifre.getText() + k_sifre);
        cinsiyet.setText(cinsiyet.getText() + k_cinsiyet);

        Log.i("DEGERLER_2",k_adi + " " + k_sifre + " " + k_cinsiyet);
    }

}