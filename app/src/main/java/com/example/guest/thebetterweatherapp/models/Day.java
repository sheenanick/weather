package com.example.guest.thebetterweatherapp.models;

import org.parceler.Parcel;

import java.text.SimpleDateFormat;
import java.util.Date;

@Parcel
public class Day {
    private long mDateSeconds;
    private Double mMaxTemp;
    private Double mMinTemp;
    private Double mDayTemp;
    private String mWeather;
    private String mWeatherCategory;
    private String mDayString;

    public Day() {}

    public Day(long dateSeconds, double maxTemp, double minTemp, double dayTemp, String weather, String weatherCategory) {
        this.mDateSeconds = dateSeconds;
        this.mMaxTemp = maxTemp;
        this.mMinTemp = minTemp;
        this.mDayTemp = dayTemp;
        this.mWeather = weather;
        this.mWeatherCategory = weatherCategory;
        Date date = new Date(dateSeconds * 1000);
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        String z = formatter.format(date);
        this.mDayString = z;
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

    public String getDayString() { return mDayString; }

}
