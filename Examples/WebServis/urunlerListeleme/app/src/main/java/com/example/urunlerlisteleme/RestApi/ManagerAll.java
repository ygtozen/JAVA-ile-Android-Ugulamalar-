package com.example.urunlerlisteleme.RestApi;

import com.example.urunlerlisteleme.Models.Urunler;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }

    public Call<List<Urunler>> goster()
    {
        Call<List<Urunler>> x = getRestApi().listele();
        return x;
    }

}
