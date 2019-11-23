package com.company.io;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.company.io.Creator.createStyles;

public class Main {
    public static void main(String[] args) throws IOException {
        Creator file = new Creator();
        file.createCSV();

        List < String > namesArray = new ArrayList < > ();
        File csvFile = new File("test.csv");
        Scanner readCSV = new Scanner(csvFile);

        Workbook wb;
        if (args.length > 0 && args[0].equals("-xls")) {
            wb = new HSSFWorkbook();
        } else wb = new XSSFWorkbook();

        Map <String, CellStyle> styles = createStyles(wb);
        Sheet sheet = wb.createSheet("Converter sheet");

        wb.setPrintArea(0, "$A$1:$C$2");
        sheet.setZoom(140);
        sheet.autoSizeColumn(0);
        for (int i = 0; i <= 10; i++) {
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);

            readCSV.useDelimiter(",");
            namesArray.add(readCSV.next());

            cell.setCellValue(namesArray.get(i));
            cell.setCellStyle(styles.get("color"));
        }

        Row rowTitle = sheet.createRow(12);
        Cell cellTitle = rowTitle.createCell(1);
        cellTitle.setCellValue("Excel with Names");
        sheet.addMergedRegion(new CellRangeAddress(
                12,
                12,
                1,
                4
        ));
        cellTitle.setCellStyle(styles.get("title"));

        try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
            wb.write(fileOut);
        }
        wb.close();
    }
}