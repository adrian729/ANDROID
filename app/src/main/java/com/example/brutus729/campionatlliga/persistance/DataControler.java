package com.example.brutus729.campionatlliga.persistance;


import android.content.Context;
import android.database.Cursor;

import com.example.brutus729.campionatlliga.objects.Goals;
import com.example.brutus729.campionatlliga.objects.Match;
import com.example.brutus729.campionatlliga.objects.Player;
import com.example.brutus729.campionatlliga.objects.Ranking;
import com.example.brutus729.campionatlliga.objects.Team;
import com.example.brutus729.campionatlliga.objects.Week;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataControler {
    //TODO: possar en aquesta classe la recollida de dades!!!


    private List<Team> teams;
    private List<Week> weeks;
    private List<Ranking> ranking;

    private TeamsDataSource teamsDS;
    private PlayersDataSource playersDS;
    private MatchesDataSource matchesDS;
    private GoalsDataSource goalsDS;

    public DataControler(Context context){
        super();

        teamsDS = new TeamsDataSource(context);
        playersDS = new PlayersDataSource(context);
        matchesDS = new MatchesDataSource(context);
        goalsDS = new GoalsDataSource(context);

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                        //Get Matches.
                        Cursor matchesCursor = matchesDS.getAllMatches();
                        List<Match> matches = new ArrayList<>();// TEMPORAL!!! S'ELIMINA EL CONTINGUT I ES POSSA A matchesWeek QUAN ES CREA AQUEST!!!
                        List<Integer> matchesWeekNum = new ArrayList<>();
                        //Recorrer items cursor
                        if (matchesCursor.moveToFirst()){
                            //Cojer datos cursor (y ponerlos en items)
                            while(!matchesCursor.isAfterLast()){
                                matches.add(new Match(
                                        matchesCursor.getString(matchesCursor.getColumnIndex(
                                                MatchesDataSource.ColumnMatches.LOCAL_TEAM_MATCHES)
                                        ),
                                        matchesCursor.getString(matchesCursor.getColumnIndex(
                                                MatchesDataSource.ColumnMatches.VISITOR_TEAM_MATCHES)
                                        ),
                                        new ArrayList<Goals>()
                                ));
                                matchesWeekNum.add(matchesCursor.getInt(matchesCursor.getColumnIndex(
                                        MatchesDataSource.ColumnMatches.WEEK_MATCHES)
                                ));
                                matchesCursor.moveToNext();
                            }
                        }
                        matchesCursor.close();
                        List<List<Match>> matchesWeek = new ArrayList<>(matches.size()/5);
                        for(int i = 0; i < matchesWeek.size(); ++i){
                            for(int k = 0; k < matches.size(); ++k){
                                if(matchesWeekNum.get(k) == i+1){
                                    matchesWeek.get(i).add(matches.get(k));
                                    matches.remove(k);
                                }
                            }
                        }

                        //Get goals
                        Cursor goalsCursor = goalsDS.getAllGoals();
                        //Recorrer items cursor
                        if (goalsCursor.moveToFirst()){
                            //Cojer datos cursor (y ponerlos en items)
                            while(!goalsCursor.isAfterLast()){
                                int week = goalsCursor.getInt(goalsCursor.getColumnIndex(
                                        GoalsDataSource.ColumnGoals.WEEK_GOALS));
                                String teamGoals = goalsCursor.getString(goalsCursor.getColumnIndex(
                                        GoalsDataSource.ColumnGoals.TEAM_GOALS));
                                Goals goals = new Goals(
                                        goalsCursor.getString(goalsCursor.getColumnIndex(
                                                GoalsDataSource.ColumnGoals.PLAYER_GOALS)),
                                        teamGoals,
                                        goalsCursor.getInt(goalsCursor.getColumnIndex(
                                                GoalsDataSource.ColumnGoals.NUM_GOALS))
                                );
                                for(int i = 0; i < 5; ++i){
                                    if(Objects.equals(matchesWeek.get(week).get(i).getLocalTeam(), teamGoals) ||
                                            Objects.equals(matchesWeek.get(week).get(i).getVisitorTeam(), teamGoals)){
                                        matchesWeek.get(week).get(i).setPlayerGoals(
                                                goals);
                                    }
                                }
                                goalsCursor.moveToNext();
                            }
                        }
                        goalsCursor.close();

                        //Create Weeks
                        weeks = new ArrayList<>();
                        for(int i = 0; i < matchesWeek.size(); ++i){
                            weeks.add(new Week(i+1, matchesWeek.get(i)));
                        }

                        //Get players
                        Cursor playersCursor = playersDS.getAllPlayers();
                        List<Player> players = new ArrayList<>();
                        //Recorrer items cursor
                        if (playersCursor.moveToFirst()){
                            //Cojer datos cursor (y ponerlos en items)
                            while(!playersCursor.isAfterLast()){
                                String player_name = playersCursor.getString(playersCursor.getColumnIndex(
                                        PlayersDataSource.ColumnPlayers.NAME_PLAYERS));
                                String player_team = playersCursor.getString(playersCursor.getColumnIndex(
                                        PlayersDataSource.ColumnPlayers.TEAM_PLAYERS));
                                playersCursor.moveToNext();
                                int player_goals = 0;
                                for(int i = 0; i < matchesWeek.size(); ++i){
                                    for(int k = 0; k < matchesWeek.get(i).size(); ++k){
                                        List<Goals> tmpPlayerGoals = matchesWeek.get(i).get(k).getListGoals();
                                        for(int l = 0; l < tmpPlayerGoals.size(); ++l){
                                            Goals tmpGoals = tmpPlayerGoals.get(l);
                                            if(Objects.equals(tmpGoals.getPlayer(), player_name) &&
                                                    Objects.equals(tmpGoals.getTeam(), player_team)){
                                                player_goals += tmpGoals.getNumGoals();
                                            }
                                        }
                                    }
                                }

                                players.add(
                                        new Player(
                                                player_name,
                                                playersCursor.getString(playersCursor.getColumnIndex(
                                                        PlayersDataSource.ColumnPlayers.SHORT_NAME_PLAYERS)),
                                                player_team,
                                                player_goals,
                                                (0 != playersCursor.getInt(playersCursor.getColumnIndex(
                                                        PlayersDataSource.ColumnPlayers.TITULAR_PLAYERS)))
                                        )
                                );

                            }
                        }
                        playersCursor.close();

                        //Get teams

                        //TODO: Get teams, Get Rankings
                    }
                }
        ).start();

    }

    //TODO: getters i setters!!!!!!!!!!!!!!
}
