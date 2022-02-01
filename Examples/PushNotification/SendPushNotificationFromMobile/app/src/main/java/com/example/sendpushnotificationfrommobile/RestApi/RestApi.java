package com.example.sendpushnotificationfrommobile.RestApi;

import com.example.sendpushnotificationfrommobile.Models.Result;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {
    @FormUrlEncoded
    @POST("/kayitol.php")
    Call<Result> addUser(@Field("kadi") String kadi, @Field("sifre") String sifre, @Field("mail") String mail);

    @FormUrlEncoded
    @POST("/kayitolaktif.php")
    Call<Result> aktifet(@Field("kod") String kod, @Field("mail") String mail);
}
