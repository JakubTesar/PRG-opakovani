public class State {
    private String name;
    private long gdp;
    private long population;
    private String continent;

    public State(String name, long gdp, long population, String continent) {
        this.name = name;
        this.gdp = gdp;
        this.population = population;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public long getGdp() {
        return gdp;
    }

    public long getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }
}
