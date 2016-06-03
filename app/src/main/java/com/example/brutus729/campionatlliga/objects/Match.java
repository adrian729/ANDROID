package com.example.brutus729.campionatlliga.objects;


import java.util.List;

public class Match {

    private String local_team;
    private String visitor_team;
    private List<Goals> goals;
    private int total_goals_local;
    private int total_goals_visitor;

    public Match(String local_team, String visitor_team, List<Goals> goals){
        this.local_team = local_team;
        this.visitor_team = visitor_team;
        this.goals = goals;

        //Possar gols local i visitant.
        total_goals_local = total_goals_visitor = 0;
        for(int i = 0; i < goals.size(); ++i){
            if(goals.get(i).getTeam() == local_team)
                total_goals_local += goals.get(i).getNumGoals();
            else total_goals_visitor += goals.get(i).getNumGoals();
        }
    }

    public String getLocalTeam() {
        return local_team;
    }

    public void setLocalTeam(String local_team) {
        this.local_team = local_team;
    }

    public String getVisitorTeam() {
        return visitor_team;
    }

    public void setVisitorTeam(String visitor_team) {
        this.visitor_team = visitor_team;
    }

    public List<Goals> getListGoals(){
        return goals;
    }

    public void setListGoals(List<Goals> goals){
        this.goals = goals;
        //Possar gols local i visitant.
        total_goals_local = total_goals_visitor = 0;
        for(int i = 0; i < goals.size(); ++i){
            if(goals.get(i).getTeam() == local_team)
                total_goals_local += goals.get(i).getNumGoals();
            else total_goals_visitor += goals.get(i).getNumGoals();
        }
    }

    public int getTotalGoalsLocal() {
        return total_goals_local;
    }

    public int getTotalGoalsVisitor() {
        return total_goals_visitor;
    }

    public void setPlayerGoals(Goals playerGoals){
        for(int i = 0; i < goals.size(); ++i) {
            if (goals.get(i).getTeam() == playerGoals.getTeam() &&
                    goals.get(i).getPlayer() == playerGoals.getPlayer()) {
                if(goals.get(i).getTeam() == local_team)
                    total_goals_local -= goals.get(i).getNumGoals();
                else total_goals_visitor -= goals.get(i).getNumGoals();
                goals.remove(i);
                break;
            }
        }
        goals.add(playerGoals);
        if(playerGoals.getTeam() == local_team)
            total_goals_local += playerGoals.getNumGoals();
        else total_goals_visitor += playerGoals.getNumGoals();
    }

}
