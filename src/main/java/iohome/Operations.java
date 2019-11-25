package iohome;

import com.github.javafaker.Faker;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Operations {
    public void writeInfoToCsvFile(String filePath){
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < 10; i++) {
                Faker faker = new Faker();
                StringBuilder cities = new StringBuilder()
                        .append(faker.country().capital())
                        .append(',');
                bf.write(cities.toString());
            }
            System.out.println("File has been written");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> readFromFileToList(String filePath) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                for (int i = 0; i < words.length; i++) {
                    list.add(words[i]);
                }
            }
            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeToXlsFile(List<String> list, String filePath, String sheetName){
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetName);
        int rowNum = 0;
        Row row;
        Cell cell;
        for (String elem : list) {
            row = sheet.createRow(rowNum++);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(elem);
            sheet.autoSizeColumn(0);
        }

        try (FileOutputStream fos = new FileOutputStream(new File(filePath))){
            wb.write(fos);
            System.out.println("Xls file was created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
