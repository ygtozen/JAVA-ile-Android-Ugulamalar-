package com.example.post1.RestApi;

import com.example.post1.Models.Result;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {
    @FormUrlEncoded
    @POST("/ekle.php")
    Call<Result> addUser(@Field("ad") String ad , @Field("soyad") String soyad);
}
