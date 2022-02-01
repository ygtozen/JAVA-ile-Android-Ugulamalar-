package com.example.firebase2auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText gmail, password;
    Button kayitol;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gmail = findViewById(R.id.gmail);
        password = findViewById(R.id.password);
        kayitol = findViewById(R.id.kayitol);

        auth = FirebaseAuth.getInstance();

        kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kadi = gmail.getText().toString();
                String sifre = password.getText().toString();
                if (!kadi.equals("") && !sifre.equals("")) {
                    kayitOl(kadi, sifre);

                    gmail.setText("");
                    password.setText("");
                }
            }
        });

    }

    public void kayitOl(String kad, String sifre)
    {
        auth.createUserWithEmailAndPassword(kad , sifre).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),
                            "Kayıt işlemi başarılı.", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),
                            "Bir hata meydana geldi , bilgileri kontrol ediniz.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}