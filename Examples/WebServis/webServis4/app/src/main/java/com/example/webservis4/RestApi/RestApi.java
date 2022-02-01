package com.example.webservis4.RestApi;

import com.example.webservis4.Models.Bilgi;
import com.example.webservis4.Models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {
    @GET("/comments")
    Call<List<Bilgi>> getir();

    @GET("/comments") Call<List<Result>> getirResult(@Query("postId") String postid, @Query("id") String id);
}
