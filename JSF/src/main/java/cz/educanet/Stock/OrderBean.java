package cz.educanet.Stock;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
@Named

public class OrderBean {
    public void createOrder(int amount, int price, int orderDir) {
        try (Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
             PreparedStatement pS = c.prepareStatement(
                     "INSERT INTO stock_market.`order` (order_direction, amount, price, stock_market_id, created_at)" +
                             "VALUES ( ?, ?, ?, ?, ?)");) {
            pS.setInt(1, orderDir);
            pS.setInt(2, amount);
            pS.setInt(3, price);
            pS.setInt(4, Integer.parseInt(getStockIDParam()));
            pS.setString(5, LocalDateTime.now().toString());
            pS.execute();
            Order o = new Order();
            o.setPrice(price);
            o.setCreatedAt(LocalDateTime.now().toString());
            o.setOrderDirection(orderDir == 1 ? "SELL" : "BUY");
            o.setAmount(amount);
            o.setStockMarketID(Integer.parseInt(getStockIDParam()));
            transferToTrade(o);
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
    public List<Order> getSell(){
        return getOrder().stream().filter(i ->i.getOrderDirection().equals("SELL")).collect(Collectors.toList());
    }
    public List<Order> getBuy(){
        return getOrder().stream().filter(i ->i.getOrderDirection().equals("BUY")).collect(Collectors.toList());
    }
    public String getStockIDParam() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return params.get("stockMarketID");
    }
    // SELL 20ks za 99€     X
    // BUY  20ks za 100€    X
    // TRADE 20ks za 100€   Z
    // SELL 20ks za 99€     Z
    // BUY  5ks za 100€     X
    // TRADE 5ks za 100€    Z
    // SELL 20ks za 99€     X
    // BUY  25ks za 100€    Z
    // TRADE 20ks za 100€    Z
    public void transferToTrade(Order o) {
        List<Order> buys = getOrder().stream().filter(i -> i.getOrderDirection().equals("BUY")).toList();
        List<Order> sells = getOrder().stream().filter(i -> i.getOrderDirection().equals("SELL")).toList();
        TradeBean tB = new TradeBean();
        /*  for (Order s : sells) {
            for (Order b : buys) {
                if (s.getPrice() <= b.getPrice()) {
                    tB.createTrade(b.getAmount(), b.getPrice());
                    if (s.getAmount() == b.getAmount()) {
                        deleteOrder(s.getOrderID());
                        deleteOrder(b.getOrderID());
                        break;
                    } else if (s.getAmount() < b.getAmount()) {
                        deleteOrder(s.getOrderID());
                        updateOrder(b.getPrice(), b.getAmount() - s.getAmount(), b.getOrderID());
                        break;
                    } else {
                        deleteOrder(b.getOrderID());
                        updateOrder(s.getPrice(), s.getAmount() - b.getAmount(), s.getOrderID());
                        break;

                    }
                }
            }
        }*/
        //SELL = 1
        //BUY = 2
        if (o.getOrderDirection().equals("BUY")) {
            for (Order s : sells) {
                if (s.getPrice() <= o.getPrice()) {
                    tB.createTrade(o.getAmount(), o.getPrice());
                    if (s.getAmount() == o.getAmount()) {
                        deleteOrder(s.getOrderID());
                        deleteOrder(o.getOrderID());
                        break;
                    } else if (s.getAmount() < o.getAmount()) {
                        deleteOrder(s.getOrderID());
                        updateOrder(o.getPrice(), o.getAmount() - s.getAmount(), o.getOrderID());
                        break;
                    } else {
                        deleteOrder(o.getOrderID());
                        updateOrder(s.getPrice(), s.getAmount() - o.getAmount(), s.getOrderID());
                        break;
                    }
                }
            }
        } else{
            for (Order b : buys) {
                if (b.getPrice() >= o.getPrice()) {
                    tB.createTrade(b.getAmount(), o.getPrice());
                    if (b.getAmount() == o.getAmount()) {
                        deleteOrder(b.getOrderID());
                        deleteOrder(o.getOrderID());
                        break;
                    } else if (b.getAmount() < o.getAmount()) {
                        deleteOrder(b.getOrderID());
                        updateOrder(o.getPrice(), o.getAmount() - b.getAmount(), o.getOrderID());
                        break;
                    } else {
                        deleteOrder(o.getOrderID());
                        updateOrder(b.getPrice(), b.getAmount() - o.getAmount(), b.getOrderID());
                        break;
                    }
                }
            }
        }
    }


    public void deleteOrder(int id) {
        try (Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
             PreparedStatement pS = c.prepareStatement(
                     "DELETE FROM stock_market.order " +
                             "WHERE `order`.order_id = ?;")) {
            pS.setInt(1, id);
            pS.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateOrder(int price, int amount, int orderID) {
        try (Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
             PreparedStatement pS = c.prepareStatement(
                     "UPDATE stock_market.order " +
                             "SET price = ?, amount = ? " +
                             "WHERE order_id = ?")) {
            pS.setInt(1, price);
            pS.setInt(2, amount);
            pS.setInt(3, orderID);
            pS.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
