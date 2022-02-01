package com.example.activitylerarasiverialma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText editTextKullanici,editTextSifre;
    private RadioGroup cinsiyetGrup;
    private Button buttonGonder;

    private String kullaniciAdi,kullaniciSifre,kullaniciCinsiyet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        tiklaveGec();
    }

    public void tanimla()
    {
        editTextKullanici = findViewById(R.id.editTextKullanici);
        editTextSifre = findViewById(R.id.editTextSifre);
        cinsiyetGrup = findViewById(R.id.cinsiyetGrup);
        buttonGonder = findViewById(R.id.buttonGonder);
    }

    public void degerAl()
    {
        kullaniciAdi = editTextKullanici.getText().toString();
        kullaniciSifre = editTextSifre.getText().toString();
        kullaniciCinsiyet = ((RadioButton) findViewById(cinsiyetGrup.getCheckedRadioButtonId())).getText().toString();
    }

    public void tiklaveGec()
    {
        buttonGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degerAl();
                //Log.i("Deger","" + kullaniciAdi + " " + kullaniciSifre + " " + kullaniciCinsiyet);

                Intent intent = new Intent(getApplicationContext(),ActivityB.class);
                intent.putExtra("kullaniciAdi",kullaniciAdi);
                intent.putExtra("kullaniciSifre",kullaniciSifre);
                intent.putExtra("kullaniciCinsiyet",kullaniciCinsiyet);
                startActivity(intent);
            }
        });
    }
}