package com.example.dbtojson.RestApi;

import com.example.dbtojson.Models.Kullanici;
import com.example.dbtojson.Models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApi {
    // listeleme için
    @GET("/listele.php")
    Call<List<Kullanici>> listele();

    //silme için
    @FormUrlEncoded
    @POST("/sil.php")
    Call<Result> sil(@Field("id") String id);
}
