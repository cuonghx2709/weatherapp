package com.example.cuonghx.hw_weatherapp.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.cuonghx.hw_weatherapp.R;
import com.example.cuonghx.hw_weatherapp.events.OnClickForecastEvent;
import com.example.cuonghx.hw_weatherapp.events.OnClickSearchEvent;
import com.example.cuonghx.hw_weatherapp.fragments.CurrentFragment;
import com.example.cuonghx.hw_weatherapp.fragments.ForecastFragment;
import com.example.cuonghx.hw_weatherapp.networks.Getweather;
import com.example.cuonghx.hw_weatherapp.utils.Utils;
import com.example.cuonghx.hw_weatherapp.weather.MainObjectJSON;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private MainObjectJSON main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUI();



    }

    @Override
    protected void onStart() {
        super.onStart();

        ImageView imageView = (ImageView) findViewById(R.id.iv_main);
        Picasso.with(this).load(this.getResources().getIdentifier("abcd", "raw", getPackageName())).into(imageView);

    }

    private void setUpUI() {
        ImageView ivSearch  = (ImageView) findViewById(R.id.iv_search);
        final EditText editText = (EditText) findViewById(R.id.edt_main);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_current);
        final RelativeLayout reltForecast = (RelativeLayout) findViewById(R.id.rl_forecast);

        ivSearch.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://api.openweathermap.org/data/2.5/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                String s = editText.getText().toString();
               if (s != null){
                   Getweather getweather = retrofit.create(Getweather.class);

                   getweather.getWeather(editText.getText().toString(), "9c3ab78c411781247eb0b124611b79a8").enqueue(new Callback<MainObjectJSON>() {
                       @Override
                       public void onResponse(Call<MainObjectJSON> call, Response<MainObjectJSON> response) {
                           if (response.body() != null){
                               main = response.body();
                               relativeLayout.removeAllViews();
                               reltForecast.removeAllViews();
                               Log.d("cuonghx", "onResponse: " + response.body().getCity().getName());
                               EventBus.getDefault().postSticky(new OnClickForecastEvent(main));
                               Utils.openFragment(getSupportFragmentManager(), R.id.rl_forecast, new ForecastFragment());

                               EventBus.getDefault().postSticky(new OnClickSearchEvent(main));
                               Utils.openFragment(getSupportFragmentManager(), R.id.rl_current, new CurrentFragment());
                           }else {
                               Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                           }

                       }

                       @Override
                       public void onFailure(Call<MainObjectJSON> call, Throwable t) {

                           Log.d("cuonghx", "onFailure: " + t.toString());
                           Toast.makeText(MainActivity.this, "No Connection", Toast.LENGTH_SHORT).show();
                       }
                   });
               }else {
                   Toast.makeText(MainActivity.this, "Select your City", Toast.LENGTH_SHORT).show();
               }

            }
        });
//
    }
}