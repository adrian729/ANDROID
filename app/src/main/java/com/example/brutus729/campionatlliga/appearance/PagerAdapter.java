package com.example.brutus729.campionatlliga.appearance;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    private int mNumOfTabs;
    private Context context;
    private CharSequence[] tabTitles;

    public PagerAdapter(FragmentManager fm, Context context, CharSequence[] titles) {
        super(fm);
        this.context = context;
        tabTitles = titles;
        mNumOfTabs = tabTitles.length;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Rankings rankings = new Rankings();
                return rankings;
            case 1:
                Weeks weeks = new Weeks();
                return weeks;
            case 2:
                Teams teams = new Teams();
                return teams;
            default:
                return null;
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}