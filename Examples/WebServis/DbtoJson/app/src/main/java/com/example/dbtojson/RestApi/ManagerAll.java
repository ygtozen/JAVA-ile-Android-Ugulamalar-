package com.example.dbtojson.RestApi;

import com.example.dbtojson.Models.Kullanici;
import com.example.dbtojson.Models.Result;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }

    public Call<List<Kullanici>> goster()
    {
        Call<List<Kullanici>> x = getRestApi().listele();
        return x;
    }

    //Silme işlemi için
    public Call<Result> deleteFromDb(String id)
    {
        Call<Result> y = getRestApi().sil(id);
        return y;
    }

}
