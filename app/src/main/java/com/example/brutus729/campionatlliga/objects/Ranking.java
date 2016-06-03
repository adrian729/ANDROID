package com.example.brutus729.campionatlliga.objects;


public class Ranking {


    private String team_name;
    private int played_games;
    private int wins;
    private int draws;
    private int loses;
    private int goals;
    private int score;

    public Ranking(String team, int wins,
                   int draws, int loses, int goals) {
        this.team_name = team;
        this.played_games = wins + draws + loses;
        this.wins = wins;
        this.draws = draws;
        this.loses = loses;
        this.goals = goals;
        this.score = 3*wins + draws;
    }

    public String getTeamName() {
        return team_name;
    }

    public void setTeamName(String name) {
        this.team_name = name;
    }

    public int getPlayedGames() {
        return played_games;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
        updatePlayedGames();
        updateScore();
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
        updatePlayedGames();
        updateScore();
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
        updatePlayedGames();
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getScore() {
        return score;
    }

    private void updatePlayedGames(){
        this.played_games = wins + draws + loses;
    }

    private void updateScore(){
        this.score = 3*wins + draws;
    }

}
