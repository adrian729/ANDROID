package com.example.brutus729.campionatlliga.objects;


import java.util.List;
import java.util.Objects;

public class Team {


    private String name;
    private String short_name;
    private String city;
    private String shield;

    public Team
            (String team_name, String short_name, String city, String shield){
        this.name = team_name;
        this.short_name = short_name;
        this.city = city;
        this.shield = shield;
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

}
