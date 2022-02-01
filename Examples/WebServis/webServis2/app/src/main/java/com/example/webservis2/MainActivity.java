package com.example.webservis2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.webservis2.Adapters.BilgiAdapter;
import com.example.webservis2.Models.Bilgi;
import com.example.webservis2.RestApi.ManagerAll;

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

        Call<List<Bilgi>> listCall = ManagerAll.getOurInstance().getirBilgi();
        listCall.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                if (response.isSuccessful())
                {
                    bilgiList = response.body();
                    bilgiAdapter = new BilgiAdapter(bilgiList,getApplicationContext());
                    listView.setAdapter(bilgiAdapter);
                    //Log.i("gelenList",bilgiList.toString());
                    //Log.i("gelenList",""+bilgiList.size());
                }
            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });
    }
}