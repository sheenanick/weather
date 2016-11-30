package com.example.guest.thebetterweatherapp.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.thebetterweatherapp.R;
import com.example.guest.thebetterweatherapp.models.Day;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DayDetailFragment extends Fragment {
    @Bind(R.id.weatherImageView) ImageView mWeatherImage;
    @Bind(R.id.dayTextView) TextView mDayLabel;
    @Bind(R.id.descriptionTextView) TextView mDescriptionLabel;
    @Bind(R.id.maxTempTextView) TextView mMaxTempLabel;
    @Bind(R.id.minTempTextView) TextView mMinTempLabel;
    @Bind(R.id.saveWeatherButton) Button mSaveWeatherButton;

    private Day mDay;

    public static DayDetailFragment newInstance(Day day) {
        DayDetailFragment dayDetailFragment = new DayDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("day", Parcels.wrap(day));
        dayDetailFragment.setArguments(args);
        return dayDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDay = Parcels.unwrap(getArguments().getParcelable("day"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day_detail, container, false);
        ButterKnife.bind(this, view);

        String category = mDay.getWeatherCategory();
        if (category.equals("Clear")) {
            mWeatherImage.setImageResource(R.drawable.sun);
        }else if (category.equals("Snow")){
            mWeatherImage.setImageResource(R.drawable.snow);
        }else if (category.equals("Rain")){
            mWeatherImage.setImageResource(R.drawable.heavyrain);
        }else if (category.equals("Clouds")){
            mWeatherImage.setImageResource(R.drawable.cloud);
        }else{
            mWeatherImage.setImageResource(R.drawable.storm);
        }

        mDayLabel.setText(mDay.getDayString());
        mDescriptionLabel.setText(mDay.getWeather());
        mMaxTempLabel.setText(mDay.getMaxTemp().toString());
        mMinTempLabel.setText(mDay.getMinTemp().toString());
        return view;
    }

}
