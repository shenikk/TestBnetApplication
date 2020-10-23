package com.example.testapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface SessionApi {

    //@Headers({"token: N6zbaS4-G6-RDMQKyb", "Content-Type: multipart/form-data", "Content-Length: 167", "Host: bnet.i-partner.ru"})
    @FormUrlEncoded
    @Headers("token: N6zbaS4-G6-RDMQKyb")
    @POST("testAPI/")
    Call<MySession> getSession(@Field("a") String value);
}
