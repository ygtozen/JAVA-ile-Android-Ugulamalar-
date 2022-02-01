package com.example.post2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.post2.Models.Sonuc;
import com.example.post2.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText ad,soyad;
    private Button buttonEkle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        ekle();
    }

    public void tanimla()
    {
        ad = findViewById(R.id.ad);
        soyad = findViewById(R.id.soyad);
        buttonEkle = findViewById(R.id.buttonEkle);
    }

    public void ekle()
    {
        buttonEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isim = ad.getText().toString();
                String soyisim = soyad.getText().toString();
                if (!isim.equals("") && !soyisim.equals(""))
                {
                    istek(isim,soyisim);

                    ad.setText("");
                    soyad.setText("");
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Alanları doldurmak zorunludur",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void istek(String ad, String soyad)
    {
        Call<Sonuc> call = ManagerAll.getInstance().ekle(ad,soyad);
        call.enqueue(new Callback<Sonuc>() {
            @Override
            public void onResponse(Call<Sonuc> call, Response<Sonuc> response) {
                Toast.makeText(getApplicationContext(),response.body().getResult(),Toast.LENGTH_LONG).show();
                if (response.body().getResult().equals("Tebrikler ekleme basarilidir..."))
                {
                    Intent intent = new Intent(MainActivity.this,Activity2.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<Sonuc> call, Throwable t) {

            }
        });

    }
}