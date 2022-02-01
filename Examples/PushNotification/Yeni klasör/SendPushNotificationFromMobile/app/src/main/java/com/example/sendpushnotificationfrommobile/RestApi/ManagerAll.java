package com.example.sendpushnotificationfrommobile.RestApi;

import com.example.sendpushnotificationfrommobile.Models.Result;

import retrofit2.Call;

public class ManagerAll extends BaseManager{

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }

    public Call<Result> ekle(String kullaniciAdi, String sifre, String mail)
    {
        Call<Result> x = getRestApi().addUser(kullaniciAdi, sifre, mail);
        return x;
    }

    public Call<Result> aktifEt(String mail,String kod)
    {
        Call<Result> x = getRestApi().aktifEt(mail, kod);
        return x;
    }

}
