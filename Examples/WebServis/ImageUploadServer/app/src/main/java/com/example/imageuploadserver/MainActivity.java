package com.example.imageuploadserver;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.imageuploadserver.Models.Result;
import com.example.imageuploadserver.RestApi.ManagerAll;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText resimBaslik;
    private Button resimSec,resimGonder;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        islem();
    }

    public void tanimla() {
        resimSec = (Button) findViewById(R.id.resimSec);
        resimGonder = (Button) findViewById(R.id.resimGonder);
        imageView = (ImageView) findViewById(R.id.imageView);
        resimBaslik = (EditText) findViewById(R.id.resimBaslik);

    }

    public void islem() {
        resimSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resimGoster();
            }
        });
        resimGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gonder();
            }
        });
    }

    public void gonder() {
        // Seçilen resmin sunucuya kayıt edilmesi işlemi.
        String resimbasligi = resimBaslik.getText().toString();
        String imageToString = imageToString();
        Log.i("imageToString", imageToString);
        Log.i("imageToString", "" + imageToString.length());
        Call<Result> x = ManagerAll.getInstance().gonder(resimbasligi, imageToString);
        x.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Toast.makeText(getApplicationContext(), response.body().getResult(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }

    public void resimGoster() {
        Intent ıntent = new Intent();
        ıntent.setType("image/*");
        ıntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(ıntent, 777);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 777 && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                imageView.setImageBitmap(bitmap);
                imageView.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Imageview de resmi gösterme kodu
        }
    }

    public String imageToString() {
        // Resmi Stringe dönüştürme kodu.
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byt = byteArrayOutputStream.toByteArray();
        String imageToString = Base64.encodeToString(byt, Base64.DEFAULT); // Android.util olanı seç
        return imageToString;
    }
}