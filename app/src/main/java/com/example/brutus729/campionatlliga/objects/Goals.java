package com.example.brutus729.campionatlliga.objects;


public class Goals {

    private String player;
    private String team;
    private int num_goals;

    public Goals(String player, String team, int num_goals){
        this.num_goals = num_goals;
        this.team = team;
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getNumGoals() {
        return num_goals;
    }

    public void setNumGoals(int num_goals) {
        this.num_goals = num_goals;
    }

}
