package com.example.testapplication;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BnetSession {

    @FormUrlEncoded
    @Headers("token: N6zbaS4-G6-RDMQKyb")
    @POST("testAPI/")
    Call<BnetSessionResponse> getSession(@Field("a") String value);
}
