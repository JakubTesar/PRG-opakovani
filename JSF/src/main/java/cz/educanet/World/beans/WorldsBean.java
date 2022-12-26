package cz.educanet.World.beans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class WorldsBean {
    private String name;
    private String continent;
    private float area;
    private float population;
    private float gdp;
    private String capital;
    private String tld;
    private String flag;
    private List<World> wo = new ArrayList<>();

    public List<World> getWolds() {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3309/world?user=root&password=heslo");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM world")
        ) {
            while (resultSet.next()) {
                wo.add(new World(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getFloat(3),
                        resultSet.getFloat(4),
                        resultSet.getFloat(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8)));
            }

            return wo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public float getArea() {
        return area;
    }

    public float getPopulation() {
        return population;
    }

    public float getGdp() {
        return gdp;
    }

    public String getCapital() {
        return capital;
    }

    public String getTld() {
        return tld;
    }

    public String getFlag() {
        return flag;
    }

    public void filterList() {
        wo = wo.stream().filter(i -> i.getName().contains(getName())).toList();
    }

    public List<World> getW() {
        return wo;
    }
}
