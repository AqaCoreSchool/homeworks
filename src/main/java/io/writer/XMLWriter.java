package io.writer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class XMLWriter {
    //Write data to *.xml file
    public static void write(String[] values, String filePath) {

        Workbook coursesWorkbook = new HSSFWorkbook();

        Sheet membersSheet = coursesWorkbook.createSheet("Members");
        Cell headCell = membersSheet.createRow(1).createCell(1);
        headCell.setCellValue("Name");

        Font headCellFontStyle = coursesWorkbook.createFont();
        headCellFontStyle.setBold(true);
        headCellFontStyle.setItalic(true);

        CellStyle headCellStyle = coursesWorkbook.createCellStyle();
        headCellStyle.setFont( headCellFontStyle);
        headCell.setCellStyle(headCellStyle);


        for (int i = 0; i < values.length; i++) {
            Cell currentCell = membersSheet.createRow(i + 2).createCell(headCell.getColumnIndex());
            currentCell.setCellValue(values[i]);
        }

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            coursesWorkbook.write(outputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

