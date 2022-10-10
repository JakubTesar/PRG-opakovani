package cz.educanet.TeamBuilder;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jdk.jfr.Name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@ApplicationScoped
@Named

public class TeamBuilder {
    private ArrayList<Team> teamArrayList;
    private int teamsN;
    private String playersInput;

    public void createTeams() {
        String[] a = playersInput.split(",");
        for (int i = 0; i < a.length; i++) {
            Team team = new Team();
            Random rand = new Random();
            if (i == (a.length / teamsN)){
                team.getTeamPlayer().add(a[rand.nextInt(teamsN)]);
            }
        }
    }

    public TeamBuilder() {
        this.teamArrayList = new ArrayList<>();
    }

    public ArrayList<Team> getTeamArrayList() {
        return teamArrayList;
    }

    public void setTeamArrayList(ArrayList<Team> teamArrayList) {
        this.teamArrayList = teamArrayList;
    }

    public int getTeamsN() {
        return teamsN;
    }

    public void setTeamsN(int teamsN) {
        this.teamsN = teamsN;
    }

    public String getPlayersInput() {
        return playersInput;
    }

    public void setPlayersInput(String playersInput) {
        this.playersInput = playersInput;
    }
}
