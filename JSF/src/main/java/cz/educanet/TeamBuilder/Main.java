package cz.educanet.TeamBuilder;

public class Main {
    public static void main(String[] args) {
        TeamBuilder tb = new TeamBuilder();
        tb.setPlayersInput("vojta,pepa,jouda,Kuba,lol,Sam");
        tb.setTeamsN(3);
        tb.createTeams();
    }
}
