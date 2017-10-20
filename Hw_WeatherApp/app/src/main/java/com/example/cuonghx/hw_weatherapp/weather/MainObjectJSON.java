package com.example.cuonghx.hw_weatherapp.weather;

import java.util.List;

/**
 * Created by cuonghx2709 on 10/13/2017.
 */

public class MainObjectJSON {
    private String cod;
    private double message;
    private int cnt ;
    private City city;
    private List<Weather3Hour> list;

    public MainObjectJSON(String cod, double message, int cnt, City city, List<Weather3Hour> list) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.city = city;
        this.list = list;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Weather3Hour> getList() {
        return list;
    }

    public void setList(List<Weather3Hour> list) {
        this.list = list;
    }
}
