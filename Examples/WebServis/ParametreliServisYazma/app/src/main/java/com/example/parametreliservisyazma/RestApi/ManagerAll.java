package com.example.parametreliservisyazma.RestApi;

import com.example.parametreliservisyazma.Models.Uye;
import com.example.parametreliservisyazma.Models.Uyebilgileri;

import retrofit2.Call;

public class ManagerAll extends BaseManager{

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }

    public Call<Uye> giris(String username,String password)
    {
        Call<Uye> x = getRestApi().addUser(username,password);
        return x;
    }

    public Call<Uyebilgileri> getir(String id)
    {
        Call<Uyebilgileri> y = getRestApi().bilgiGetir(id);
        return y;
    }

}
