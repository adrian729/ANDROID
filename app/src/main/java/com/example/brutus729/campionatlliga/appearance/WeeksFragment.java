package com.example.brutus729.campionatlliga.appearance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.brutus729.campionatlliga.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeeksFragment extends Fragment {

    WeeksExpListAdapter explistAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weeks_layout, container, false);

        final ViewGroup finalContainer = container;

        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.weeks_expandable_list_view);

        // preparing list data
        prepareListDataNoDB();

        explistAdapter = new WeeksExpListAdapter(container.getContext(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(explistAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(finalContainer.getContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(finalContainer.getContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        finalContainer.getContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

        return view;
    }

    /*
    * Preparing the list data
    * Per fer proves sense DB
    */
    private void prepareListDataNoDB() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Jornada3");
        listDataHeader.add("Jornada2");
        listDataHeader.add("Jornada1");

        // Adding child data
        List<String> Jornada1 = new ArrayList<String>();
        Jornada1.add("Equip1 vs Equip2");
        Jornada1.add("Equip3 vs Equip4");
        Jornada1.add("Equip5 vs Equip6");
        Jornada1.add("Equip7 vs Equip8");
        Jornada1.add("Equip9 vs Equip0");

        List<String> Jornada2 = new ArrayList<String>();
        Jornada2.add("Equip5 vs Equip6");
        Jornada2.add("Equip7 vs Equip8");
        Jornada2.add("Equip9 vs Equip0");
        Jornada2.add("Equip1 vs Equip2");
        Jornada2.add("Equip3 vs Equip4");

        List<String> Jornada3 = new ArrayList<String>();
        Jornada3.add("Equip1 vs Equip2");
        Jornada3.add("Equip7 vs Equip8");
        Jornada3.add("Equip9 vs Equip0");
        Jornada3.add("Equip3 vs Equip4");
        Jornada3.add("Equip5 vs Equip6");

        listDataChild.put(listDataHeader.get(0), Jornada3); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Jornada2);
        listDataChild.put(listDataHeader.get(2), Jornada1);
    }

}