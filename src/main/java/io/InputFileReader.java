package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputFileReader {
    public static List<String> data = new ArrayList<>();

    public void readInputFile() {
        String row;
        try (BufferedReader csvReader = new BufferedReader(new FileReader(Main.CSV_PATH))) {
            while ((row = csvReader.readLine()) != null) {
                data.addAll(Arrays.asList(row.split("\n")));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
