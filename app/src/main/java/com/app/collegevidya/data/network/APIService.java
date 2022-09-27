package com.app.collegevidya.data.network;

import com.app.collegevidya.data.model.OtpModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("getUrl")
    Call<List<OtpModel>> getOtp();
}
