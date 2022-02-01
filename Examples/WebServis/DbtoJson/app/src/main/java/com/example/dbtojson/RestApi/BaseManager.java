package com.example.dbtojson.RestApi;

public class BaseManager {
    protected RestApi getRestApi()
    {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.Adres);
        return restApiClient.getRestApi();
    }
}
