package com.example.cuonghx.hw_weatherapp.events;

import com.example.cuonghx.hw_weatherapp.weather.MainObjectJSON;

/**
 * Created by cuonghx on 10/19/2017.
 */

public class OnClickForecastEvent {
    private MainObjectJSON mainObjectJSON;

    public MainObjectJSON getMainObjectJSON() {
        return mainObjectJSON;
    }

    public void setMainObjectJSON(MainObjectJSON mainObjectJSON) {
        this.mainObjectJSON = mainObjectJSON;
    }

    public OnClickForecastEvent(MainObjectJSON mainObjectJSON) {

        this.mainObjectJSON = mainObjectJSON;
    }
}
