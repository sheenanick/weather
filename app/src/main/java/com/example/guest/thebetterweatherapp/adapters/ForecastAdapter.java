package com.example.guest.thebetterweatherapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.thebetterweatherapp.models.Day;
import com.example.guest.thebetterweatherapp.R;
import com.example.guest.thebetterweatherapp.ui.DayDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {
    private ArrayList<Day> mForecast = new ArrayList<>();
    private Context mContext;
    private String mLocation;

    public ForecastAdapter(Context context, ArrayList<Day> forecast, String location) {
        mContext = context;
        mForecast = forecast;
        mLocation = location;
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

    public class ForecastViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.weatherImageView) ImageView mWeatherImageView;
        @Bind(R.id.temperatureTextView) TextView mTemperatureTextView;
        @Bind(R.id.dayTextView) TextView mDayTextView;

        private Context mContext;

        public ForecastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindForecast(Day day) {
            mTemperatureTextView.setText(day.getDayTemp().toString() + " °F");
            mDayTextView.setText(day.getDayString());
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

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, DayDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("forecast", Parcels.wrap(mForecast));
            intent.putExtra("location", mLocation);
            mContext.startActivity(intent);
        }
    }


}
