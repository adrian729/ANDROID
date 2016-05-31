package com.example.brutus729.campionatlliga.appearance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.brutus729.campionatlliga.R;
import com.example.brutus729.campionatlliga.objects.RankingsItem;

import java.util.ArrayList;
import java.util.List;

public class RankingsFragment extends Fragment {

    private List items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rankings_layout, container, false);

        ListView listView = (ListView) view.findViewById(R.id.rankings_list_view);

        this.items = new ArrayList();
        for(int i = 0; i < 10; ++i) items.add(new RankingsItem("Equip"+i, 99+2*i, 99+i, 99-3*i, (99+i)*2));
        //TODO: ORDENAR LISTA POR PUNTOS Y PONER RANKING QUE TOQUE (se tendra que hacer un comparator)

        // Sets the data behind this ListView
        listView.setAdapter(new RankingsItemAdapter(container.getContext(), items));

        // Register a callback to be invoked when an item in this AdapterView
        // has been clicked
        /* DE MOMENT NO VOLEM FER CLICABLE RANKINGS. OPCIONAL
        //(per mostrar mes dades del ranking dun equip concret)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long arg) {
                RankingsItem item = (RankingsItem)items.get(position);
                Toast.makeText(getActivity(), item.getTeamName() + " Clicked!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        */
        return view;
    }
}