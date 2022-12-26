package cz.educanet.gapminder;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class GapminderRepository {
    private List<GapminderBean> gM = new ArrayList<>();

    public List<GapminderBean> getGM() {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3309/gapminder?user=root&password=heslo");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM gapminder")
        ) {
            while (resultSet.next()) {
                gM.add(new GapminderBean(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getDouble(5),
                        resultSet.getInt(6),
                        resultSet.getDouble(7),
                        resultSet.getString(8),
                        resultSet.getInt(9)
                ));
            }

            return gM;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
