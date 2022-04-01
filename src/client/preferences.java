package client;

public class preferences {
    private String typeOfCar;
    private String paymentMethod;
    private String homeLocation;

    public preferences()
    {
        this.typeOfCar="";
        this.homeLocation="";
        this.paymentMethod="cash";
    }
    public preferences(String typeOfCar,String paymentMethod,String homeLocation)
    {
        this.typeOfCar=typeOfCar;
        this.homeLocation=homeLocation;
        this.paymentMethod=paymentMethod;
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

    public void setHomeLocation(String homeLocation) {
        this.homeLocation = homeLocation;
    }
}
