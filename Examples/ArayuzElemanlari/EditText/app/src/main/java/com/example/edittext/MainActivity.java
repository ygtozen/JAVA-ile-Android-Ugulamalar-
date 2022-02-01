package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextGirdi;
    Button buttonHesapla;
    TextView textViewSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        tiklama();
    }

    private void tanimla(){
        editTextGirdi = (EditText) findViewById(R.id.editTextGirdi);
        buttonHesapla = findViewById(R.id.buttonHesapla);
        textViewSonuc = findViewById(R.id.textViewSonuc);
    }

    private void tiklama(){

        buttonHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gelenDeger = editTextGirdi.getText().toString();
                int faktoriyelHesaplanacakSayi = Integer.parseInt(gelenDeger); // değeri integer yaptık

                int faktoriyel = hesapla(faktoriyelHesaplanacakSayi);

                textViewSonuc.setText("Sonuc : " + faktoriyel);
            }
        });
    }

    private int hesapla(int sayi){

        int sonuc = 1;
        int a = 1;

        for (int i = sayi; i > 1; i--){
            sonuc = sonuc * i;
        }

        return sonuc;
    }

}