package cz.educanet.StrawPoll;

public class Pokemon {
    private String name;
    private int counter = 0;
    private String image;

    public String getName() {
        return name;
    }

    public Pokemon(String name, int counter, String image) {
        this.name = name;
        this.counter = counter;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
