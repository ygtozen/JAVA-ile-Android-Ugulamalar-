package com.example.sendpushnotificationfrommobile.RestApi;

import com.example.sendpushnotificationfrommobile.Models.Result;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized  ManagerAll getOurInstance()
    {
        return ourInstance;
    }

    public Call<Result> ekle(String kullaniciadi,String sifre,String mail)
    {
        Call<Result> x = getRestApi().addUser(kullaniciadi, sifre, mail);
        return x;
    }

    public Call<Result> aktifet(String kod, String mail)
    {
        Call<Result> y = getRestApi().aktifet(kod, mail);
        return y;
    }
}
