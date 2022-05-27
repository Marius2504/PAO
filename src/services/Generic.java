package services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Generic {
    public void readCSV() throws IOException;
    public void writeCSV() throws IOException;
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
            System.out.println("Exception: no data found");
        }
        return data;
    }
}
