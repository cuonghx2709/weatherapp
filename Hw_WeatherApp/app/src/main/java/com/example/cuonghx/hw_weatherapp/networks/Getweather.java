package com.example.cuonghx.hw_weatherapp.networks;

import com.example.cuonghx.hw_weatherapp.weather.MainObjectJSON;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by cuonghx on 10/19/2017.
 */

public interface Getweather {
    @GET("forecast")
    Call<MainObjectJSON> getWeather(@Query("q") String name, @Query("appid") String appid);
}
