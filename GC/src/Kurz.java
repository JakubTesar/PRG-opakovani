import java.util.ArrayList;

public class Kurz {
    private String name;
    private String description;
    private ArrayList<EpicClass> list;

    public Kurz(String name, String description, ArrayList<EpicClass> list) {
        this.name = name;
        this.description = description;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<EpicClass> getList() {
        return list;
    }

}