package com.example.testapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface GetEntries {

    @FormUrlEncoded
    @Headers("token: N6zbaS4-G6-RDMQKyb")
    @POST("testAPI/")
    Call<Entries> getEntry(@Field("a") String value, @Field("session") String session);
}
