package com.example.webservis.RestApi;

import com.example.webservis.Models.Bilgiler;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }

    public Call<List<Bilgiler>> getirBilgileri()
    {
        Call<List<Bilgiler>> call = getRestApiClient().bilgiGetir();
        return call;
    }

    /*private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }

    // RestApi interfacesindeki bilgiGetir metodunu çağırıcaz
    public Call<List<Bilgiler>> getirBilgileri()
    {
        Call<List<Bilgiler>> call = getRestApiClient().bilgiGetir();
        return call;
    }*/
}
