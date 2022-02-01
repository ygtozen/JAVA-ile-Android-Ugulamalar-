package com.example.post.RestApi;

public class BaseManager {

    protected RestApi getRestApi()
    {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.adres);
        return restApiClient.getRestApi();
    }

}
