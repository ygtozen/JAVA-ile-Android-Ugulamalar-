package com.example.post.RestApi;

import com.example.post.Models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApi {
    @POST("/ekle.php")
    @FormUrlEncoded
    Call<Result> addUser(@Field("ad") String ad, @Field("soyad") String soyad);
}
