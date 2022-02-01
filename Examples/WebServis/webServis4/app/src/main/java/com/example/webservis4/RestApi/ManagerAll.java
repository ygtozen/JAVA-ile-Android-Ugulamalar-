package com.example.webservis4.RestApi;

import com.example.webservis4.Models.Bilgi;
import com.example.webservis4.Models.Result;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }

    public Call<List<Bilgi>> getirCall()
    {
        Call<List<Bilgi>> x = getRestApi().getir();
        return x;
    }

    public Call<List<Result>> managerGetResult(String post,String id)
    {
        Call<List<Result>> y = getRestApi().getirResult(post,id);
        return y;
    }
}
