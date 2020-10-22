package com.example.testapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @POST("posts")
    Call<Post> createPost(@Body Post post);

//    @GET("posts")
//    Call<Post> createPost(@Body Post post);
}
