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

    private EditText kAdiEditText,kSifreEditText,kMailEditTex;
    private Button kayitol;
    private String kullaniciAdi,sifre,mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
    }

    public void tanimla()
    {
        kAdiEditText = findViewById(R.id.kullaniciAdiEditText);
        kSifreEditText = findViewById(R.id.kullaniciSifreEditText);
        kMailEditTex = findViewById(R.id.kullaniciMailEditText);
        kayitol = findViewById(R.id.kayitol);

        kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kullaniciAdi = kAdiEditText.getText().toString();
                sifre = kSifreEditText.getText().toString();
                mail = kMailEditTex.getText().toString();
                kayitOl(kullaniciAdi,sifre,mail);
            }
        });
    }

    public void kayitOl(String ad, String sifre, final String mail)
    {
        Call request = ManagerAll.getInstance().ekle(ad, sifre, mail);
        request.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                /*if (response.isSuccessful())
                {
                    Intent intent = new Intent(MainActivity.this,Activity2.class);
                    intent.putExtra("mail",mail);
                    startActivity(intent);
                }*/
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
        Intent intent = new Intent(MainActivity.this,Activity2.class);
        intent.putExtra("mail",mail);
        startActivity(intent);
    }
}