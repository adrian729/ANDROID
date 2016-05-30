package com.example.brutus729.campionatlliga.objects;


public class TeamsItem {


    private String name;

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

}
