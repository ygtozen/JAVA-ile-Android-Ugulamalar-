package com.example.post1.RestApi;

public class BaseManager {
    protected RestApi getRestApi()
    {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.adres);
        return restApiClient.getRestApi();
    }
}
