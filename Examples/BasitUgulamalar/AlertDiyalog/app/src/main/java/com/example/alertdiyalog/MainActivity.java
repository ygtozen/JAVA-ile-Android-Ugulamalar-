package com.example.alertdiyalog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button dialogAc;
    private EditText kullanici, mailAdres, sifre;
    private Button buttonUyeOl,buttonIptal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
    }

    public void tanimla()
    {
        dialogAc = findViewById(R.id.dialogAc);
        dialogAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogAc();
            }
        });
    }

    public void alertDialogAc()
    {
        LayoutInflater inflater = getLayoutInflater();
        View itemView = inflater.inflate(R.layout.alert_layout,null);

        kullanici = itemView.findViewById(R.id.kullanici);
        mailAdres = itemView.findViewById(R.id.mailAdres);
        sifre = itemView.findViewById(R.id.sifre);
        buttonUyeOl = itemView.findViewById(R.id.buttonUyeOl);
        buttonIptal = itemView.findViewById(R.id.buttonIptal);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(itemView);
        alert.setCancelable(false);

        final AlertDialog dialog = alert.create();

        buttonUyeOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),mailAdres.getText().toString() + " "
                        + kullanici.getText().toString() + " " + sifre.getText().toString(),
                        Toast.LENGTH_SHORT).show();

                dialog.cancel();
            }
        });

        buttonIptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();
    }
}