package com.example.activityornekuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Model> modelList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listeOlustur();
        gec();
    }

    public void listeOlustur()
    {
        modelList = new ArrayList<>();

        Model m1 = new Model("Yiğit", "Özen", "0534");
        Model m2 = new Model("Semih", "Karaman", "0535");
        Model m3 = new Model("Anıl", "Fırıncı", "0536");
        Model m4 = new Model("Oğuzhan", "Ünsal", "0534");

        modelList.add(m1);
        modelList.add(m2);
        modelList.add(m3);
        modelList.add(m4);

    }

    public void gec()
    {
        listView = findViewById(R.id.listView);
        AdapterModel adapterModel = new AdapterModel(modelList,this,this);

        listView.setAdapter(adapterModel);
    }
}