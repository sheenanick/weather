package com.example.guest.thebetterweatherapp.ui;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guest.thebetterweatherapp.R;
import com.example.guest.thebetterweatherapp.adapters.DayPagerAdapter;
import com.example.guest.thebetterweatherapp.models.Day;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DayDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private DayPagerAdapter adapterViewPager;
    ArrayList<Day> mForecast = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail);
        ButterKnife.bind(this);

        mForecast = Parcels.unwrap(getIntent().getParcelableExtra("forecast"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new DayPagerAdapter(getSupportFragmentManager(), mForecast);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        setTitle(location);
    }
}
