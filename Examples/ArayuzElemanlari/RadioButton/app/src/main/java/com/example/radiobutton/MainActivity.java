package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton resim1, resim2, resim3, resim4;
    ImageView imageView;
    Button buttonDegistir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        idAl();
    }

    public void tanimla()
    {
        radioGroup = findViewById(R.id.radioGrup);
        resim1 = findViewById(R.id.resim1);
        resim2 = findViewById(R.id.resim2);
        resim3 = findViewById(R.id.resim3);
        resim4 = findViewById(R.id.resim4);
        buttonDegistir = findViewById(R.id.buttonDegistir);
    }

    public void idAl()
    {
        buttonDegistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gelenId = radioGroup.getCheckedRadioButtonId();
                resimDegistir(gelenId);
            }
        });
    }

    public void resimDegistir(int id)
    {
        if (id == R.id.resim1)
        {
            imageView.setImageResource(R.drawable.bir);
            Toast.makeText(getApplicationContext(),resim1.getText(),Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.resim2)
        {
            imageView.setImageResource(R.drawable.iki);
            Toast.makeText(getApplicationContext(),resim2.getText(),Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.resim3)
        {
            imageView.setImageResource(R.drawable.uc);
            Toast.makeText(getApplicationContext(),resim3.getText(),Toast.LENGTH_SHORT).show();
        }

        if (id == R.id.resim4)
        {
            imageView.setImageResource(R.drawable.dort);
            Toast.makeText(getApplicationContext(),resim4.getText(),Toast.LENGTH_SHORT).show();
        }

    }
}