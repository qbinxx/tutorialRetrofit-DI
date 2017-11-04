package com.example.sukmaapp.tutorialretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sukmaapp.tutorialretrofit.models.Hero;
import com.example.sukmaapp.tutorialretrofit.network.MyServices;

import java.util.List;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

//    public static final String API_BASE_URL = "http://192.168.43.14:3000/";
    private String text = "";
    private TextView textView;

    @Inject MyServices services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
//
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//
//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl(API_BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create());
//
//        Retrofit retrofit = builder.client(httpClient.build())
//                .build();
//
//        MyServices client = retrofit.create(MyServices.class);
//
//        Call<List<Hero>> call = client.getHeroes();
//
//        // Execute the call asynchronously. Get a positive or negative callback.
//        call.enqueue(new Callback<List<Hero>>() {
//            @Override
//            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
//                // The network call was a success and we got a response
//                // TODO: use the repository list and display it
//                for (Hero hero:response.body()){
//                    text += hero.getName()+"\n";
//                }
////                text += response.body().get(0).getName();
//                textView.setText(text);
//            }
//
//            @Override
//            public void onFailure(Call<List<Hero>> call, Throwable t) {
//                // the network call was a failure
//                // TODO: handle error
//            }
//        });

        initAppComponent();
        loadNewsList();
    }

    public void initAppComponent(){
        MainApplication mainApplication = (MainApplication) getApplication();
        mainApplication.getComponent().inject(this);
    }

    private void loadNewsList() {
        Log.d("LoadNewsList","executed");
        Call<List<Hero>> call = services.getHeroes();

        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it
                for (Hero hero:response.body()){
                    text += hero.getName()+"\n";
                }
//                text += response.body().get(0).getName();
                textView.setText(text);
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                // the network call was a failure
                // TODO: handle error
            }
        });
    }

}
