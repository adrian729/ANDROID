package com.example.brutus729.campionatlliga.appearance;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.brutus729.campionatlliga.R;
import com.example.brutus729.campionatlliga.objects.Player;
import com.example.brutus729.campionatlliga.objects.Ranking;
import com.example.brutus729.campionatlliga.objects.Team;
import com.example.brutus729.campionatlliga.persistance.TeamsDataSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RankingsFragment extends Fragment {


    private List items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rankings_layout, container, false);

        ListView listView = (ListView) view.findViewById(R.id.rankings_list_view);

        setItemsNoDb();

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
                Ranking item = (Ranking)items.get(position);
                Toast.makeText(getActivity(), item.getTeamName() + " Clicked!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        */
        return view;
    }

    /**
     * Crea items vacia y la llena con datos generados manualmente.
     * Clase para hacer pruebas sin usar la DB.
     */
    private void setItemsNoDb(){
        this.items = new ArrayList();
        for(int i = 0; i < 10; ++i)
            items.add(new Ranking("Equip"+i, 25-5*(i%2)+(i%3)-(i%4),
                    12+5*(i%2)-(i%3), 10+(i%4), (37*2 + (13*i%3))));
        randomQuickSortItems();
    }

    /**
     * Crea items con los datos de la DB.
     */
    private void setItemsFromDb(ViewGroup container){
        TeamsDataSource dataSource = new TeamsDataSource(container.getContext());
        //Cursor con TODA la info de la tabla de TeamsFragment
        Cursor allTeams = dataSource.getAllTeams();
        List<Team> teams = new ArrayList();
        //Recorrer items cursor
        if (allTeams.moveToFirst()){
            //Cojer datos cursor (y ponerlos en items)
            while(!allTeams.isAfterLast()){
                //TODO: ACONSEGUIR GOLS I ARRAY DE PLAYERS DE LA DB!!
                //TODO: FER LA RECOLLIDA DE DADES EN UNA CLASSE MES GENERAL QUE RETORNI DIRECTAMENT ELS EQUIPS/JUGADORS ETC!!! (
                teams.add(new Team(
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
                        ),
                        0,
                        new ArrayList<Player>()
                ));
                allTeams.moveToNext();
            }
        }
        allTeams.close();
        this.items = new ArrayList();
        //TODO: agafar partits guanyats perduts i tot de les jornades!!!
        for(int i = 0; i < 10; ++i)
            items.add(new Ranking(teams.get(i).getTeamsName(), 25-5*(i%2)+(i%3)-(i%4),
                    12+5*(i%2)-(i%3), 10+(i%4), (37*2 + (13*i%3))));
        randomQuickSortItems();
    }

    private void randomQuickSortItems(){
        long seed = System.nanoTime();
        Collections.shuffle(this.items, new Random(seed));
        quickSortItems(0, this.items.size()-1);
    }

    private void quickSortItems(int lo, int hi){
        if(lo < hi){
            int p = partitionItems(lo, hi);
            quickSortItems(lo, p-1);
            quickSortItems(p+1, hi);
        }
    }

    private int partitionItems(int lo, int hi){
        Ranking pivot = (Ranking)items.get(hi);
        int i = lo;
        for(int j = lo; j < hi; ++j){
            if(!compare((Ranking)items.get(j), pivot)){
                Ranking tmp = (Ranking)items.get(j);
                items.set(j, items.get(i));
                items.set(i, tmp);
                ++i;
            }
        }
        Ranking tmp = (Ranking)items.get(i);
        items.set(i, items.get(hi));
        items.set(hi, tmp);
        return i;
    }

    /**
     * Comparador dos Rankings
     * @param a
     * @param b
     * @return true si a <= b
     */
    private boolean compare(Ranking a, Ranking b){
        if(a.getScore() < b.getScore()) return true;
        else if(a.getScore() == b.getScore()){
            if(a.getWins() < b.getWins()) return true;
            else if(a.getWins() == b.getWins()){
                if(a.getDraws() < b.getDraws()) return true;
                else if(a.getDraws() == b.getDraws()){
                    if(a.getGoals() <= b.getGoals()) return  true;
                }
            }
        }
        return false;
    }

}