package com.example.brutus729.campionatlliga.appearance;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.brutus729.campionatlliga.R;
import com.example.brutus729.campionatlliga.objects.Player;
import com.example.brutus729.campionatlliga.objects.Team;
import com.example.brutus729.campionatlliga.persistance.TeamsDataSource;

import java.util.ArrayList;
import java.util.List;

public class TeamsFragment extends Fragment {

    private List items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.teams_layout, container, false);

        ListView listView = (ListView) view.findViewById(R.id.teams_list_view);
        /**Datos No DB para pruebas
        setItemsNoDb*/
        /**Datos DB*/
        setItemsFromDb(container);
        /**Usando TeamsItemAdapter*/
        // Sets the data behind this ListView
        listView.setAdapter(new TeamsItemAdapter(container.getContext(), items));
        // Register a callback to be invoked when an item in this AdapterView
        // has been clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long arg) {
                //TODO: canviar el que fa al clicar per un intent a una nova activitat (sha de crear la activitat com a filla de Main, el layout, etc)
                Team item = (Team)items.get(position);
                Toast.makeText(getActivity(), item.getTeamsName() + " Clicked!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    /**
     * Crea items vacia y la llena con datos generados manualmente.
     * Clase para hacer pruebas sin usar la DB.
     */
    private void setItemsNoDb(){
        this.items = new ArrayList();
        /** Llenar items sin DB (para pruebas) */
        List<Player> players = new ArrayList<Player>();
        for(int i = 0; i < 10; ++i) items.add(new Team("equip"+i, "e"+i, "city"+i,
                "football_ball.png"));
    }

    /**
     * Crea items con los datos de la DB.
     */
    private void setItemsFromDb(ViewGroup container){

        this.items = new ArrayList();

        TeamsDataSource dataSource = new TeamsDataSource(container.getContext());
        //Cursor con TODA la info de la tabla de TeamsFragment
        Cursor allTeams = dataSource.getAllTeams();
        //Recorrer items cursor
        if (allTeams.moveToFirst()){
            //Cojer datos cursor (y ponerlos en items)
            while(!allTeams.isAfterLast()){
                //TODO: ACONSEGUIR GOLS I ARRAY DE PLAYERS DE LA DB!
                items.add(new Team(
                        allTeams.getString(allTeams.getColumnIndex(
                                TeamsDataSource.ColumnTeams.NAME_TEAMS)
                        ),
                        allTeams.getString(allTeams.getColumnIndex(
                                TeamsDataSource.ColumnTeams.SHORT_NAME_TEAMS)
                        ),
                        allTeams.getString(allTeams.getColumnIndex(
                                TeamsDataSource.ColumnTeams.CITY_TEAMS)
                        ),
                        allTeams.getString(allTeams.getColumnIndex(
                                TeamsDataSource.ColumnTeams.SHIELD_TEAMS)
                        )
                ));
                allTeams.moveToNext();
            }
        }
        allTeams.close();



    }



}

/**Prueba con SimpleCursorAdapter (no me gusta, pocas opciones que yo sepa)
 SimpleCursorAdapter adapter = new SimpleCursorAdapter(
 container.getContext(),
 android.R.layout.two_line_list_item,
 dataSource.getAllTeams(),
 new String[]{TeamsDataSource.ColumnTeams.NAME_TEAMS,
 TeamsDataSource.ColumnTeams.SHORT_NAME_TEAMS},
 new int[]{android.R.id.text1, android.R.id.text2},
 SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER

 );
 listView.setAdapter(adapter);
 */