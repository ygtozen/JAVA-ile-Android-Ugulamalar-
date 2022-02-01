package com.example.mailactivasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mailactivasyon.Models.Result;
import com.example.mailactivasyon.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView kullaniciAdiEditText,sifreEditText,mailadresEditText;
    private Button ekle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
    }

    public void tanimla()
    {
        kullaniciAdiEditText = findViewById(R.id.kullaniciAdiEditText);
        sifreEditText = findViewById(R.id.sifreEditText);
        mailadresEditText = findViewById(R.id.mailadresAdiEditText);
        ekle = findViewById(R.id.ekle);

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                istek();
            }
        });
    }

    public void istek()
    {
        String kullaniciAdi = kullaniciAdiEditText.getText().toString();
        String sifre =  sifreEditText.getText().toString();
        final String mailadres = mailadresEditText.getText().toString();
        if (!kullaniciAdi.equals("") && !sifre.equals("") && !mailadres.equals(""))
        {
            Call<Result> servis = ManagerAll.getInstance().ekle(kullaniciAdi,sifre,mailadres);
            servis.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    if (response.body().result)
                    {
                        /*Toast.makeText(getApplicationContext(),"Activasyon mailiniz" +
                                " gönderildi.",Toast.LENGTH_LONG).show();*/
                        Intent intent = new Intent(MainActivity.this,Activity2.class);
                        intent.putExtra("mailadres",mailadres);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Aynı kullanıcı adına veya mail" +
                                " adrese sahip kayıt var",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {

                }
            });
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Ekisk bilgi var",Toast.LENGTH_LONG).show();
        }
    }
}