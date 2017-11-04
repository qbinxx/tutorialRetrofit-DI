package com.example.sukmaapp.tutorialretrofit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sogeking on 10/25/2017.
 */

@Module
public class ApiModule {

    private String baseUrl;

    public ApiModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpClient(){
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient.Builder okHttpClient){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());

        return  builder.client(okHttpClient.build())
                .build();
    }
}
