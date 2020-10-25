package com.example.testapplication;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AddEntries {

    @FormUrlEncoded
    @Headers("token: N6zbaS4-G6-RDMQKyb")
    @POST("testAPI/")
    Call<AddEntriesResponse> createPost(@Field("a") String value, @Field("session") String session, @Field("body") String text);
}
