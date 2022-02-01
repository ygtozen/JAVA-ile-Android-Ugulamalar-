package com.example.post2.RestApi;

import com.example.post2.Models.Sonuc;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {
    @FormUrlEncoded
    @POST("/sartli_ekle.php")
    Call<Sonuc> addUser(@Field("ad") String ad, @Field("soyad") String soyad);
}
