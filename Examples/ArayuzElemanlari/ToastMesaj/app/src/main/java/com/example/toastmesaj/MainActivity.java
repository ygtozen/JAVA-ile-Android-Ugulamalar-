package com.example.toastmesaj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button buttonDegistir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        islevVer();
    }

    public void tanimla(){
        imageView = findViewById(R.id.imageView);
        buttonDegistir = findViewById(R.id.buttonDegistir);
    }

    public void islevVer(){
        buttonDegistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = (int) (Math.random() * 4+1);

                degistir(random);

                Toast.makeText(getApplicationContext(),
                        random + " numaralı resim gösterildi",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public int degistir(int random){

        if (random == 1)
        {
            imageView.setImageResource(R.drawable.bir);
        }

        else if (random == 2)
        {
            imageView.setImageResource(R.drawable.iki);
        }

        if (random == 3)
        {
            imageView.setImageResource(R.drawable.uc);
        }

        if (random == 4)
        {
            imageView.setImageResource(R.drawable.dort);
        }

        /*else
        {
            imageView.setImageResource(R.drawable.bes);
        }*/

        return random;
    }
}