package cz.educanet.Grafiky;

import cz.educanet.Hero.Hero;

import java.sql.*;
import java.util.ArrayList;

public class HDP {
    public static void main(String[] args) {
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
