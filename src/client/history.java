package client;

import java.sql.Date;

public class history {
    private double price;
    private String startLocation;
    private String endLocation;
    private Date date;
    private Integer Id;
    private Integer RegId;
    private static Integer count=0;
    public history()
    {
        this.price = 0.0;
        this.startLocation = "";
        this.endLocation = "";
        this.date = null;
        this.Id = ++count;
    }
    public history(double price, String startLocation, String endLocation, Date date, Integer regId) {
        this.price = price;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.date = date;
        this.RegId = regId;
        this.Id = ++count;
    }

    public history(int id, double price, String startlocation, String endlocation, Date todaydate, int regid) {
        this.price = price;
        this.startLocation = startlocation;
        this.endLocation = endlocation;
        this.date = todaydate;
        this.RegId = regid;
        this.Id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public Date getDate() {
        return date;
    }

    public Integer getRegId() {
        return RegId;
    }

    public void setRegId(Integer regId) {
        RegId = regId;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String toCVS(){
        return getPrice() +","+ getStartLocation()+","+getEndLocation()+","+ getDate();
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
