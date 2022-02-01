package com.example.firebaseauth2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        if (user == null) // Kullanıcı boş ise
        {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), user.getUid(),Toast.LENGTH_LONG).show();
        }
    }
}