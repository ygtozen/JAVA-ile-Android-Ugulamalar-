package com.example.webservis3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.webservis3.Adapters.BilgiAdapter;
import com.example.webservis3.Models.Bilgi;
import com.example.webservis3.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Bilgi> bilgiList;
    private ListView listView;
    private BilgiAdapter bilgiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        istek();
    }

    public void tanimla()
    {
        listView = findViewById(R.id.listView);
    }

    public void istek()
    {
        bilgiList = new ArrayList<>();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Bilgiler Ekranı");
        progressDialog.setMessage("İçerik yükleniyor. Lütfen bekleyiniz.");
        progressDialog.setCancelable(false);
        progressDialog.show();

        Call<List<Bilgi>> servis = ManagerAll.getInstance().getirBilgi();
        servis.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                if (response.isSuccessful())
                {
                    bilgiList = response.body();
                    bilgiAdapter = new BilgiAdapter(bilgiList,getApplicationContext());
                    listView.setAdapter(bilgiAdapter);
                    //Log.i("cevap",bilgiList.toString());
                    //Log.i("cevap",""+bilgiList.size());
                }

                progressDialog.cancel();
            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });
    }
}