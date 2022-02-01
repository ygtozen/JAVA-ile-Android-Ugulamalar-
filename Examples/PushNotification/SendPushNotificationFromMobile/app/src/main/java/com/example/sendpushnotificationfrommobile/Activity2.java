package com.example.sendpushnotificationfrommobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    private EditText mailEditText,codeEditText;
    private Button aktifEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        define();
    }

    public void define()
    {
        mailEditText = findViewById(R.id.mailEditText);
        codeEditText = findViewById(R.id.codeEditText);
        aktifEt = findViewById(R.id.aktifEt);

        mailEditText.setText(mailAl());

        aktifEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = mailEditText.getText().toString();
                String kod = codeEditText.getText().toString();
                request(mail,kod);
            }
        });
    }

    public void request(String mail,String code)
    {
        Call<Result> servis = ManagerAll.getOurInstance().aktifet(code,mail);
        servis.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

        Intent intent = new Intent(Activity2.this,Activity3.class);
        startActivity(intent);
    }

    public String mailAl()
    {
        String mail;
        Bundle bundle = getIntent().getExtras();
        mail = bundle.getString("mail");
        return mail;
    }



}