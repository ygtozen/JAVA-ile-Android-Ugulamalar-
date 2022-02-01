package com.example.mailactivasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mailactivasyon.Models.Result;
import com.example.mailactivasyon.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity2 extends AppCompatActivity {

    private EditText mailadresEditText,codeEditText;
    private Button aktifet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tanimla();
    }

    public void tanimla()
    {
        mailadresEditText = findViewById(R.id.mailadresEditText);
        codeEditText = findViewById(R.id.codeEditText);
        aktifet = findViewById(R.id.aktifet);
        mailadresEditText.setText(mailAdresAl());

        aktifet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                istekAktifEt();
            }
        });
    }

    public String mailAdresAl()
    {
        String mailAdresi;
        Bundle bundle = getIntent().getExtras();
        mailAdresi = bundle.getString("mailadres");
        return mailAdresi;
    }

    public void istekAktifEt()
    {
        String mail , code;
        mail = mailAdresAl();
        code = codeEditText.getText().toString();
        Call<Result> servis = ManagerAll.getInstance().aktifEt(mail,code);
        servis.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (response.body().result)
                {
                    Intent intent = new Intent(Activity2.this,MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Mail zaten aktif veya hatalı kod girildi.",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }
}