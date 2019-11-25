package iotask;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        String csvPath = "src\\main\\resources\\file.csv";
        String excelPath = "src\\main\\resources\\result.xlsx";
        Writer.writeToCSV(csvPath);
        Writer.writeIntoExcel(Writer.readCSV(csvPath),excelPath);
    }


}

