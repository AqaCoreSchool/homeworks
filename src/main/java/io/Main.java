package io;

import com.github.javafaker.Faker;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        Path path = Paths.get(userDir, "src", "main", "resources");
        createCsv(path);
        String[] data = readFromCsvFile(path);
        createExcelFile(path, data);

    }

    public static void createCsv(Path path) {
        try (FileWriter writer = new FileWriter(path + File.separator + "file.csv")) {
            writer.append(generateFakeData());
            System.out.println("File created!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] readFromCsvFile(Path path) {
        String line = "";
        String[] data = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path + File.separator + "file.csv"))) {
            while ((line = br.readLine()) != null) {
                data = line.split(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String generateFakeData() {
       return IntStream.range(0, 10)
               .mapToObj(name -> Faker.instance().animal().name())
               .collect(Collectors.joining(","));
    }

    public static void createExcelFile(Path path, String[] data) {
        try (HSSFWorkbook workbook = new HSSFWorkbook()) {
            HSSFSheet sheet = workbook.createSheet("random data");
            IntStream.range(0, data.length).forEach(i -> {
                HSSFRow row = sheet.createRow(i);
                HSSFCell cell = row.createCell(0);
                cell.setCellValue(data[i]);
            });
            try (FileOutputStream fileOut = new FileOutputStream(path + File.separator + "file.xls")) {
                workbook.write(fileOut);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}