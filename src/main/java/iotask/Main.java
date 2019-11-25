package iotask;

import java.io.File;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String path = Paths.get("src", "main", "resources").toString();
        String excelPath = path + File.separator + "result.xlsx";
        String csvPath = path + File.separator + "file.csv";
        Writer.writeToCSV(csvPath);
        Writer.writeIntoExcel(Writer.readCSV(csvPath), excelPath);
    }
}

