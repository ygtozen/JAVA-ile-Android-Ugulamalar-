package com.example.firebaseauth3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText kadi, pass;
    private Button userlogin;

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kadi = findViewById(R.id.usergmail);
        pass = findViewById(R.id.userpass);
        userlogin = findViewById(R.id.userlogin);

        auth = FirebaseAuth.getInstance();

        userlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gmailText = kadi.getText().toString();
                String passText = pass.getText().toString();

                if (!gmailText.equals("") && !passText.equals(""))
                {
                    loginUser(gmailText,passText);
                }

                kadi.setText("");
                pass.setText("");
            }
        });

    }

    // Giriş işlemi için
    private void loginUser(String gmail, String pass)
    {
        auth.signInWithEmailAndPassword(gmail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Intent intent = new Intent(MainActivity.this,UserActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Kullanıcı mail ve şifre hatalı",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}