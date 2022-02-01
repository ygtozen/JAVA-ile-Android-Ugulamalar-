package com.example.sendpushnotificationfrommobile.RestApi;

import com.example.sendpushnotificationfrommobile.Models.Result;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApi {
    @FormUrlEncoded
    @POST("/kayitol.php")
    Call<Result> addUser(@Field("kullaniciAdi") String kullaniciAdi, @Field("sifre") String sifre,
                         @Field("mail") String mail);

    @FormUrlEncoded
    @POST("/kayitolaktif.php")
    Call<Result> aktifEt(@Field("mail") String mail, @Field("kod") String kod);
}
