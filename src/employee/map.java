package employee;
import client.register;
import company.payment;
public class map {
    //scurta descriere a cursei
    private boolean isBusy;// aglomerat sau nu
    private boolean badWeather;
    private Integer totalKm;
    private driver drv;
    private register current_client;
    //private payment pay; //cat primeste soferul
    public map()
    {
        this.isBusy = false;
        this.badWeather = false;
        this.totalKm = 0;
        this.drv = null;
        this.current_client = null;
    }
    public map(boolean isBusy,boolean badWeather, Integer totalKm, driver drv, register reg) {
        this.isBusy = isBusy;
        this.badWeather = badWeather;
        this.totalKm = totalKm;
        this.drv = drv;
        this.current_client = reg;
        //this.pay = pay;
    }

    public Integer getTotalKm() {
        return totalKm;
    }

    public void setTotalKm(Integer totalKm) {
        this.totalKm = totalKm;
    }

    public driver getDrv() {
        return drv;
    }

    public void setDrv(driver drv) {
        this.drv = drv;
    }

    public register getReg() {
        return current_client;
    }

    public void setReg(register reg) {
        this.current_client = reg;
    }

    public boolean isBadWeather() {
        return badWeather;
    }

    public void setBadWeather(boolean badWeather) {
        this.badWeather = badWeather;
    }

    public boolean isBusy() {
        return isBusy;
    }
    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public register getCurrent_client() {
        return current_client;
    }

    public void setCurrent_client(register current_client) {
        this.current_client = current_client;
    }


    /*
    public float price_calcc()
    {
        int busy = isBusy ? 1 : 0;
        int bad = badWeather ? 1 : 0;
        float suma = 0;
        suma = drv.getCr().getAvgConsum()*totalKm;
        suma += suma*busy + suma*bad;

        suma = suma *7;
        suma = suma/current_client.getRating();
        return suma;
    }
    public String toCSV()
    {
        return isBusy+","+badWeather+","+totalKm+","+getDrv().getName()+","+getCurrent_client().getName();
    }

     */
}
