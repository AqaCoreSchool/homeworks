package iotask;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.random;

public class Writer {
    public static void writeToCSV(String fileName) {
        Faker faker = new Faker();
        try (FileWriter outputFile = new FileWriter(fileName)) {
            String values = Stream.generate(faker::firstName).limit(10).map(Objects::toString).collect(Collectors.joining(","));
            outputFile.write(values);
            System.out.println("CSV file was created or updated");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static XSSFColor setRandomColor() {
        return new XSSFColor(new java.awt.Color((int) (random() * 255), (int) (random() * 255), (int) (random() * 255)));
    }

    public static void writeIntoExcel(List<String> records, String path) {
        try (Workbook book = new XSSFWorkbook()) {
            Sheet sheet = book.createSheet("result");
            XSSFCellStyle myStyle = (XSSFCellStyle) book.createCellStyle();
            myStyle.setBorderTop(BorderStyle.MEDIUM);
            myStyle.setBorderBottom(BorderStyle.MEDIUM);
            myStyle.setBorderLeft(BorderStyle.MEDIUM);
            myStyle.setBorderRight(BorderStyle.MEDIUM);
            myStyle.setFillPattern(FillPatternType.DIAMONDS);
            myStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            myStyle.setAlignment(CellStyle.ALIGN_CENTER);
            XSSFFont font = (XSSFFont) book.createFont();
            font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
            font.setFontHeightInPoints((short) 15);
            font.setBold(true);
            font.setItalic(true);
            myStyle.setFont(font);
            sheet.setHorizontallyCenter(true);
            sheet.setDefaultRowHeight((short) (2 * 256));
            for (int i = 0; i < records.size(); i++) {
                Row row = sheet.createRow(i);
                sheet.setColumnWidth(i, 14 * 256);
                Cell cell = row.createCell(i);
                cell.setCellValue(records.get(i));
                myStyle.setFillForegroundColor(setRandomColor());
                cell.setCellStyle(myStyle);
            }
            System.out.println("Data from csv file was wrote to xlsx file");
            book.write(new FileOutputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readCSV(String path) {
        String line;
        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] value = line.split(",");
                records.addAll(Arrays.asList(value));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
