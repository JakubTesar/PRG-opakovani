package cz.educanet.Factorial;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Named
@ApplicationScoped

public class Factorial {
    private int number;
    private Pog p = new Pog();
    private int factorial = 1;
    private int fakeFactorial = 1;
    private LocalDateTime date;

    public void calculateFactorial() {
        for (int i = 1; i < number + 1; i++) {
            fakeFactorial = fakeFactorial * i;
        }
        this.factorial = fakeFactorial;
        Factorial f1 = new Factorial();
        f1.setFactorial(factorial);
        this.fakeFactorial = 1;
        f1.setNumber(number);
        f1.setDate(LocalDateTime.now());
        p.getListFac().add(f1);
    }

    public void deleteFac() {

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFactorial() {
        return factorial;
    }

    public void setFactorial(int factorial) {
        this.factorial = factorial;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Pog getP() {
        return p;
    }

    public void setP(Pog p) {
        this.p = p;
    }

    public int getFakeFactorial() {
        return fakeFactorial;
    }

    public void setFakeFactorial(int fakeFactorial) {
        this.fakeFactorial = fakeFactorial;
    }
}


