package com.example.mesajgonderme2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<MesajModel> list;
    private MesajAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        listeOlustur();
    }

    public void tanimla()
    {
        listView = findViewById(R.id.listView);
    }



    public void listeOlustur()
    {
        list = new ArrayList<>();

        MesajModel m1 = new MesajModel("Yiğit","00000000000");
        MesajModel m2 = new MesajModel("Anıl","11111111111");
        MesajModel m3 = new MesajModel("Semih","22222222222");
        MesajModel m4 = new MesajModel("Zeynep","33333333333");
        MesajModel m5 = new MesajModel("Oğuz","44444444444");

        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);

        adapter = new MesajAdapter(list,this,this);

        listView.setAdapter(adapter);
    }
}