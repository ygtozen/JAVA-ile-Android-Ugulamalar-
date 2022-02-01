package com.example.sendpushnotificationfrommobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sendpushnotificationfrommobile.Models.Result;
import com.example.sendpushnotificationfrommobile.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity2 extends AppCompatActivity {

    private EditText mailEditTex,kodEditText;
    private Button aktifEt;
    private String gelenMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tanimla();
    }

    public void tanimla()
    {
        mailEditTex = findViewById(R.id.mailEditText);
        kodEditText = findViewById(R.id.kodEditText);
        aktifEt = findViewById(R.id.aktifEt);

        mailEditTex.setText(mailAl());
        aktifEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gelenMail = mailEditTex.getText().toString();
                String gelenKod = kodEditText.getText().toString();
                istekAt(gelenMail,gelenKod);
            }
        });
    }

    public void istekAt(String gelenMail,String gelenKod)
    {
        Call<Result> request = ManagerAll.getInstance().aktifEt(gelenMail,gelenKod);
        request.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }

    public String mailAl()
    {
        Bundle bundle = getIntent().getExtras();
        gelenMail = bundle.getString("mail");
        return gelenMail;
    }
}