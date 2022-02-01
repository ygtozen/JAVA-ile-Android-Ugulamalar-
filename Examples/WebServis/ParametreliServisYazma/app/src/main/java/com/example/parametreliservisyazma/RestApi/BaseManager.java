package com.example.parametreliservisyazma.RestApi;

public class BaseManager {

    protected RestApi getRestApi()
    {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.Adres);
        return restApiClient.getRestApi();
    }

}
