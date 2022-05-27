package services;

import client.preferences;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PreferencesService implements Generic {
    private static final PreferencesService INSTANCE = new PreferencesService();
    public ArrayList<preferences> v = new ArrayList<preferences>();
    private PreferencesService()
    {

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
            System.out.println("Exception: no preferences found");
        }
        return data;
    }
    @Override
    public void readCSV() throws IOException {
        var data = PreferencesService.readFile("src/main/java/files/history.csv");
        //String typeOfCar,String paymentMethod,String homeLocation
        for(var row : data){
            var x = new preferences(
                    row[0],
                    row[1],
                    row[2],
                    Integer.parseInt(row[3]));
            this.v.add(x);
        }
    }

    @Override
    public void writeCSV() throws IOException {
        try{
            var write = new FileWriter("src/main/java/files/preferences.csv");
            for(var driver : this.v){
                write.write(driver.toCVS());
                write.write("\n");
            }
            write.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
