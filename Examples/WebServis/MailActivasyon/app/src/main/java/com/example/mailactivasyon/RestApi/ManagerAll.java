package com.example.mailactivasyon.RestApi;

import com.example.mailactivasyon.Models.Result;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized  ManagerAll getInstance()
    {
        return ourInstance;
    }

    public Call<Result> ekle(String kullaniciAdi,String sifre,String mailadres)
    {
        Call<Result> x = getRestApi().addUser(kullaniciAdi, sifre, mailadres);
        return x;
    }

    public Call<Result> aktifEt(String mailadres,String code)
    {
        Call<Result> x = getRestApi().aktifEt(mailadres,code);
        return x;
    }

}
