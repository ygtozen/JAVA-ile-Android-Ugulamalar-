package com.example.activityornekuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityDetay extends AppCompatActivity {

    private TextView text1,text2,text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        tanimla();
        al();
    }

    public void tanimla()
    {
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
    }

    public void al()
    {
        Bundle bundle = getIntent().getExtras();

        String isim = bundle.getString("isim");
        String soysisim = bundle.getString("soyisim");
        String telNo = bundle.getString("telNo");

        text1.setText(isim);
        text2.setText(soysisim);
        text3.setText(telNo);
    }
}