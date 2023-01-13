package cz.educanet.Hero;

public class Hero {
    private String pseudonym;
    private String name;
    private String gender;
    private String race;
    private String team;
    public Hero(String pseudonym, String name, String gender, String race, String team) {
        this.pseudonym = pseudonym;
        this.name = name;
        this.gender = gender;
        this.race = race;
        this.team = team;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public String getTeam() {
        return team;
    }
}
