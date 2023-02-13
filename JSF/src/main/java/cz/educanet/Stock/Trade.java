package cz.educanet.Stock;

import java.time.LocalDateTime;

public class Trade {
    private int tradeID;
    private int amount;
    private int price;
    private int stockMarketID;
    private String createdAt;

    public int getTradeID() {
        return tradeID;
    }

    public void setTradeID(int tradeID) {
        this.tradeID = tradeID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockMarketID() {
        return stockMarketID;
    }

    public void setStockMarketID(int stockMarketID) {
        this.stockMarketID = stockMarketID;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
