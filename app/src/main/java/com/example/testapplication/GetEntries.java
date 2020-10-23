package com.example.testapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GetEntries {

    @POST("get_entry")
    Call<Post> getPost(@Body Post post);
}
