package com.example.webservis4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.webservis4.Adapters.BilgiAdapter;
import com.example.webservis4.Models.Bilgi;
import com.example.webservis4.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Bilgi> list;
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
        list = new ArrayList<>();

        Call<List<Bilgi>> call = ManagerAll.getInstance().getirCall();
        call.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                //Log.i("deneme",response.body().toString());
                //Log.i("deneme",response.body().get(0).getEmail()); 0. elemanın e maili gelir
                if (response.isSuccessful())
                {
                    list = response.body();
                    bilgiAdapter = new BilgiAdapter(list,getApplicationContext(),MainActivity.this);
                    listView.setAdapter(bilgiAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });
    }
}