package com.example.parametreliservisyazma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parametreliservisyazma.Models.Uye;
import com.example.parametreliservisyazma.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText,passwordEditText;
    private Button buttonGirisYap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        istekAt();
    }

    public void tanimla()
    {
        usernameEditText = findViewById(R.id.userNameEdittex);
        passwordEditText = findViewById(R.id.passwordEdittex);
        buttonGirisYap = findViewById(R.id.buttonGirisYap);
    }

    public void istekAt()
    {
        buttonGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                Call<Uye> servis = ManagerAll.getInstance().giris(username,password);
                servis.enqueue(new Callback<Uye>() {
                    @Override
                    public void onResponse(Call<Uye> call, Response<Uye> response) {
                        if (response.isSuccessful()) {
                            //Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_LONG).show();
                            String idDeger = response.body().getId();
                            Intent intent = new Intent(MainActivity.this,DetayActivity.class);
                            intent.putExtra("idDeger",idDeger);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Uye> call, Throwable t) {
                        //tabloda böyle bir kullanıcı yoksa buraya düşer
                        Toast.makeText(getApplicationContext(),"Bilgilerinizi kontrol edin.",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}