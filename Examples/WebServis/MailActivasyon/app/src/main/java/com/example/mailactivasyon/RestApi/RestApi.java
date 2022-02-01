package com.example.mailactivasyon.RestApi;

import com.example.mailactivasyon.Models.Result;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {
    @FormUrlEncoded
    @POST("/mailgonder.php")
    Call<Result> addUser(@Field("kullaniciAdi") String kullaniciAdi,@Field("sifre") String sifre,
                         @Field("mailadres") String mailadres);


    @GET("/aktifet.php")
    Call<Result> aktifEt(@Query("mail") String mail,@Query("code") String code);
}
