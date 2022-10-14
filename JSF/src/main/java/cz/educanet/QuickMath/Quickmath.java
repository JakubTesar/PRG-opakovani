package cz.educanet.QuickMath;

import cz.educanet.CRM.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

@Named
@ApplicationScoped

public class Quickmath {
    private final UserQuick tempUser = new UserQuick();
    private String tempNick;
    private ArrayList<UserQuick> users = new ArrayList<>();
    private ArrayList<Sample> samples = new ArrayList<>();
    private final ArrayList<Boolean> answersFalse = new ArrayList<>();
    private final ArrayList<Boolean> answersTrue = new ArrayList<>();
    private String page = "./calculations.xhtml";
    private int countID = 0;
    private Instant start;


    public Quickmath() {
        createSamples();
    }

    public void createSamples() {
        start = Instant.now();
        for (int i = 0; i < 10; i++) {
            Sample s = new Sample();
            samples.add(s);
        }
    }

    public void check() {
        for (Sample s : samples) {
            if (s.getAnswer() == s.getRightAnswer())
                answersTrue.add(false);
            else
                answersFalse.add(true);
        }
        UserQuick u = new UserQuick();
        u.setNickname(tempUser.getNickname());
        u.setPercent(answersTrue.size() * 10);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
         u.setTime(timeElapsed.toMillis()/1000);
        users.add(u);
        answersTrue.clear();
        answersFalse.clear();
        samples.clear();
        createSamples();
    }

    public ArrayList<UserQuick> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserQuick> users) {
        this.users = users;
    }

    public ArrayList<Sample> getSamples() {
        return samples;
    }

    public void setSamples(ArrayList<Sample> samples) {
        this.samples = samples;
    }

    public String getPage() {
        createUserQuick();
        return page;
    }

    public void createUserQuick() {
        tempUser.setNickname(tempNick);
        tempUser.setId(countID);
        countID++;
    }

    public String getTempNick() {
        return tempNick;
    }

    public void setTempNick(String tempNick) {
        this.tempNick = tempNick;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
