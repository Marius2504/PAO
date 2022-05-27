package services;

import company.employee;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService implements Generic {
    private static final EmployeeService INSTANCE = new EmployeeService();
    public ArrayList<employee> v = new ArrayList<employee>();
    private EmployeeService(){}

    public static EmployeeService getINSTANCE() {
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
            System.out.println("Exception: no employees found");
        }
        return data;
    }

    //String name, String surname, String phone, String email, String password, Date birthDate, List<Double> salaries, List<String> comments, Integer overall, Map<Integer, Boolean> workDays
    @Override
    public void readCSV() throws IOException {
        var data = EmployeeService.readFile("src/main/java/files/employee.csv");
        for(var row : data){
            String[] salaries = row[6].split(" ");
            List<Double> doubleS = new ArrayList<Double>();
            for(var salariu:salaries) {
                doubleS.add(Double.parseDouble(salariu));
            }

            Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
            String[] pairs = row[9].split(",");
            for (int i=0;i<pairs.length;i++) {
                String pair = pairs[i];
                String[] keyValue = pair.split(":");
                map.put(Integer.valueOf(keyValue[0]), Boolean.valueOf(keyValue[1]));
            }
            //String name, String surname, String phone, String email, String password, Date birthDate, Integer overall
            var x = new employee(
                    row[0],
                    row[1],
                    row[2],
                    row[3],
                    row[4],
                    new Date((new java.util.Date(row[5])).getTime()),
                    0
            );
            this.v.add(x);
        }

    }

    @Override
    public void writeCSV() throws IOException {
        try{
            var write = new FileWriter("src/main/java/files/employee.csv");
            for(var driver : this.v){
                write.write(driver.toCVS());
                write.write("\n");
            }
            write.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<employee> getV() {
        return v;
    }

    public void setV(ArrayList<employee> v) {
        this.v = v;
    }
}
