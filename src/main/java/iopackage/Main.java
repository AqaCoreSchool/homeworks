package iopackage;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        String inputFilePath = "AQA courses.xls";
        String otputFilePath = "Input data.csv";
        writeValuesToXLSFile(getValuesFromCSVFile(otputFilePath), inputFilePath);
    }

    //Read data from the *.csv file
    private static String[] getValuesFromCSVFile(String filePath) {
        String lineOfValues = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            lineOfValues = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineOfValues.split(", ");
    }

    //Create the *.xls file and write data to that file
    private static void writeValuesToXLSFile(String[] values, String filePath) {

        Workbook coursesWorkbook = new HSSFWorkbook();
        Sheet membersSheet = coursesWorkbook.createSheet("Members");
        membersSheet.createRow(1).createCell(1).setCellValue("Name");

        for (int i = 0; i < values.length; i++) {
            membersSheet.createRow(i + 2).createCell(1).setCellValue(values[i]);
        }

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            coursesWorkbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
