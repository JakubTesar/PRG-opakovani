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
    private ArrayList<Team> teamArrayList = new ArrayList<>();
    private int teamsN;
    private String playersInput;

    //cz.educanet.TeamBuilder.Team.getTeamPlayer()"
    public void createTeams() {
        String[] a = playersInput.split(",");
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            Team team = new Team();
            Random rand = new Random();
            list.add(a[i]);
           // if (i == (a.length / teamsN)) {
                team.getTeamPlayer().add(a[i]);
                team.setTeamPlayer(list);
            //}
            teamArrayList.add(team);

        }

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
