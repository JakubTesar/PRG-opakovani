package cz.educanet;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.ArrayList;

@ApplicationScoped
@Named
public class Crm {
    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(String n, String ln, int a, boolean lt) {
        User user = new User();
        user.setAge(a);
        user.setFirstName(n);
        user.setSecondName(ln);
        user.setLongTimeClient(lt);
        users.add(user);
    }

    public void removeUser(int userIndex) {
        users.remove(userIndex);
    }

}
