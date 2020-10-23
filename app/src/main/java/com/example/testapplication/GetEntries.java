package com.example.testapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GetEntries {

    @Headers("token: N6zbaS4-G6-RDMQKyb")
    @POST("get_entry")
    Call<Entries> getEntry(@Body String mySession);
}
