package com.example.webservis.RestApi;

public class BaseManager {

    protected RestApi getRestApiClient()
    {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.bilgi_URL);
        return restApiClient.getRestApi();
    }


}
