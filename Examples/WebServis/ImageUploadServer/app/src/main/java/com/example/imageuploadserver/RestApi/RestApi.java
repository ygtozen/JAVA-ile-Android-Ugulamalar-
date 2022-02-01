package com.example.imageuploadserver.RestApi;

import com.example.imageuploadserver.Models.Result;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {
    @FormUrlEncoded
    @POST("/resimekle.php")
    Call<Result> gonder(@Field("baslik") String baslik,@Field("image") String image);

}
