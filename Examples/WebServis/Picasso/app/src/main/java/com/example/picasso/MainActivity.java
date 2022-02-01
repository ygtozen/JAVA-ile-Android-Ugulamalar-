package com.example.picasso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        resimCek();
    }

    public void tanimla()
    {
        imageView = findViewById(R.id.imageView);
    }

    public void resimCek()
    {
        Picasso.with(getApplicationContext()).load("https://www.google.com.tr/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png").into(imageView);
    }
}