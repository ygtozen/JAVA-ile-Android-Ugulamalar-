package com.example.dbtojson;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.dbtojson.Adapters.DialogClass;
import com.example.dbtojson.Adapters.KullaniciAdapter;
import com.example.dbtojson.Models.Kullanici;
import com.example.dbtojson.Models.Result;
import com.example.dbtojson.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Kullanici> kullaniciList;
    private KullaniciAdapter kullaniciAdapter;
    private ListView listView;

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*DialogClass dialogClass = new DialogClass(MainActivity.this,MainActivity.this);
                dialogClass.goster(kullaniciList.get(position).getId());*/

                goster(kullaniciList.get(position).getId());
            }
        });
    }

    public void yenile()
    {
        istek();
    }

    public void istek()
    {
        kullaniciList = new ArrayList<>();

        Call<List<Kullanici>> x = ManagerAll.getInstance().goster();
        x.enqueue(new Callback<List<Kullanici>>() {
            @Override
            public void onResponse(Call<List<Kullanici>> call, Response<List<Kullanici>> response) {
                //Log.i("sonuc",response.body().toString());
                if (response.isSuccessful())
                {
                    kullaniciList = response.body();
                    kullaniciAdapter = new KullaniciAdapter(kullaniciList,getApplicationContext(),MainActivity.this);
                    listView.setAdapter(kullaniciAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Kullanici>> call, Throwable t) {

            }
        });
    }

    public void goster(final String id)
    {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout, null);

        Button iptal = view.findViewById(R.id.iptal);
        Button sil = view.findViewById(R.id.sil);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(view);
        alert.setCancelable(false);// ekranın herhangi bir yerine basıldığında kapanmaz
        final AlertDialog alertDialog = alert.create();

        iptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });

        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Result> sil = ManagerAll.getInstance().deleteFromDb(id);
                sil.enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        yenile();
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {

                    }
                });

                alertDialog.cancel();
            }
        });

        alertDialog.show();
    }
}