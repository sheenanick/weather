package com.example.guest.thebetterweatherapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 11/29/16.
 */
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {
    private ArrayList<Day> mForecast = new ArrayList<>();
    private Context mContext;

    public ForecastAdapter(Context context, ArrayList<Day> forecast) {
        mContext = context;
        mForecast = forecast;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_list_item, parent, false);
        ForecastViewHolder viewHolder = new ForecastViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastAdapter.ForecastViewHolder holder, int position) {
        holder.bindForecast(mForecast.get(position));
    }

    @Override
    public int getItemCount() {
        return mForecast.size();
    }

    public class ForecastViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.weatherImageView) ImageView mWeatherImageView;
        @Bind(R.id.temperatureTextView) TextView mTemperatureTextView;
        @Bind(R.id.dayTextView) TextView mDayTextView;

        private Context mContext;

        public ForecastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindForecast(Day day) {
            mTemperatureTextView.setText(day.getDayTemp().toString() + " °F");

            long y = day.getDateSeconds() * 1000;
            Date date = new Date(y);
            SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
            String z = formatter.format(date);
            mDayTextView.setText(z);
            String category = day.getWeatherCategory();
            if (category.equals("Clear")) {
                mWeatherImageView.setImageResource(R.drawable.sun);
            }else if (category.equals("Snow")){
                mWeatherImageView.setImageResource(R.drawable.snow);
            }else if (category.equals("Rain")){
                mWeatherImageView.setImageResource(R.drawable.heavyrain);
            }else if (category.equals("Clouds")){
                mWeatherImageView.setImageResource(R.drawable.cloud);
            }else{
                mWeatherImageView.setImageResource(R.drawable.storm);
            }
        }
    }


}
