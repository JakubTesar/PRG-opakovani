package cz.educanet.Hero;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ApplicationScoped

public class HeroBean {
    private String btnValue = "all";

    public void btnSet(String btnValue) {
        this.btnValue = btnValue;
    }

    public Map<String, Integer> getPublisher() {
        Map<String, Integer> publishers = new HashMap<>();

        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/Zoo?user=root&password=heslo");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT p.publisher_name, COUNT(s.superhero_name) sCount" +
                                "                       FROM superhero.publisher p " +
                                "                       JOIN superhero.superhero s ON (p.id = s.publisher_id)" +
                                "                       GROUP BY p.publisher_name");
        ) {
            preparedStatement.setString(1, btnValue);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                publishers.put(resultSet.getString(1), resultSet.getInt(2));
            }

            return publishers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Hero> getHeroes() {
        ArrayList<Hero> list = new ArrayList<>();
            try (
                    Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/Zoo?user=root&password=heslo");
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "SELECT h.superhero_name ,h.full_name, g.gender,r.race,a.alignment" +
                                    " FROM superhero.superhero h " +
                                    "JOIN superhero.gender g ON (g.id = h.gender_id)" +
                                    "JOIN superhero.race r ON (r.id = h.race_id)" +
                                    "JOIN superhero.alignment a ON (a.id = h.alignment_id)" +
                                    "JOIN superhero.publisher pub ON (pub.id = h.publisher_id)" +
                                    "WHERE pub.publisher_name LIKE ?"
                    );
            ) {
                preparedStatement.setString(1, btnValue);
                ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Hero(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5))

                );
            }

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
