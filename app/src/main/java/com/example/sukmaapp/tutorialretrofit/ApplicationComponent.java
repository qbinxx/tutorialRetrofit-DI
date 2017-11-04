package com.example.sukmaapp.tutorialretrofit;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Sogeking on 10/25/2017.
 */

@Singleton
@Component(modules = {ApiModule.class,UseCaseModule.class})
public interface ApplicationComponent {

    void inject(MainActivity activity);

}
