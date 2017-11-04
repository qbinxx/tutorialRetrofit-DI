package com.example.sukmaapp.tutorialretrofit;

import android.app.Application;

/**
 * Created by Sogeking on 10/25/2017.
 */

public class MainApplication extends Application {

    private ApplicationComponent mComponent;

    @Override
    public void onCreate(){
        super.onCreate();

        initDependencyInjection();
    }

    private void initDependencyInjection(){
        mComponent = DaggerApplicationComponent.builder()
                .useCaseModule(new UseCaseModule())
                .apiModule(new ApiModule("http://192.168.43.14:3000/"))
                .build();
    }

    public ApplicationComponent getComponent(){
        return mComponent;
    }
}
