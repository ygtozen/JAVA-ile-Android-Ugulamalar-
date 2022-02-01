package com.example.googlemap4.RestApi;

import com.example.googlemap4.Models.MapPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {

    @GET("/googlemap.php")
    Call<MapPojo> getMapInformation();

}
