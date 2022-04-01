package employee;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import client.history;
import client.settings;
import company.employee;
public class driver extends employee {
    private List<Integer> ratings;
    private car cr;
    public driver()
    {
        super();
        this.ratings= Collections.emptyList();
        this.cr = null;
    }
    public driver(String name, String surname, String phone, String email, String password, Date birthDate,  List<Double> salaries, List<String> comments, Integer overall, Map<Integer, Boolean> workDays, List<Integer> ratings, car cr) {
        super(name,surname,phone,email,password,birthDate,salaries,comments,overall, workDays);
        this.ratings= ratings;
        this.cr = cr;
    }
    public List<Integer> getRatings() {
        return ratings;
    }
    public void setRatings(List<Integer> ratings) {
        this.ratings = ratings;
    }
    public void addRating(Integer ra)
    {
        this.ratings.add(ra);
    }

    public car getCr() {
        return cr;
    }
    public void setCr(car cr) {
        this.cr = cr;
    }
}
