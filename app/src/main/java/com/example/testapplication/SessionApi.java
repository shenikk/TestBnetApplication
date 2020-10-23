package com.example.testapplication;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SessionApi {

    @POST("new_session")
    Call<MySession> getSession();
}
