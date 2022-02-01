package com.example.authdatabaseentegre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    private TextView bilgiText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();

        // Kullanıcı varmı diye bakar eğer null'sa yani yoksa kayıtol activty'ye gönderir.
        if (user == null)
        {
            Intent intent = new Intent(MainActivity.this,KayitOlActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Log.i("kullanici",user.getUid());
        }

    }

    public void tanimla()
    {
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        bilgiText = findViewById(R.id.bilgiText);

        bilgiText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BilgiEkleActivity.class);
                startActivity(intent);
            }
        });
    }
}