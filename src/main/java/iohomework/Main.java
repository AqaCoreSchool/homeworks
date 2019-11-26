package iohomework;

import com.github.javafaker.Faker;
import org.apache.poi.hssf.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static final String localDir = System.getProperty("user.dir");

    public static void main(String[] args) {
        createExampleCsv();
        writeToExcelFile(readFromCsvFile());
    }

    public static void createExampleCsv(){
        Faker fakeData = new Faker();
        try {
            FileWriter exampleCSV = new FileWriter(localDir + File.separator
                    + "src" + File.separator + "main" + File.separator
                    + "resources" + File.separator +"source.csv");
            String dataString = IntStream.range(0, 10)
                    .mapToObj(i -> fakeData.name().firstName())
                    .collect(Collectors.joining(","));
            exampleCSV.write(dataString);
            exampleCSV.flush();
            exampleCSV.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFromCsvFile(){
        List<String> extractedData = new ArrayList<>();
        try{
            FileReader dataSource = new FileReader(localDir + File.separator
                    + "src" + File.separator + "main" + File.separator
                    + "resources" + File.separator +"source.csv");
            BufferedReader reader = new BufferedReader(dataSource);
            String line = reader.readLine();
            while(line!=null){
                String[] lineObjects = line.split(",");
                extractedData.addAll(Arrays.asList(lineObjects));
                line = reader.readLine();
            }
            dataSource.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return extractedData;
    }

    public static void writeToExcelFile(List<String> inputDataList){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("output");
        IntStream.range(0, inputDataList.size()).forEachOrdered(i -> {
            HSSFRow row = sheet.createRow(i);
            HSSFCell inputCell = row.createCell(0); //change 0 to i for diagonal print to excel
            inputCell.setCellValue(inputDataList.get(i));
        });
        try{
            FileOutputStream output = new FileOutputStream(localDir + File.separator
                    + "src" + File.separator + "main" + File.separator
                    + "resources" + File.separator +"output.xlsx");
            workbook.write(output);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
