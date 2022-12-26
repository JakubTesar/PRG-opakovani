package cz.educanet.World.beans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

public class World {
    private String name;
    private String continent;
    private float area;
    private float population;
    private float gdp;
    private String capital;
    private String tld;
    private String flag;
    private WorldsBean w = new WorldsBean();

    public World(String name, String continent, float area, float population, float gdp, String capital, String tld, String flag) {
        this.name = name;
        this.continent = continent;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.capital = capital;
        this.tld = tld;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public float getArea() {
        return area;
    }

    public float getPopulation() {
        return population;
    }

    public float getGdp() {
        return gdp;
    }

    public String getCapital() {
        return capital;
    }

    public String getTld() {
        return tld;
    }

    public String getFlag() {
        return flag;
    }


}
