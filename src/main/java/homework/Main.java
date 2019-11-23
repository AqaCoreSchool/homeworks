package homework;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        writeValuesToFile(getValuesFromFile());
    }

    //Read data from the *.csv file
    private static String[] getValuesFromFile() {
        String[] strArr = new String[10];
        try (BufferedReader reader = new BufferedReader(new FileReader("Input data.csv"))) {
            strArr = reader.readLine().split(", ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strArr;
    }

    //Create the *.xls file and write data to that file
    private static void writeValuesToFile(String[] str) {
        Workbook myWorkbook = new HSSFWorkbook();
        Sheet sheet = myWorkbook.createSheet("Members");
        Row row1 = sheet.createRow(1);
        Cell cell =row1.createCell(1);
        cell.setCellValue("Name");
        for (int i = 0; i <str.length; i++) {
            sheet.createRow(i+2).createCell(1).setCellValue(str[i]);
        }
        try ( FileOutputStream dos = new FileOutputStream("AQA courses.xls")){
            myWorkbook.write(dos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
