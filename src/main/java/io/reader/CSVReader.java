package io.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static String[] read(String filePath){
        String lineOfValues = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            lineOfValues = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineOfValues.split(", ");
    }
}
