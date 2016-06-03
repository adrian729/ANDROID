package com.example.brutus729.campionatlliga.objects;

import java.util.List;


public class Week {

    private int num_week;
    private List<Match> matches;

    public Week(int num_week, List<Match> matches){
        this.num_week = num_week;
        this.matches = matches;
    }

    public int getNumWeek() {
        return num_week;
    }

    public void setNumWeek(int num_week) {
        this.num_week = num_week;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches){
        this.matches = matches;
    }

}
