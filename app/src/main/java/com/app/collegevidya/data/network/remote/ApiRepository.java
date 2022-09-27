package com.app.collegevidya.data.network.remote;

import com.app.collegevidya.data.network.remote.client.ApiService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApiRepository implements ApiDataSource {

    private final ApiService apiService;

    @Inject
    public ApiRepository(ApiService apiService) {
        this.apiService = apiService;
    }


}
