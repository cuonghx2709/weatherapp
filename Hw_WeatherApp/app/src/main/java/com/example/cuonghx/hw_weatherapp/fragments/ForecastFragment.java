package com.example.cuonghx.hw_weatherapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cuonghx.hw_weatherapp.R;
import com.example.cuonghx.hw_weatherapp.adapters.ForecastAdapter;
import com.example.cuonghx.hw_weatherapp.events.OnClickForecastEvent;
import com.example.cuonghx.hw_weatherapp.events.OnClickSearchEvent;
import com.example.cuonghx.hw_weatherapp.weather.MainObjectJSON;
import com.example.cuonghx.hw_weatherapp.weather.Weather3Hour;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment {

    private MainObjectJSON mainObjectJSON;
    private List<Weather3Hour> list = new ArrayList<>();

    public ForecastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        EventBus.getDefault().register(this);
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
        setUpUI(view);
        return view;
    }
    @Subscribe(sticky = true)
    public void get(OnClickForecastEvent onClickForecastEvent){

        mainObjectJSON = onClickForecastEvent.getMainObjectJSON();

        Log.d("cuonghx", "get: " + mainObjectJSON.getList().get(0).getMain());

    }

    private void setUpUI(View view) {

        RecyclerView recyclerView = view.findViewById(R.id.recycle_view_item);
//        Log.d("cuonghx", "setUpUI: " + mainObjectJSON.getList().size());
        for (int i = 1; i < mainObjectJSON.getList().size(); ){
            list.add(mainObjectJSON.getList().get(i));
            i += 8;
        }
//        Log.d("cuonghx", "get: " + list.size());

        ForecastAdapter forecastAdapter = new ForecastAdapter(list, getContext());

        recyclerView.setAdapter(forecastAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL,false );
        recyclerView.setLayoutManager(gridLayoutManager);
//        RecyclerView recyclerView = view.findViewById(R.id.recyclrvie_forecast);
//        Log.d("cuonghx", "setUpUI: " + mainObjectJSON.getList().size());
//        ForecastAdapter forecastAdapter = new ForecastAdapter(mainObjectJSON.getList(), getContext());
//        recyclerView.setAdapter(forecastAdapter);

    }


}
