package com.company.io;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Creator {
    void createCSV() throws IOException {
        Faker faker = new Faker();
        try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {
            for (int i = 0; i <= 10; i++) {
                StringBuilder names = new StringBuilder()
                        .append(faker.name().firstName())
                        .append(',');
                writer.write(names.toString());
            }
            System.out.println("CSV created!");
        }

    }

    static Map <String, CellStyle> createStyles(Workbook wb) {
        Map <String, CellStyle> styles = new HashMap < > ();

        CellStyle style = wb.createCellStyle();

        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setRightBorderColor(IndexedColors.BLUE.getIndex());
        style.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Font font = wb.createFont();
        font.setFontHeightInPoints((short) 11);
        font.setFontName("Times New Roman");
        font.setItalic(true);
        style.setFont(font);

        styles.put("color", style);

        CellStyle titleStyle = wb.createCellStyle();
        titleStyle.setFillForegroundColor(IndexedColors.CORAL.getIndex());
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styles.put("title", titleStyle);

        return styles;
    }
}