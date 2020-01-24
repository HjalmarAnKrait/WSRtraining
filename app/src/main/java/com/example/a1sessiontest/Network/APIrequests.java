package com.example.a1sessiontest.Network;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIrequests
{
    @POST("signup")
    Call<JsonElement> authorization(@Body regPOJO regBody);

    @POST("signin")
    Call<JsonElement> registration(@Body authPOJO authPOJO);
}
