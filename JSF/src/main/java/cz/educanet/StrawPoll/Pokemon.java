package cz.educanet.StrawPoll;

public class Pokemon {
    private String name;
    private int counter = 0;

    public String getName() {
        return name;
    }

    public Pokemon(String name, int counter) {
        this.name = name;
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
