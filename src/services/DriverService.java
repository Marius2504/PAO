package services;

import employee.driver;
import employee.car;

import java.io.*;
import java.security.DigestInputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverService implements Generic {
    //String name, String surname, String phone, String email, String password, Date birthDate,  List<Double> salaries, List<String> comments, Integer overall, Map<Integer, Boolean> workDays, List<Integer> ratings, car cr
    private static final DriverService INSTANCE = new DriverService();
    public ArrayList<driver> v = new ArrayList<driver>();
    private DigestInputStream Splitter;

    private DriverService(){}
    public DriverService getInstance()
    {
        return INSTANCE;
    }
    private static List<String[]> readFile(String f) throws FileNotFoundException {
        List<String[]> data = new ArrayList<String[]>();
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line = "";
        try {

            while((line = reader.readLine()) != null ) {
                String[] row = line.split(",");
                data.add(row);
            }
        } catch (IOException e) {
            System.out.println("Exception: no drivers found");
        }
        return data;
    }
    @Override
    public void readCSV() throws IOException {
        var data = DriverService.readFile("src/main/java/files/car.csv");
        //String name, String surname, String phone, String email, String password, Date birthDate,  List<Double> salaries, List<String> comments, Integer overall, Map<Integer, Boolean> workDays, List<Integer> ratings, car cr
        for(var row : data){
            String[] salaries = row[6].split(" ");
            List<Double> doubleS = new ArrayList<Double>();
            for(var salariu:salaries) {
                doubleS.add(Double.parseDouble(salariu));
                }

            String[] ratings = row[10].split(" ");
            List<Integer> intS = new ArrayList<Integer>();
            for(var r:ratings) {
                intS.add(Integer.parseInt(r));
            }
            Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
            String[] pairs = row[9].split(",");
            for (int i=0;i<pairs.length;i++) {
                String pair = pairs[i];
                String[] keyValue = pair.split(":");
                map.put(Integer.valueOf(keyValue[0]), Boolean.valueOf(keyValue[1]));
            }
            ///car
            ArrayList<String> stt = new ArrayList<String>();
            for(var va:row[11].split(" "))
            {
                stt.add(va);
            }
            ////int id, String name, String surname, String phone, String email, String password, java.sql.Date birthdate, int overall, String ratings, int car
            car vcar = new car(stt.get(0),Float.parseFloat(stt.get(1)),Integer.parseInt(stt.get(2)),Boolean.parseBoolean(stt.get(3)),Boolean.parseBoolean(stt.get(4)));

            var x = new driver(
                    row[0],
                    row[1],
                    row[2],
                    row[3],
                    row[4],
                    new Date((new java.util.Date(row[5])).getTime()),
                    0,
                    "fsd",
                    1
            );
            this.v.add(x);
        }
    }

    @Override
    public void writeCSV() throws IOException {
        try{
            var write = new FileWriter("src/main/java/files/driver.csv");
            for(var driver : this.v){
                write.write(driver.toCVS());
                write.write("\n");
            }
            write.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<driver> getV() {
        return v;
    }

    public void setV(ArrayList<driver> v) {
        this.v = v;
    }
}
