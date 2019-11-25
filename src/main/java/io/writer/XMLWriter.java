package io.writer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class XMLWriter {
    //Write data to *.xml file
    public static void write(String[] values, String filePath) {

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

