package services;

import employee.car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarService implements Generic {
    private static final CarService INSTANCE = new CarService();
    private ArrayList<car> v = new ArrayList<car>();
    private CarService(){}
    public CarService getInstance()
    {
        return this.INSTANCE;
    }
    public ArrayList<car> getV() {
        return v;
    }

    public void setV(ArrayList<car> v) {
        this.v = v;
    }

    private static List<String[]> readFile(String f) throws FileNotFoundException {
        List<String[]> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line = "";
        try {

            while((line = reader.readLine()) != null ) {
                String[] row = line.split(",");
                data.add(row);
            }
        } catch (IOException e) {
            System.out.println("Exception: no cars found");
        }
        return data;
    }
    @Override
    public void readCSV() throws IOException {
        var data = CarService.readFile("src/main/java/files/car.csv");
        //String brand, float avgConsum, Integer totalKm, boolean isElectric, boolean hasChildSeat
        for(var row : data){
            var x = new car(
                    row[0],
                    Float.parseFloat(row[1]),
                    Integer.parseInt(row[2]),
                    Boolean.parseBoolean(row[3]),
                    Boolean.parseBoolean(row[4])
            );
            this.v.add(x);
        }
    }

    @Override
    public void writeCSV() throws IOException {
        try{
            var write = new FileWriter("src/main/java/files/car.csv");
            for(var car : this.v){
                write.write(car.toCVS());
                write.write("\n");
            }
            write.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
