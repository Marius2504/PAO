package services;

import client.history;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class HistoryService implements Generic {
    private static final HistoryService INSTANCE = new HistoryService();
    public ArrayList<history> v= new ArrayList<history>();

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
            System.out.println("Exception: no history found");
        }
        return data;
    }
    @Override
    public void readCSV() throws IOException {
        var data = HistoryService.readFile("src/main/java/files/history.csv");
        //double price, String startLocation, String endLocation, Date date
        for(var row : data){
            var x = new history(
                    Double.parseDouble(row[0]),
                    row[1],
                    row[2],
                    Date.valueOf(row[3]),
                    Integer.parseInt(row[4]));
            this.v.add(x);
        }

    }

    @Override
    public void writeCSV() throws IOException {
        try{
            var write = new FileWriter("src/main/java/files/history.csv");
            for(var driver : this.v){
                write.write(driver.toCVS());
                write.write("\n");
            }
            write.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<history> getV() {
        return v;
    }

    public void setV(ArrayList<history> v) {
        this.v = v;
    }
}
