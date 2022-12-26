package cz.educanet.Euro2012;

import cz.educanet.World.beans.World;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jdk.jfr.Name;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named
@ApplicationScoped

public class TeamService {
    public String getIDParam() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return params.get("id");
    }

    public List<Team> getTeams() {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3309/euro2012?user=root&password=heslo");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM eteam")
        ) {
            ArrayList<Team> teams = new ArrayList<>();
            while (resultSet.next()) {
                teams.add(new Team(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }
            return teams;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Game> getGames() {
        List<Team> fTeam = getTeams().stream().filter(i -> i.getId().equals(getIDParam())).collect(Collectors.toList());
        Team t = fTeam.get(0);
        String idTeam = t.getId();
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3309/euro2012?user=root&password=heslo");
            PreparedStatement statement = connection.prepareStatement(
                    """
                            SELECT * 
                            FROM game g 
                            WHERE (g.team1 = ?) OR (g.team2 = ?)
                            """);

            statement.setString(1, idTeam);
            statement.setString(2, idTeam);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Game> games = new ArrayList<>();
            while (resultSet.next()) {
                games.add(new Game(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));
            }
            connection.close();
            return games;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Game> getAllGames() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3309/euro2012?user=root&password=heslo");
            PreparedStatement statement = connection.prepareStatement(
                    """
                            SELECT * 
                            FROM game g
                            """);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Game> games = new ArrayList<>();
            ArrayList<Goal> goals = new ArrayList<>();
            while (resultSet.next()) {
                games.add(new Game(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));
            }
            PreparedStatement statement2 = connection.prepareStatement(
                    """
                            SELECT * 
                            FROM goal goal
                            """);
            ResultSet resultSet2 = statement.executeQuery();
            while (resultSet2.next()) {
                goals.add(new Goal(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
            for (Goal g : goals) {

            }
            connection.close();
            return games;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Goal> getGoals() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3309/euro2012?user=root&password=heslo");
            PreparedStatement statement = connection.prepareStatement(
                    """
                            SELECT * 
                            FROM goal g
                            """);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Goal> goals = new ArrayList<>();
            while (resultSet.next()) {
                goals.add(new Goal(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
            connection.close();
            return goals;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
