package cz.educanet.TeamBuilder;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@ApplicationScoped
@Named

public class TeamBuilder {
    private ArrayList<Team> teamArrayList = new ArrayList<>();
    private int teamsN;
    private String playersInput = "";

    //cz.educanet.TeamBuilder.Team.getTeamPlayer()"
    public void createTeams() {
        String[] inputS = playersInput.split(",");
        ArrayList<String> lidi = new ArrayList<>(Arrays.asList(inputS));
        Collections.shuffle(lidi);
        int count = 0;
        for (int i = 0; i < teamsN; i++) {
            Team team = new Team();
            teamArrayList.add(team);
            for (int j = 0; j < (inputS.length/teamsN); j++) {
                teamArrayList.get(i).getTeamPlayer().add(lidi.get(count));
                count++;
            }
        }
    }

    public ArrayList<Team> getTeamArrayList() {
        createTeams();
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
