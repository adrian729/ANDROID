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

    public PagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.mNumOfTabs = numTabs;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                RankingsFragment rankingsFragment = new RankingsFragment();
                return rankingsFragment;
            case 1:
                WeeksFragment weeksFragment = new WeeksFragment();
                return weeksFragment;
            case 2:
                TeamsFragment teamsFragment = new TeamsFragment();
                return teamsFragment;
            default:
                return null;
        }

    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}