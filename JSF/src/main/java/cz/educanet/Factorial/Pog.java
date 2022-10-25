package cz.educanet.Factorial;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
@Named
@ApplicationScoped

public class Pog {
    private ArrayList<Factorial> listFac = new ArrayList<>();


    public ArrayList<Factorial> getListFac() {
        return listFac;
    }

    public void setListFac(ArrayList<Factorial> listFac) {
        this.listFac = listFac;
    }
    public void removeFactorial(int index) {
        listFac.remove(index);
    }

}
