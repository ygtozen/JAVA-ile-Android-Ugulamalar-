package com.example.webservis2.RestApi;

import com.example.webservis2.Models.Bilgi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/todos")
    Call<List<Bilgi>> getir();
}
