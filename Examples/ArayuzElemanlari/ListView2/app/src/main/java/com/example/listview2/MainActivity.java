package com.example.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<MesajModel> mesajModels;
    MesajAdapter mesajAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        listeDoldur();
    }

    public void tanimla()
    {
        listView = (ListView) findViewById(R.id.listView);
    }

    public void listeDoldur()
    {
        mesajModels = new ArrayList<>();

        MesajModel m1 = new MesajModel("Merhaba ben Niloya","Niloya",R.drawable.niloya);
        MesajModel m2 = new MesajModel("Merhaba ben Murat","Murat",R.drawable.murat);
        MesajModel m3 = new MesajModel("Merhaba ben Mete","Mete",R.drawable.mete);

        mesajModels.add(m1);
        mesajModels.add(m2);
        mesajModels.add(m3);

        mesajAdapter = new MesajAdapter(mesajModels,this);

        listView.setAdapter(mesajAdapter);
    }
}