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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SifreDegistir extends AppCompatActivity {

    private EditText sifreYeni;
    private Button btn_degistir;

    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifre_degistir);

        tanimla();
    }

    public void tanimla()
    {
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        sifreYeni = findViewById(R.id.sifreYeni);
        btn_degistir = findViewById(R.id.btn_degistir);

        btn_degistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degis(sifreYeni.getText().toString());
            }
        });
    }

    public void degis(String newPass)
    {
        user.updatePassword(newPass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Intent intent = new Intent(SifreDegistir.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}