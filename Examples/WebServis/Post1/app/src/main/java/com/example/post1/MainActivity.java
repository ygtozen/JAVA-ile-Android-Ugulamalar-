package com.example.post1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.post1.Models.Result;
import com.example.post1.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView ad,soyad;
    private Button buttonEkle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        add();
    }

    public void tanimla()
    {
        ad = findViewById(R.id.ad);
        soyad = findViewById(R.id.soyad);
        buttonEkle = findViewById(R.id.buttonEkle);
    }

    public void add()
    {
        buttonEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isim = ad.getText().toString();
                String soyisim = soyad.getText().toString();
                istek(isim,soyisim);
                deleteFromEditText();
            }
        });
    }

    public void deleteFromEditText()
    {
        ad.setText("");
        soyad.setText("");
    }

    public void istek(String ad,String soyad)
    {
        Call<Result> call = ManagerAll.getInstance().ekle(ad,soyad);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Toast.makeText(getApplicationContext(),"Basarili",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }
}