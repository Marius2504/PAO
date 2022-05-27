package client;

import java.util.Collections;
import java.sql.Date;
import java.util.List;

public class register extends human {
    private int rating;
    private List<String> events;
    private List<String> titleEvents;
    private List<history> hst;
    private preferences pf;
    private settings st;

    public register()
    {
        super();
        this.hst = Collections.emptyList();
        this.st = null;
        this.rating = 0;
        this.events = Collections.emptyList();
        this.titleEvents = Collections.emptyList();
    }

    public register(String name, String surname, String phone, String email, String password, Date birthDate, List<history> hst, settings st, int rating, List<String> events, List<String> titleEvents)
    {
        super(name,surname,phone,email,password,birthDate);
        this.hst = hst;
        this.st = st;
        this.rating = rating;
        this.events = events;
        this.titleEvents = titleEvents;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public List<String> getTitleEvents() {
        return titleEvents;
    }

    public void setTitleEvents(List<String> titleEvents) {
        this.titleEvents = titleEvents;
    }

    public void setHst(List<history> hst) {
        this.hst = hst;
    }

    public List<history> getHst() {
        return hst;
    }

    public void setSt(settings st) {
        this.st = st;
    }

    public settings getSt() {
        return st;
    }

    public preferences getPf() {
        return pf;
    }

    public void setPf(preferences pf) {
        this.pf = pf;
    }
}
