package com.example.webservis3.RestApi;

public class BaseManager {

    protected RestApi getRestApiClient()
    {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.url);
        return restApiClient.getRestApi();
    }

}
