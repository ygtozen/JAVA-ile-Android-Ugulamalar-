package com.example.fragment6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);

        ChangeFragment changeFragment = new ChangeFragment(MainActivity.this);
        changeFragment.change(new BirinciFragment());

        // Static değişkenlerle veri gönderme
        /*if (!Kisi.ad.equals(""))
        {
            textView.setText(Kisi.ad);
        }*/


        //Bundle bundle = getIntent().getExtras();
        //String isim = bundle.getString("isim);
        //textView.setText(isim);

        if (getIntent().getExtras() != null)
        {
            String isim = getIntent().getExtras().getString("isim").toString();
            textView.setText(isim);
        }


    }
}