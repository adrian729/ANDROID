package com.example.brutus729.campionatlliga.objects;

/**
 * Created by brutus729 on 29/05/16.
 */
public class RankingsItem {


    private String team_name;
    private int played_games;
    private int wins;
    private int draws;
    private int loses;
    private int goals;
    private int score;

    public RankingsItem() {
        super();
    }

    public RankingsItem(String team, int wins,
                        int draws, int loses, int goals) {
        super();
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

    public String getPlayedGames() {
        return String.valueOf(played_games);
    }

    public String getWins() {
        return String.valueOf(wins);
    }

    public void setWins(int wins) {
        this.wins = wins;
        updatePlayedGames();
        updateScore();
    }

    public String getDraws() {
        return String.valueOf(draws);
    }

    public void setDraws(int draws) {
        this.draws = draws;
        updatePlayedGames();
        updateScore();
    }

    public String getLoses() {
        return String.valueOf(loses);
    }

    public void setLoses(int loses) {
        this.loses = loses;
        updatePlayedGames();
    }

    public String getGoals() {
        return String.valueOf(goals);
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public String getScore() {
        return String.valueOf(score);
    }

    private void updatePlayedGames(){
        this.played_games = wins + draws + loses;
    }

    private void updateScore(){
        this.score = 3*wins + draws;
    }

}
