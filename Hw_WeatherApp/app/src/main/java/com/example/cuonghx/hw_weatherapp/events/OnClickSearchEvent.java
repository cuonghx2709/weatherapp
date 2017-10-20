package com.example.cuonghx.hw_weatherapp.events;

import com.example.cuonghx.hw_weatherapp.weather.MainObjectJSON;

import java.util.PriorityQueue;

/**
 * Created by cuonghx on 10/19/2017.
 */

public class OnClickSearchEvent {
    private MainObjectJSON mainObjectJSON;

    public MainObjectJSON getMainObjectJSON() {
        return mainObjectJSON;
    }

    public void setMainObjectJSON(MainObjectJSON mainObjectJSON) {
        this.mainObjectJSON = mainObjectJSON;
    }

    public OnClickSearchEvent(MainObjectJSON mainObjectJSON) {

        this.mainObjectJSON = mainObjectJSON;
    }
}
