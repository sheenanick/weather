package com.example.guest.thebetterweatherapp;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherService {
    public static void findForecast(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.LOCATION_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter(Constants.DAYS_QUERY_PARAMETER, Constants.DAYS);
        urlBuilder.addQueryParameter(Constants.UNITS_QUERY_PARAMETER_, Constants.UNITS);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Day> processResults(Response response) {
        ArrayList<Day> forecast = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject weatherJSON = new JSONObject(jsonData);
                JSONArray forecastJSON = weatherJSON.getJSONArray("list");
                for (int i = 0; i < forecastJSON.length(); i++) {
                    JSONObject dayJSON = forecastJSON.getJSONObject(i);
                    long dateSeconds = dayJSON.getLong("dt");
                    double maxTemp = dayJSON.getJSONObject("temp").getDouble("max");
                    double minTemp = dayJSON.getJSONObject("temp").getDouble("min");
                    double dayTemp = dayJSON.getJSONObject("temp").getDouble("day");
                    String weather = dayJSON.getJSONArray("weather").getJSONObject(0).getString("description");
                    String weatherCategory = dayJSON.getJSONArray("weather").getJSONObject(0).getString("main");
                    Day day = new Day(dateSeconds,maxTemp,minTemp,dayTemp,weather, weatherCategory);
                    forecast.add(day);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return forecast;
    }
}
