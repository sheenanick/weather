package com.example.guest.thebetterweatherapp;

/**
 * Created by Guest on 11/29/16.
 */
public class Day {
    private long mDateSeconds;
    private Double mMaxTemp;
    private Double mMinTemp;
    private Double mDayTemp;
    private String mWeather;

    private String mWeatherCategory;

    public Day(long dateSeconds, double maxTemp, double minTemp, double dayTemp, String weather, String weatherCategory) {
        this.mDateSeconds = dateSeconds;
        this.mMaxTemp = maxTemp;
        this.mMinTemp = minTemp;
        this.mDayTemp = dayTemp;
        this.mWeather = weather;
        this.mWeatherCategory = weatherCategory;
    }

    public long getDateSeconds() {
        return mDateSeconds;
    }

    public Double getMaxTemp() {
        return mMaxTemp;
    }

    public Double getMinTemp() {
        return mMinTemp;
    }

    public Double getDayTemp() {
        return mDayTemp;
    }

    public String getWeather() {
        return mWeather;
    }

    public String getWeatherCategory() {
        return mWeatherCategory;
    }

}
