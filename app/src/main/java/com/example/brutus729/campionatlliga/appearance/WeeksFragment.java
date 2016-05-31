package com.example.brutus729.campionatlliga.appearance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brutus729.campionatlliga.R;

public class WeeksFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO: Omplir Weeks amb ExpandableListView (exemple a MyApplication, weeks). Necessari Expandable list adapter nou layout i alguns items layout
        return inflater.inflate(R.layout.weeks_layout, container, false);
    }
}