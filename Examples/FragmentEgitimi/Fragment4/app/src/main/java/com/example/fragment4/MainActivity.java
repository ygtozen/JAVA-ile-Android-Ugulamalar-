package com.example.fragment4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.button);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_tutucu, new BirinciFragment(), "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Fragment fragment = new BirinciFragment();
                Bundle bundle = new Bundle();
                bundle.putString("isim",editText.getText().toString());
                fragment.setArguments(bundle);*

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_tutucu, fragment, "fragment")
                        .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();*/

                ChangeFragment changeFragment = new ChangeFragment(MainActivity.this);
                changeFragment.change(new BirinciFragment(), editText.getText().toString());
            }
        });



    }
}