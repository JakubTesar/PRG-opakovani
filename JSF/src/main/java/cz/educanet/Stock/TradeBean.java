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

public class TradeBean {
    public void createTrade(int amount, int price, int orderDir) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO stock_market.`trade` (trade_id, amount, price, stock_market_id, created_at)" +
                                "VALUES ( ?, ?, ?, ?, ?)");
        ) {
            preparedStatement.setInt(1, orderDir);
            preparedStatement.setInt(2, amount);
            preparedStatement.setInt(3, price);
            preparedStatement.setInt(4, Integer.parseInt(getStockIDParam()));
            preparedStatement.setString(5, LocalDateTime.now().toString());
           preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Trade> getTrade() {
        ArrayList<Trade> trades = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT t.trade_id, amount, price, stock_market_id, created_at " +
                                "FROM stock_market.trade t " +
                                "WHERE t.stock_market_id = ?");

        ) {
            preparedStatement.setInt(1, Integer.parseInt(getStockIDParam()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Trade t = new  Trade();
                t.setTradeID(resultSet.getInt(1));
                t.setAmount(resultSet.getInt(2));
                t.setPrice(resultSet.getInt(3));
                t.setStockMarketID(resultSet.getInt(4));
                t.setCreatedAt(resultSet.getString(5));

                trades.add(t);
            }
            return trades;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getStockIDParam() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return params.get("stockMarketID");
    }

}
