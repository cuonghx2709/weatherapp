package com.example.cuonghx.hw_weatherapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuonghx.hw_weatherapp.R;
import com.example.cuonghx.hw_weatherapp.events.OnClickForecastEvent;
import com.example.cuonghx.hw_weatherapp.events.OnClickSearchEvent;
import com.example.cuonghx.hw_weatherapp.utils.Utils;
import com.example.cuonghx.hw_weatherapp.weather.MainObjectJSON;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentFragment extends Fragment {

    private MainObjectJSON mainObjectJSON;

    public CurrentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        EventBus.getDefault().register(this);

        View view = inflater.inflate(R.layout.fragment_current, container, false);
        setUpUI(view);



        return view;
    }

    private void setUpUI(View view) {
        TextView textView = view.findViewById(R.id.tv_name);
        TextView tvMain = view.findViewById(R.id.tv_main_weather);
        TextView tvDeg = view.findViewById(R.id.tv_deg);
        TextView winSpeed = view.findViewById(R.id.tv_wind_speed);
        TextView rain = view.findViewById(R.id.tv_rain);
        ImageView image = view.findViewById(R.id.iv_icon_main);
        ImageView ivRain = view.findViewById(R.id.iv_ic_rain);

        Log.d("cuonghx", "setUpUI: " + mainObjectJSON.getCity().getName());
        tvMain.setText(mainObjectJSON.getList().get(1).getWeather().get(0).getMain());
        tvDeg.setText(String.format("%.0f", mainObjectJSON.getList().get(1).getMain().getTemp() -273.15));
        winSpeed.setText(String.format("%.1f km/h", mainObjectJSON.getList().get(1).getWind().getSpeed()*3.6));
        textView.setText(mainObjectJSON.getCity().getName());
        Picasso.with(getContext()).load(getResources().getIdentifier("icon", "raw", getContext().getPackageName())).into(ivRain);
        Picasso.with(getContext()).load("http://openweathermap.org/img/w/" + mainObjectJSON.getList().get(1).getWeather().get(0).getIcon() + ".png").into(image);
    }

    @Subscribe(sticky = true)
    public void getWeather(OnClickSearchEvent onClickSearchEvent){
        this.mainObjectJSON = onClickSearchEvent.getMainObjectJSON();
    }

}
