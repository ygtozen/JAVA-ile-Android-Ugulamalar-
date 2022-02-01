package com.example.urunlerlisteleme.RestApi;

import com.example.urunlerlisteleme.Models.Urunler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/urunler.php")
    Call<List<Urunler>> listele();
}
