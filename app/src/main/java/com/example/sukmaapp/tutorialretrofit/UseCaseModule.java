package com.example.sukmaapp.tutorialretrofit;

import com.example.sukmaapp.tutorialretrofit.network.MyServices;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Sogeking on 10/25/2017.
 */

@Module
public class UseCaseModule {

    @Provides
    MyServices provideMyServices(Retrofit retrofit){
        return retrofit.create(MyServices.class);
    }
}
