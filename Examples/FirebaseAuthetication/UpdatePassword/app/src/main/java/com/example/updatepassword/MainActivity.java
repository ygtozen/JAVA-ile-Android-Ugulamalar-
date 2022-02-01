package com.example.updatepassword;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    // ozenyigit151@gmail.com --> şifre 19981998


    FirebaseAuth auth;
    FirebaseUser user;

    private Button cikis , sifreDegistir, emailDogrula, resetPass, hesapSil;
    private TextView emailKontrol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();

        if (user == null) // Eğerki kullancı yoksa
        {
            Intent intent = new Intent(MainActivity.this,GirisYapActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Log.i("kullanici", user.getUid());


            cikis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    auth.signOut(); // Kullanıcıyı sitemden çıkartır
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

            sifreDegistir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SifreDegistir.class);
                    startActivity(intent);
                    finish();
                }
            });

            emailKontrol.setText("" + user.isEmailVerified()); // Email dorğulanmışmı ona bakar
            emailDogrula.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    emaildogrula();
                }
            });

            resetPass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Reset();
                }
            });

            hesapSil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Sil();
                }
            });

        }

    }

    public void tanimla()
    {
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        cikis = findViewById(R.id.cikis);
        sifreDegistir = findViewById(R.id.sifreDegistir);
        emailKontrol = findViewById(R.id.emailKontrol);
        emailDogrula = findViewById(R.id.emailDogrula);
        resetPass = findViewById(R.id.resetPass);
        hesapSil = findViewById(R.id.hesapSil);
    }

    public void emaildogrula()
    {
        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });
    }

    // Şifre sıfırlama linki gönderme
    public void Reset()
    {
        auth.sendPasswordResetEmail(user.getEmail()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(getApplicationContext(),"Link gönderildi.",Toast.LENGTH_LONG).show();
            }
        });
    }


    // Hesabı Sil
    public void Sil()
    {
        user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}