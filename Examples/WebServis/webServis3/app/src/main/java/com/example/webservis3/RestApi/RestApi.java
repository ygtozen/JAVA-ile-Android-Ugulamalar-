package com.example.webservis3.RestApi;

import com.example.webservis3.Models.Bilgi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/photos")
    Call<List<Bilgi>> getir();
}
