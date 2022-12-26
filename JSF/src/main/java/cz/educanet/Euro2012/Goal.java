package cz.educanet.Euro2012;

public class Goal {
    private String id;
    private String teamName;
    private String player;

    public Goal(String id, String teamName, String player) {
        this.id = id;
        this.teamName = teamName;
        this.player = player;
    }

    public String getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getPlayer() {
        return player;
    }
}
