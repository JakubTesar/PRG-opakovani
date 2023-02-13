package cz.educanet.Stock;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

@ApplicationScoped
@Named

public class OrderBean {
    public void createOrder(int amount, int price, int orderDir) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO stock_market.`order` (order_direction, amount, price, stock_market_id, created_at)" +
                                "VALUES ( ?, ?, ?, ?, ?)");
        ) {
            preparedStatement.setInt(1, orderDir);
            preparedStatement.setInt(2, amount);
            preparedStatement.setInt(3, price);
            preparedStatement.setInt(4, Integer.parseInt(getStockIDParam()));
            preparedStatement.setString(5, LocalDateTime.now().toString());
            Boolean ok = preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Order> getOrder() {
        ArrayList<Order> orders = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT  o.order_id, od.descriptive_name , o.amount, o.price, o.stock_market_id, o.created_at " +
                                "FROM stock_market.`order` o " +
                                "JOIN stock_market.order_direction od ON (od.order_direction_id = o.order_direction)" +
                                "WHERE o.stock_market_id = ?");

        ) {
            preparedStatement.setInt(1, Integer.parseInt(getStockIDParam()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order o = new Order();
                o.setOrderID(resultSet.getInt(1));
                o.setOrderDirection(resultSet.getString(2));
                o.setAmount(resultSet.getInt(3));
                o.setPrice(resultSet.getInt(4));
                o.setStockMarketID(resultSet.getInt(5));
                o.setCreatedAt(resultSet.getString(6));

                orders.add(o);
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getStockIDParam() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return params.get("stockMarketID");
    }

}
