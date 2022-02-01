package com.example.webservis.RestApi;

import com.example.webservis.Models.Bilgiler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/posts")
    Call<List<Bilgiler>> bilgiGetir();
}
