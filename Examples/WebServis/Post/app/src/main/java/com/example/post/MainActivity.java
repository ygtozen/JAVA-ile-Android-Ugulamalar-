package com.example.post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.post.Models.Result;
import com.example.post.RestApi.ManagerAll;

import java.util.List;

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
                deleteFromEdittext();
            }
        });
    }
    public void deleteFromEdittext()
    {
        ad.setText("");
        soyad.setText("");
    }

    public void istek(String ad,String soyad)
    {
        Call<Result> x = ManagerAll.getInstance().ekle(ad,soyad);
        x.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                    Toast.makeText(getApplicationContext(),"basarili",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }
}