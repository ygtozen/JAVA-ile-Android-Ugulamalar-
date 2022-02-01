package com.example.urunlerlisteleme.RestApi;

public class BaseManager {

    protected RestApi getRestApi()
    {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.Adres);
        return restApiClient.getRestApi();
    }

}
