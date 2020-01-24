package com.example.a1sessiontest.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Networking
{
    private static final Networking ourInstance = new Networking();
    private Retrofit retrofit;
    private String baseUrl = "http://gym.areas.su/";


    public static Networking getInstance()
    {
        return ourInstance;
    }

    public Networking()
    {
        this.retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl).build();
    }

    public APIrequests apIrequests()
    {
        return retrofit.create(APIrequests.class);
    }
}
