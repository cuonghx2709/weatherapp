package com.example.cuonghx.hw_weatherapp.weather;

/**
 * Created by cuonghx2709 on 10/13/2017.
 */

public class Coord {
    private float lon;
    private float lat;

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public Coord(float lon, float lat) {

        this.lon = lon;
        this.lat = lat;
    }
}
