package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<KullaniciModel> kullaniciList;
    KullaniciListAdapter kullaniciListAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        listeDoldur();
    }

    public void tanimla()
    {
        listView = findViewById(R.id.listView);
    }

    public void listeDoldur()
    {
        kullaniciList = new ArrayList<>();

        KullaniciModel k1 = new KullaniciModel("Murat","Koç","30","X");
        KullaniciModel k2 = new KullaniciModel("Yiğit","Özen","22","K");
        KullaniciModel k3 = new KullaniciModel("Barış","Mert","19","T");
        KullaniciModel k4 = new KullaniciModel("Semih","Karaman","21","Y");

        kullaniciList.add(k1);
        kullaniciList.add(k2);
        kullaniciList.add(k3);
        kullaniciList.add(k4);

        kullaniciListAdapter = new KullaniciListAdapter(kullaniciList,this);

        listView.setAdapter(kullaniciListAdapter);
    }
}