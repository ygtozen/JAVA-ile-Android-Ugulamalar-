package com.example.webservis2.RestApi;

public class BaseManager {

    protected RestApi getRestApiClient()
    {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.url_bilgi);
        return restApiClient.getRestApi();
    }

}
