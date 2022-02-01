package com.example.post1.RestApi;

import com.example.post1.Models.Result;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }

    public Call<Result> ekle(String ad, String soyad)
    {
        Call<Result> x = getRestApi().addUser(ad,soyad);
        return x;
    }
}
