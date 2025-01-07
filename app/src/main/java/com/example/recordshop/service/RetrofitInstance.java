package com.example.recordshop.service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;

    private final static String BASE_URL = "http://192.168.1.184:8080/api/";

    public static AlbumApiService getService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //OkHttpClient with increased timeouts
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS) // 30 seconds connect timeout
                .readTimeout(30, TimeUnit.SECONDS) // 30 seconds read timeout
                .writeTimeout(30, TimeUnit.SECONDS) // 30 seconds write timeout
                .build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return  retrofit.create(AlbumApiService.class);
    }
}
