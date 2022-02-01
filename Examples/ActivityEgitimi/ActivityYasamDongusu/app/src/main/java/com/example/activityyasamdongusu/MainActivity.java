package com.example.activityyasamdongusu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("takip","onCreate metodu çalıştı.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("takip","onStar metodu çalıştı.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("takip","onResume metodu çalıştı.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("takip","onPause metodu çalıştı.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("takip","onRestart metodu çalıştı.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("takip","onStop metodu çalıştı.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("takip","onDestroy metodu çalıştı.");
    }
}