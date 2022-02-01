package com.example.authdatabaseentegre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class KayitOlActivity extends AppCompatActivity {

    private EditText kadi, sifre;
    private Button kayitol;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);

        tanimla();
        action();

    }

    public void tanimla()
    {
        kadi = findViewById(R.id.kadi);
        sifre = findViewById(R.id.sifre);
        kayitol = findViewById(R.id.kayitol);

        auth = FirebaseAuth.getInstance();
    }

    // Bu metod'da buton'a tıklandığında sisteme kayıt olma fonk. çağıracak.
    public void action()
    {
        kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KayitOl(kadi.getText().toString() , sifre.getText().toString());
            }
        });
    }

    public void KayitOl(String kadi, String sifre)
    {
        // Kayıt olma fonk.
        auth.createUserWithEmailAndPassword(kadi, sifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"Başarılı.",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(KayitOlActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Başarısız.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}