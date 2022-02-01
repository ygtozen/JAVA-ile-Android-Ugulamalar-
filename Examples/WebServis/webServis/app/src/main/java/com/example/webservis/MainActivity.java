package com.example.webservis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.webservis.Adapter.BilgiAdapter;
import com.example.webservis.Models.Bilgiler;
import com.example.webservis.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Bilgiler> list;
    private ListView listView;
    private BilgiAdapter adapter;

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

        Call<List<Bilgiler>> bilgList = ManagerAll.getInstance().getirBilgileri();
        bilgList.enqueue(new Callback<List<Bilgiler>>() {
            @Override
            public void onResponse(Call<List<Bilgiler>> call, Response<List<Bilgiler>> response) {
                if (response.isSuccessful())
                {
                    list = response.body(); // json çıktısını list imize atadık
                    adapter = new BilgiAdapter(list,getApplicationContext());
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Bilgiler>> call, Throwable t) {
            }
        });
    }
}