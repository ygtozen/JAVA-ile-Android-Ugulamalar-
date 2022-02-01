package com.example.googlemap4.RestApi;

import com.example.googlemap4.Models.MapPojo;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getOurInstance()
    {
        return ourInstance;
    }

    public Call<MapPojo> harita()
    {
        Call<MapPojo> x = getRestApi().getMapInformation();
        return x;
    }
}
