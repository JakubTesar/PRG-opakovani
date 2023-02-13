package cz.educanet.Stock;

import cz.educanet.Hero.Hero;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jdk.jfr.Name;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Named
@ApplicationScoped
public class StockBean {

    public void createStock(String ticker, String description) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO stock_market.stock_market ( ticker_symbol, descriptive_name)" +
                                "VALUES (?, ?)");
        ) {

            preparedStatement.setString(1, ticker);
            preparedStatement.setString(2, description);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Stock> getStock() {
        ArrayList<Stock> list = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT s.stock_market_id, " +
                                "s.ticker_symbol, " +
                                "s.descriptive_name " +
                                "FROM stock_market.stock_market s ");
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Stock stock = new Stock();
                stock.setStockMarketID(resultSet.getInt(1));
                stock.setTickerSymbol(resultSet.getString(2));
                stock.setDescriptiveName(resultSet.getString(3));
                list.add(stock);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStock(int id) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM stock_market.stock_market " +
                                "WHERE stock_market_id = ?;")) {
            preparedStatement.setInt(1, id);
            Boolean ok = preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStock(String ticker, String desc) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE  stock_market.stock_market " +
                                "SET  ticker_symbol = ?, descriptive_name = ?" +
                                "WHERE stock_market_id = ?");) {
            preparedStatement.setInt(3, Integer.parseInt(getIDParam()));
            preparedStatement.setString(1, ticker);
            preparedStatement.setString(2, desc);
            Boolean ok = preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getIDParam() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return params.get("stockMarketID");
    }
}
