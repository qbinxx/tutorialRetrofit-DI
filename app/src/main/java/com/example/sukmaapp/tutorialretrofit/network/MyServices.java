package com.example.sukmaapp.tutorialretrofit.network;

import com.example.sukmaapp.tutorialretrofit.models.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sogeking on 10/25/2017.
 */

public interface MyServices {
    @GET("heroes")
    Call<List<Hero>> getHeroes();
}
