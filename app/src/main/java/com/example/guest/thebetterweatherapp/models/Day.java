package com.example.guest.thebetterweatherapp.models;

import org.parceler.Parcel;

import java.text.SimpleDateFormat;
import java.util.Date;

@Parcel
public class Day {
    private long mDateSeconds;
    private Integer mMaxTemp;
    private Integer mMinTemp;
    private Integer mDayTemp;
    private String mWeather;
    private String mWeatherCategory;
    private String mDayString;

    public Day() {}

    public Day(long dateSeconds, double maxTemp, double minTemp, double dayTemp, String weather, String weatherCategory) {
        this.mDateSeconds = dateSeconds;
        this.mMaxTemp = (Integer) (int) (maxTemp + 0.5);
        this.mMinTemp = (Integer) (int) (minTemp + 0.5);
        this.mDayTemp = (Integer) (int) (dayTemp + 0.5);
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

    public Integer getMaxTemp() {
        return mMaxTemp;
    }

    public Integer getMinTemp() {
        return mMinTemp;
    }

    public Integer getDayTemp() {
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
