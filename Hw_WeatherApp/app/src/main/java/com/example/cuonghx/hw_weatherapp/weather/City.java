package com.example.cuonghx.hw_weatherapp.weather;

/**
 * Created by cuonghx on 10/19/2017.
 */

public class City {
    private int id;
    private String name;
    private Coord coord;
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public City(int id, String name, Coord coord, String country) {

        this.id = id;
        this.name = name;
        this.coord = coord;
        this.country = country;
    }
}
