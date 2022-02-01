package com.example.updatepassword;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class GirisYapActivity extends AppCompatActivity {

    private EditText kadi, sifre;
    Button giris;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_yap);

        tanimla();
        action();

    }

    public void tanimla()
    {
        auth = FirebaseAuth.getInstance();

        kadi = findViewById(R.id.kadi);
        sifre = findViewById(R.id.sifre);
        giris = findViewById(R.id.giris);
    }

    public void action()
    {
        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                girisYap(kadi.getText().toString() , sifre.getText().toString());
            }
        });
    }

    public void girisYap(String mail, String sifre)
    {
        auth.signInWithEmailAndPassword(mail, sifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Intent intent = new Intent(GirisYapActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}