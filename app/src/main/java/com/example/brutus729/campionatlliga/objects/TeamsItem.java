package com.example.brutus729.campionatlliga.objects;

/**
 * Created by brutus729 on 30/05/16.
 */
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
