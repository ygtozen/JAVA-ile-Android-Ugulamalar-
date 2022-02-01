package com.example.mesajgonderme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MesajModel> list;
    private ListView listView;

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

        MesajAdapter adapter = new MesajAdapter(list,this,this);

        listView.setAdapter(adapter);
    }

    public void listeDoldur()
    {
        //mesajModels = new ArrayList<>();

        /*MesajModel m1 = new MesajModel("Yiğit","00000000000");
        MesajModel m2 = new MesajModel("Semih","11111111111");
        MesajModel m3 = new MesajModel("Anıl","22222222222");
        MesajModel m4 = new MesajModel("Zeynep","33333333333");
        MesajModel m5 = new MesajModel("Umut","44444444444");

        mesajModels.add(m1);
        mesajModels.add(m2);
        mesajModels.add(m3);
        mesajModels.add(m4);
        mesajModels.add(m5);*/

        list = new ArrayList<>();
        MesajModel m1 = new MesajModel("murat","00000000000");
        MesajModel m2 = new MesajModel("basar","11111111111");
        MesajModel m3 = new MesajModel("ege","22222222222");
        MesajModel m4 = new MesajModel("tamer","33333333333");
        MesajModel m5 = new MesajModel("erdi","44444444444");

        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
    }


}