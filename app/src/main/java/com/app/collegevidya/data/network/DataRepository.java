package com.app.collegevidya.data.network;


import com.app.collegevidya.data.network.remote.ApiRepository;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class DataRepository implements DataRepoHelper {

    private final ApiRepository apiRepository;

    @Inject
    public DataRepository(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public ApiRepository getApiRepository() {
        return apiRepository;
    }

}


