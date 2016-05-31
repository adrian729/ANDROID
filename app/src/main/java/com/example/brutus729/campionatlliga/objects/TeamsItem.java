package com.example.brutus729.campionatlliga.objects;


public class TeamsItem {


    private String name;
    private String short_name;
    private String city;

    public TeamsItem(){
        super();
    }

    public TeamsItem(String team_name, String short_name, String city){
        super();
        this.name = team_name;
        this.short_name = short_name;
        this.city = city;
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

}
