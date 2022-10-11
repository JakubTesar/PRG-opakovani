package cz.educanet.TeamBuilder;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
@Named
@ApplicationScoped
public class Team {
    private ArrayList<String> teamPlayer = new ArrayList<>();;
    public ArrayList<String> getTeamPlayer() {
        return teamPlayer;
    }
    public void setTeamPlayer(ArrayList<String> teamPlayer) {
        this.teamPlayer = teamPlayer;
    }
}
