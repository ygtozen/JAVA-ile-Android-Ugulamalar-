package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<MesajModel> modelList;
    RecyclerView.LayoutManager layoutManager;
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
        recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void listeDoldur()
    {
        modelList = new ArrayList<>();

        MesajModel murat = new MesajModel("Murat","Merhaba ben Murat",R.drawable.murat);
        MesajModel mete = new MesajModel("Mete","Merhaba ben Mete",R.drawable.mete);
        MesajModel niloya = new MesajModel("Niloya","Merhaba ben Niloya",R.drawable.niloya);

        modelList.add(murat);
        modelList.add(mete);
        modelList.add(niloya);

        mesajAdapter = new MesajAdapter(modelList,this);

        recyclerView.setAdapter(mesajAdapter);
    }
}