package com.example.guest.thebetterweatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ForecastActivity extends AppCompatActivity {
    public static final String TAG = ForecastActivity.class.getSimpleName();
    @Bind(R.id.listView) ListView mListView;

    public ArrayList<Day> mForecast = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        getForecast(location);
    }

    private void getForecast(String location) {
        final WeatherService weatherService = new WeatherService();
        weatherService.findForecast(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mForecast = weatherService.processResults(response);
                Log.d(TAG,mForecast.toString());

                ForecastActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] dateTimes = new String[mForecast.size()];
                        for (int i = 0; i < dateTimes.length; i++) {
                            dateTimes[i] = mForecast.get(i).getWeather();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(ForecastActivity.this, android.R.layout.simple_list_item_1, dateTimes);
                        Log.d(TAG,dateTimes[0]);
                        mListView.setAdapter(adapter);
                    }
                });
            }
        });
    }
}
