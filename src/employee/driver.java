package employee;

import java.util.Collections;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import DatabaseServices.CarService;
import client.history;
import client.settings;
import company.employee;
public class driver extends employee {
    private String ratings;
    private Integer cr; //car id
    private Integer Id;
    private static Integer count=0;
    public driver()
    {
        super();
        this.ratings= "";
        this.cr = null;
        this.Id = ++count;
    }
    public driver(String name, String surname, String phone, String email, String password, Date birthDate, Integer overall, String ratings,Integer cr) {
        super(name,surname,phone,email,password,birthDate,overall);
        this.ratings= ratings;
        this.cr = cr;
        this.Id = ++count;
    }

    public driver(int id, String ratings, int car) {
        this.ratings= ratings;
        this.cr = cr;
        this.Id = id;
        this.cr = null;

    }

    public driver(int id, String name, String surname, String phone, String email, String password, java.sql.Date birthdate, int overall, String ratings, int car) {
        super(id,name,surname,phone,email,password,birthdate,overall);
        this.ratings= ratings;
        this.cr = car;
        this.Id = id;
    }




    public void addRating(Integer ra)
    {
        this.ratings= this.ratings +" " +String.valueOf(ra);
    }

    public Integer getCr() {
        return cr;
    }
    public void setCr(Integer cr) {
        this.cr = cr;
    }

    public Integer getId() {
        return Id;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }


}
