package cz.educanet.gapminder;

public class Continent {
    private String name;
    private int totalLife;
    private double total;

    public Continent(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public int getTotalLife() {
        return totalLife;
    }

    public double getTotal() {
        return total;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalLife(int totalLife) {
        this.totalLife = totalLife;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
