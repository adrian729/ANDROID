package com.example.brutus729.campionatlliga.objects;


public class Player {

    private String name;
    private String short_name;
    private String team;
    private int goals;
    private boolean titular;

    public Player(String name, String short_name, String team, int goals, boolean titular){
        this.name = name;
        this.short_name = short_name;
        this.team = team;
        this.goals = goals;
        this.titular = titular;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return short_name;
    }

    public void setShortName(String short_name) {
        this.short_name = short_name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void addGoals(int goals_to_add){
        this.goals += goals_to_add;
    }

    public boolean isTitular() {
        return titular;
    }

    public void setTitular(boolean titular) {
        this.titular = titular;
    }
}
