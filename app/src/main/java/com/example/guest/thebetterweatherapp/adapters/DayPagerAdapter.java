package com.example.guest.thebetterweatherapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.guest.thebetterweatherapp.models.Day;
import com.example.guest.thebetterweatherapp.ui.DayDetailFragment;

import java.util.ArrayList;

/**
 * Created by Guest on 11/30/16.
 */
public class DayPagerAdapter extends FragmentPagerAdapter{
    private ArrayList<Day> mDays;

    public DayPagerAdapter(FragmentManager fm, ArrayList<Day> days) {
        super(fm);
        mDays = days;
    }

    @Override
    public Fragment getItem(int position) {
        return DayDetailFragment.newInstance(mDays.get(position));
    }

    @Override
    public int getCount() {
        return mDays.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDays.get(position).getDayString();
    }
}
