package com.example.brutus729.campionatlliga.appearance;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.brutus729.campionatlliga.R;
import com.example.brutus729.campionatlliga.objects.TeamsItem;
import com.example.brutus729.campionatlliga.persistance.TeamsDataSource;

import java.util.ArrayList;
import java.util.List;

public class Teams extends Fragment {

    private List items;

    private TeamsDataSource dataSource;
    private SimpleCursorAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.teams_layout, container, false);

        ListView listView = (ListView) view.findViewById(R.id.teams_list_view);

        //Crear nuevo objeto QuotesDataSource
        dataSource = new TeamsDataSource(container.getContext());

        //Iniciando el nuevo Adaptador
        adapter = new SimpleCursorAdapter(
                container.getContext(),
                android.R.layout.two_line_list_item,
                dataSource.getAllTeams(),
                new String[]{TeamsDataSource.ColumnTeams.NAME_TEAMS,
                        TeamsDataSource.ColumnTeams.SHORT_NAME_TEAMS},
                new int[]{android.R.id.text1, android.R.id.text2},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER

        );

        /*
        this.items = new ArrayList();
        for(int i = 0; i < 10; ++i) items.add(new TeamsItem("equip"+i));
        */
        // Sets the data behind this ListView
        //listView.setAdapter(new TeamsItemAdapter(container.getContext(), items));

        listView.setAdapter(adapter);

        /*
        // Register a callback to be invoked when an item in this AdapterView
        // has been clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long arg) {
                TeamsItem item = (TeamsItem)items.get(position);
                Toast.makeText(getActivity(), item.getTeamsName() + " Clicked!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        */
        return view;
    }

}