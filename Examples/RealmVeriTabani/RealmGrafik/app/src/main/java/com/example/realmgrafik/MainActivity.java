package com.example.realmgrafik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    Realm realm;
    private EditText buyukTansiyon, kucukTansiyon;
    private Button buttonEkle;
    private BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RealmTanimla();
        tanimla();
        ekle();
        goster();
        listele();
        sil();
    }

    public void RealmTanimla() {
        realm = Realm.getDefaultInstance();
    }

    public void tanimla() {
        buyukTansiyon = findViewById(R.id.buyukTansiyon);
        kucukTansiyon = findViewById(R.id.kucukTansiyon);
        buttonEkle = findViewById(R.id.buttonEkle);
        barChart = findViewById(R.id.barChart);
    }

    public void ekle() {
        buttonEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Tansiyon tansiyon = realm.createObject(Tansiyon.class);
                        tansiyon.setBuyukTansiyon(buyukTansiyon.getText().toString());
                        tansiyon.setKucukTansiyon(kucukTansiyon.getText().toString());
                    }
                });
                listele();
                goster();
            }
        });
    }

    public void listele() {
        RealmResults<Tansiyon> list = realm.where(Tansiyon.class).findAll();

        for (Tansiyon t : list) {
            Log.i("tansiyon", t.toString());
        }
    }

    public void goster() {
        RealmResults<Tansiyon> tansiyon = realm.where(Tansiyon.class).findAll();
        Float buyuk_tansiyon = 0.f;
        Float kucuk_tansiyon = 0.f;

        for (int i=0; i < tansiyon.size(); i++)
        {
            buyuk_tansiyon = buyuk_tansiyon + Float.parseFloat(tansiyon.get(i).getBuyukTansiyon());
            kucuk_tansiyon = kucuk_tansiyon + Float.parseFloat(tansiyon.get(i).getBuyukTansiyon());
        }


        ArrayList<BarEntry> arrayList = new ArrayList<>();
        arrayList.add(new BarEntry(buyuk_tansiyon, 0));
        arrayList.add(new BarEntry(kucuk_tansiyon, 1));
        BarDataSet barDataSet = new BarDataSet(arrayList, "Toplam Değer");

        ArrayList<String> sutunAd = new ArrayList<>();
        sutunAd.add("Büyük Tansiyon");
        sutunAd.add("Küçük Tansiyon");

        BarData barData = new BarData(sutunAd, barDataSet);
        barChart.setData(barData);
        barChart.setDescription("Tansiyon Değerlerini Gösteren Grafik Arayüzüdür");
    }

    public void sil()
    {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<Tansiyon> tansiyon = realm.where(Tansiyon.class).findAll();
                tansiyon.deleteFromRealm(2);
            }
        });
    }
}