package client;

import java.util.Date;

public class history {
    private double price;
    private String startLocation;
    private String endLocation;
    private Date date;
    public history()
    {
        this.price = 0.0;
        this.startLocation = "";
        this.endLocation = "";
        this.date = null;
    }
    public history(double price, String startLocation, String endLocation, Date date) {
        this.price = price;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.date = date;
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

    public void setDate(Date date) {
        this.date = date;
    }

}
