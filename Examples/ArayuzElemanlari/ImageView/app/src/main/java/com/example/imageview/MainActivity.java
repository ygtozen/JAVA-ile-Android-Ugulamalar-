package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button buttonDegistir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        tiklama();
    }

    public void tanimla(){
        imageView = findViewById(R.id.imageView);
        buttonDegistir = findViewById(R.id.buttonDegistir);
    }

    public void tiklama(){

        buttonDegistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int random = (int) (Math.random() * 5 + 1); // 1 - 5 arasında rastgele sayı üretme
                System.out.println(random);
                degistir(random);
            }
        });

    }

    public void degistir(int sayi){
        if (sayi == 1)
        {
            imageView.setImageResource(R.drawable.bir);
        }

        else if (sayi == 2)
        {
            imageView.setImageResource(R.drawable.iki);
        }

        else if (sayi == 3)
        {
            imageView.setImageResource(R.drawable.uc);
        }

        else if (sayi == 4)
        {
            imageView.setImageResource(R.drawable.dort);
        }

        else
        {
            imageView.setImageResource(R.drawable.bes);
        }
    }
}