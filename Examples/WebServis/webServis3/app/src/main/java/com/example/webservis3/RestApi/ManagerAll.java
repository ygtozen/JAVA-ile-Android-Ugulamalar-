package com.example.webservis3.RestApi;

import com.example.webservis3.Models.Bilgi;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourgetInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance()
    {
        return ourgetInstance;
    }

    public Call<List<Bilgi>> getirBilgi()
    {
        Call<List<Bilgi>> x = getRestApiClient().getir();
        return x;
    }

}
