package com.example.parametreliservisyazma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parametreliservisyazma.Models.Uyebilgileri;
import com.example.parametreliservisyazma.RestApi.BaseUrl;
import com.example.parametreliservisyazma.RestApi.ManagerAll;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetayActivity extends AppCompatActivity {

    private String id;
    private TextView uyeIsim,uyeOkul,uyeMailAdres,uyeYas;
    private ImageView uyeResim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        tanimla();
        idAl();
        istekAt();
    }

    public void tanimla()
    {
        uyeIsim = findViewById(R.id.uyeIsim);
        uyeOkul = findViewById(R.id.uyeOkul);
        uyeMailAdres = findViewById(R.id.uyeMailAdres);
        uyeYas = findViewById(R.id.uyeYas);
        uyeResim = findViewById(R.id.uyeResim);
    }

    public void idAl()
    {
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("idDeger");
    }

    public void istekAt()
    {
        Call<Uyebilgileri> servis = ManagerAll.getInstance().getir(id);
        servis.enqueue(new Callback<Uyebilgileri>() {
            @Override
            public void onResponse(Call<Uyebilgileri> call, Response<Uyebilgileri> response) {
                //Log.i("sonucc",response.body().toString());
                uyeIsim.setText("Üye ismi : " + response.body().getUyeisim());
                uyeOkul.setText("Okul : " + response.body().getUyeokul());
                uyeMailAdres.setText("Mail Adres : " + response.body().getUyemailadres());
                uyeYas.setText("Yaş : " + response.body().getUyeyas());
                Picasso.get().load(BaseUrl.Adres + "/resimler/" + response.body().getUyeresim()).into(uyeResim);
            }

            @Override
            public void onFailure(Call<Uyebilgileri> call, Throwable t) {

            }
        });
    }
}