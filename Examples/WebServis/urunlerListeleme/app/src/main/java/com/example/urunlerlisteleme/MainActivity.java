package com.example.urunlerlisteleme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.urunlerlisteleme.Adapters.UrunAdapter;
import com.example.urunlerlisteleme.Models.Urunler;
import com.example.urunlerlisteleme.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView urunlistView;
    private List<Urunler> urunlerList;
    private UrunAdapter urunAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        istek();
    }

    public void tanimla()
    {
        urunlistView = findViewById(R.id.urunlistView);
    }

    public void istek()
    {
        urunlerList = new ArrayList<>();

        Call<List<Urunler>> call = ManagerAll.getInstance().goster();
        call.enqueue(new Callback<List<Urunler>>() {
            @Override
            public void onResponse(Call<List<Urunler>> call, Response<List<Urunler>> response) {
                //Log.i("urunlerimiz",response.body().toString());
                if (response.isSuccessful())
                {
                    urunlerList = response.body();
                    urunAdapter = new UrunAdapter(urunlerList,getApplicationContext());
                    urunlistView.setAdapter(urunAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Urunler>> call, Throwable t) {

            }
        });
    }
}