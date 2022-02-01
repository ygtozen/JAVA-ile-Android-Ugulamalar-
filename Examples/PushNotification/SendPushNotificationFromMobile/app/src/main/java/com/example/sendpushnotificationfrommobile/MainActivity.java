package com.example.sendpushnotificationfrommobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sendpushnotificationfrommobile.Models.Result;
import com.example.sendpushnotificationfrommobile.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText txt_kullanici,txt_sifre,txt_mail;
    private Button kayitOl;
    private String kullaniciadi, sifre, mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        define();
    }

    public void define()
    {
        txt_kullanici = findViewById(R.id.txt_kullaniciadi);
        txt_sifre = findViewById(R.id.txt_sifre);
        txt_mail = findViewById(R.id.txt_mail);
        kayitOl = findViewById(R.id.kayitOl);

        kayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kullaniciadi = txt_kullanici.getText().toString();
                sifre = txt_sifre.getText().toString();
                mail = txt_mail.getText().toString();
                request(kullaniciadi,sifre,mail);
            }
        });
    }

    public void request(String ad, String sifre, String mail)
    {
        Call<Result> servis = ManagerAll.getOurInstance().ekle(ad, sifre, mail);
        servis.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        // Result'un içi boşolduğu için yukarıda değil burada yazdım.
        Intent intent = new Intent(MainActivity.this,Activity2.class);
        intent.putExtra("mail",mail);
        startActivity(intent);
    }
}