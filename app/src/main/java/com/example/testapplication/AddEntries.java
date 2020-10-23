package com.example.testapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AddEntries {

    @Headers("token: N6zbaS4-G6-RDMQKyb")
    @POST("add_entry")
    Call<Post> createPost(@Body Post post);

//    @GET("posts")
//    Call<Post> createPost(@Body Post post);
}
