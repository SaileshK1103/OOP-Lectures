package task_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TemperatureAnalyzer {
    public static void main(String[] args) {
        String urlString = "https://users.metropolia.fi/~jarkkov/temploki.csv";
        String targetDate = "01.01.2023";
        List<Double> temperatures = new ArrayList<>();

        try{
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine(); // header
            System.out.println("Header: " + line);
            int ulkoTaloIndex = -1;

            // Find index of "UlkoTalo"
            String[] headers = line.split(";");
            for(int i = 0; i < headers.length; i++){
                if(headers[i].trim().equalsIgnoreCase("UlkoTalo")){
                    ulkoTaloIndex = i;
                    break;
                }
            }
            if(ulkoTaloIndex == -1){
                System.out.println("UlkoTalo column not found");
                return;
            }

            // Read data rows
            while((line = reader.readLine()) != null){
                String[] parts = line.split(";");
                if(parts[0].startsWith(targetDate)){ // first column is timestamp
                    try{
                        double temp = Double.parseDouble(parts[ulkoTaloIndex].replace(",", "."));
                        temperatures.add(temp);
                    }
                    catch(NumberFormatException e){
                        System.err.println(e);
                    }
                }
            }
            reader.close();

            // Calculate average
            if(!temperatures.isEmpty()){
                double avg = temperatures.stream().mapToDouble(Double::doubleValue).average().orElse(0);
                System.out.println("Average UlkoTalo temperature on " + targetDate + ": " + avg);
            }
            else {
                System.out.println("No temperature data for " + targetDate);
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}
