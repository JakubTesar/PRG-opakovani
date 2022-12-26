package cz.educanet.gapminder;

public class GapminderBean {
    private int id;
    private String country;
    private String continent;
    private int year;
    private double lifeExp;
    private int pop;
    private double gdpPerCap;
    private String iso_alpha;
    private int iso_num;

    public GapminderBean(int id, String country, String continent, int year, double lifeExp, int pop, double gdpPerCap, String iso_alpha, int iso_num) {
        this.id = id;
        this.country = country;
        this.continent = continent;
        this.year = year;
        this.lifeExp = lifeExp;
        this.pop = pop;
        this.gdpPerCap = gdpPerCap;
        this.iso_alpha = iso_alpha;
        this.iso_num = iso_num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getLifeExp() {
        return lifeExp;
    }

    public void setLifeExp(double lifeExp) {
        this.lifeExp = lifeExp;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public double getGdpPerCap() {
        return gdpPerCap;
    }

    public void setGdpPerCap(double gdpPerCap) {
        this.gdpPerCap = gdpPerCap;
    }

    public String getIso_alpha() {
        return iso_alpha;
    }

    public void setIso_alpha(String iso_alpha) {
        this.iso_alpha = iso_alpha;
    }

    public int getIso_num() {
        return iso_num;
    }

    public void setIso_num(int iso_num) {
        this.iso_num = iso_num;
    }
}
