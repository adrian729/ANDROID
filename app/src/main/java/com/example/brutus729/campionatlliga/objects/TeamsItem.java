package com.example.brutus729.campionatlliga.objects;


public class TeamsItem {


    private String name;
    private String short_name;

    public TeamsItem(){
        super();
    }

    public TeamsItem(String team_name){
        super();
        this.name = team_name;
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
}
