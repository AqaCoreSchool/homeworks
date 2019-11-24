package io;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputFileWriter {

    public void writeOutputFile() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Output");


        int rowNum = 0;

        for (String value : InputFileReader.data) {
            Row row = sheet.createRow(rowNum++);

            String[] splittedData = value.split(",");
            for (int i = 0; i < splittedData.length; i++) {
                row.createCell(i).setCellValue(splittedData[i]);
            }
        }

        for (int i = 0; i < InputFileReader.data.size(); i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream fileOut = new FileOutputStream(Main.XLSX_PATH)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
