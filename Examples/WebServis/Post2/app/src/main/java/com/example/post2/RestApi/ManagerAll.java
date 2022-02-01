package com.example.post2.RestApi;

import com.example.post2.Models.Sonuc;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }

    public Call<Sonuc> ekle(String ad,String soyad)
    {
        Call<Sonuc> x = getRestApi().addUser(ad,soyad);
        return x;
    }
}
