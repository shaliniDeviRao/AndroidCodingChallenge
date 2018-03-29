package com.app.isspass.service;

import com.app.isspass.model.Data;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * This class represents the Passes API, all endpoints can stay here.
 */

public interface ISSPassesAPI {
    @GET("iss-pass.json")
    Call<Data> getPasses(@QueryMap Map<String, String> options);

}
