package com.example.guest.thebetterweatherapp;

/**
 * Created by Guest on 11/29/16.
 */
public class Day {
    private int mDateSeconds;
    private double mMaxTemp;
    private double mMinTemp;
    private double mDayTemp;
    private String mWeather;

    public Day(int dateSeconds, double maxTemp, double minTemp, double dayTemp, String weather) {
        this.mDateSeconds = dateSeconds;
        this.mMaxTemp = maxTemp;
        this.mMinTemp = minTemp;
        this.mDayTemp = dayTemp;
        this.mWeather = weather;
    }

    public int getDateSeconds() {
        return mDateSeconds;
    }

    public double getMaxTemp() {
        return mMaxTemp;
    }

    public double getMinTemp() {
        return mMinTemp;
    }

    public double getDayTemp() {
        return mDayTemp;
    }

    public String getWeather() {
        return mWeather;
    }

}
