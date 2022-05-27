package employee;

public class car {
    private String brand;
    private float avgConsum;
    private Integer totalKm;
    private boolean isElectric;
    private boolean hasChildSeat;
    private Integer Id;
    private static Integer count=0;
    public car()
    {
        this.brand = "";
        this.avgConsum = 0.0f;
        this.totalKm = 0;
        this.isElectric = false;
        this.hasChildSeat = false;
        this.Id = ++count;
    }
    public car(String brand, float avgConsum, Integer totalKm, boolean isElectric, boolean hasChildSeat) {
        this.brand = brand;
        this.avgConsum = avgConsum;
        this.totalKm = totalKm;
        this.isElectric = isElectric;
        this.hasChildSeat = hasChildSeat;
        this.Id = ++count;
    }

    public car(int id, String brand, float avgconsum, int totalkm, boolean isE, boolean hasC) {
        this.brand = brand;
        this.avgConsum = avgConsum;
        this.totalKm = totalKm;
        this.isElectric = isElectric;
        this.hasChildSeat = hasChildSeat;
        this.Id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getAvgConsum() {
        return avgConsum;
    }

    public void setAvgConsum(float avgConsum) {
        this.avgConsum = avgConsum;
    }

    public Integer getTotalKm() {
        return totalKm;
    }

    public void setTotalKm(Integer totalKm) {
        this.totalKm = totalKm;
    }

    public boolean isElectric() {
        return isElectric;
    }


    public boolean isHasChildSeat() {
        return hasChildSeat;
    }
    public void setHasChildSeat(boolean hasChildSeat) {
        this.hasChildSeat = hasChildSeat;
    }
    public void setIsElectric(boolean isElectric) {
        this.isElectric = isElectric;
    }
    public String toCVS()
    {
        return brand+","+avgConsum+","+totalKm+","+isElectric+","+hasChildSeat;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
