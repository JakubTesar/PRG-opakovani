package cz.educanet.Kchul_Zoo;

import cz.educanet.gapminder.GapminderBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.criteria.CriteriaBuilder;
import jdk.jfr.Name;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ApplicationScoped
public class ZooRepository {
    private List<GapminderBean> gM = new ArrayList<>();
    public List<String> getOte() {
        ArrayList<String> osetrovatele = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3309/Zoo?user=root&password=heslo");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT ote.jmeno FROM Osetrovatele ote ")
        ) {
            while (resultSet.next()) {
                osetrovatele.add(resultSet.getString(1));
            }
            return osetrovatele;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Map<String, Integer> getOteCountZvirata() {
        Map<String, Integer> oteCount = new HashMap<>();
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3309/Zoo?user=root&password=heslo");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT ote.jmeno, COUNT(z.id)" +
                        "FROM Osetrovatele ote " +
                        "JOIN Osetruje oje ON (ote.id = oje.osetrovatel)" +
                        "JOIN Zvirata z ON (z.id = oje.zvire)" +
                        "GROUP BY ote.jmeno")
        ) {
            while (resultSet.next()) {
                oteCount.put(resultSet.getString(1),resultSet.getInt(2));
            }
            return oteCount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
