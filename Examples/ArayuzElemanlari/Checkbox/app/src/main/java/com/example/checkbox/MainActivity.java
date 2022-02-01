package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox php,java,python,csharp,js;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        mesajVer();
    }

    public void tanimla()
    {
        php = findViewById(R.id.php);
        java = findViewById(R.id.java);
        python = findViewById(R.id.python);
        csharp = findViewById(R.id.csharp);
        js = findViewById(R.id.js);
    }

    public void mesajVer()
    {
        php.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (php.isChecked())
                {
                    Toast.makeText(getApplicationContext(),php.getText() + " seçildi.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),php.getText() + " iptal edildi.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (java.isChecked())
                {
                    Toast.makeText(getApplicationContext(),java.getText() + " seçildi.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),java.getText() + " iptal edildi.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (python.isChecked())
                {
                    Toast.makeText(getApplicationContext(),python.getText() + " seçildi.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),python.getText() + " iptal edildi.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        csharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csharp.isChecked())
                {
                    Toast.makeText(getApplicationContext(),csharp.getText() + " seçildi.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),csharp.getText() + " iptal edildi.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (js.isChecked())
                {
                    Toast.makeText(getApplicationContext(),js.getText() + " seçildi.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),js.getText() + " iptal edildi.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}