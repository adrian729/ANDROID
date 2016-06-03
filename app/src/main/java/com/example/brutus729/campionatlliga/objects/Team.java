package com.example.brutus729.campionatlliga.objects;


import java.util.List;

public class Team {


    private String name;
    private String short_name;
    private String city;
    private String shield;
    private int total_goals;
    private List<Player> players;

    public Team(String team_name, String short_name, String city, String shield,
                int total_goals, List<Player> players){
        this.name = team_name;
        this.short_name = short_name;
        this.city = city;
        this.shield = shield;
        this.total_goals = total_goals;
        this.players = players;
    }

    public String getTeamsName() {
        return name;
    }

    public void setTeamsName(String team_name) {
        this.name = team_name;
    }

    public String getShortName() {
        return short_name;
    }

    public void setShortName(String short_name) {
        this.short_name = short_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public int getTotalGoals() {
        return total_goals;
    }

    public void setTotalGoals(int total_goals) {
        this.total_goals = total_goals;
    }

    public List<Player> getPlayers() {
        return players;
    }

    //Nomes ho permet si hi ha 5 titulars i 12 jugadors
    public boolean setPlayers(List<Player> players) {
        int numPlayers = players.size();
        if(numPlayers != 12) return false;
        int titularCount = 0;
        for(int i = 0; i < numPlayers; ++i)
            if(players.get(i).isTitular())
                titularCount++;
        if(titularCount == 5) this.players = players;
        else return false;
        return true;
    }

    public boolean changePlayer(String oldPlayerName, Player newPlayer){

        int size = players.size();
        int posOldPlayer = -1;
        for(int i = 0; i < size; i++){
            if(players.get(i).getName() == newPlayer.getName() ||
                    players.get(i).getShortName() == newPlayer.getShortName()){
                return false;
            }
            if(players.get(i).getName() == oldPlayerName) {
                if(players.get(i).isTitular() && newPlayer.isTitular()) {
                    posOldPlayer = i;
                } else {
                    return false;
                }
            }
        }
        //Canvia jugador old pel nou
        players.set(posOldPlayer, newPlayer);

        return true;
    }

}
