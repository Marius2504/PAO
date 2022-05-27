package client;

public class preferences {
    private String typeOfCar;
    private String paymentMethod;
    private String homeLocation;
    private Integer Id;
    private Integer RegId;
    private static Integer count=3;
    public preferences()
    {
        this.typeOfCar="";
        this.homeLocation="";
        this.paymentMethod="cash";
        this.Id = ++count;
    }
    public preferences(String typeOfCar, String paymentMethod, String homeLocation, Integer regId)
    {
        this.typeOfCar=typeOfCar;
        this.homeLocation=homeLocation;
        this.paymentMethod=paymentMethod;
        this.RegId = regId;
        this.Id = ++count;
    }

    public preferences(int id, String typeofcar, String paymentmeyhod, String homelocation, Integer regId) {
        this.RegId = regId;
        this.typeOfCar=typeofcar;
        this.homeLocation=homelocation;
        this.paymentMethod=paymentmeyhod;
        this.Id = id;
    }


    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getHomeLocation() {
        return homeLocation;
    }

    public Integer getRegId() {
        return RegId;
    }

    public void setRegId(Integer regId) {
        RegId = regId;
    }

    public void setHomeLocation(String homeLocation) {
        this.homeLocation = homeLocation;
    }
    public String toCVS(){
        return getTypeOfCar()+","+getPaymentMethod()+","+getHomeLocation();
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
