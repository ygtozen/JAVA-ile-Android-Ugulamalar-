package com.example.progresbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogVer();
    }

    public void dialogVer()
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Mesajlar Bölümü");
        progressDialog.setMessage("Mesajlar Listeleniyor , Lütfen Bekleyin ! ");
        progressDialog.setCancelable(false);// iptal edilebilirliği kapatıyor , sebebi bir dialogu arka planda işlemler bitene kadar göstermek istiyoruz .
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(20000);
                }catch (Exception e )
                {
                    e.printStackTrace();
                }
                progressDialog.cancel();
            }
        }).start();
    }

    /*public void dialogVer()
    {
        final ProgressDialog progressDialog = new ProgressDialog(getApplicationContext());
        progressDialog.setTitle("Mesajlar Bölümü");
        progressDialog.setMessage("Mesajlar listeleniyor , lütefn bekleyin.");
        progressDialog.setCancelable(false); // iptal edilebilirliği kapatır.
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                progressDialog.cancel();
            }
        }).start();
    }*/
}