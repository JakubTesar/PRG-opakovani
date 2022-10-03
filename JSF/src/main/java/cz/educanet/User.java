package cz.educanet;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;


@RequestScoped
@Named
public class User {

    private int age;
    private String firstName;
    private String secondName;
    private boolean longTimeClient;

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public boolean isLongTimeClient() {
        return longTimeClient;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLongTimeClient(boolean longTimeClient) {
        this.longTimeClient = longTimeClient;
    }

}
