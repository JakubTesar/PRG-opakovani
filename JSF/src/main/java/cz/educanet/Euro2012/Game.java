package cz.educanet.Euro2012;

public class Game {
    public String gameID;
    public String date;
    public String stadium;
    public String team1;
    public int goalTeam1;

    public String team2;
    public int goalTeam2;

    public Game(String gameID, String date, String stadium, String team1, String team2) {
        this.gameID = gameID;
        this.date = date;
        this.stadium = stadium;
        this.team1 = team1;
        this.team2 = team2;
    }

    public String getGameID() {
        return gameID;
    }

    public String getDate() {
        return date;
    }

    public String getStadium() {
        return stadium;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public int getGoalTeam1() {
        return goalTeam1;
    }

    public void setGoalTeam1(int goalTeam1) {
        this.goalTeam1 = goalTeam1;
    }

    public int getGoalTeam2() {
        return goalTeam2;
    }

    public void setGoalTeam2(int goalTeam2) {
        this.goalTeam2 = goalTeam2;
    }
}
