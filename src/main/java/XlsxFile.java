
import org.apache.poi.sl.draw.geom.Path;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class XlsxFile {
    void createXlsxFile() throws IOException {
        String data ="";
        FileReader fr=new FileReader("src/main/resources/data.txt");
        Scanner scanner = new Scanner( fr );
        if(scanner.hasNext())
        data =scanner.next();
        fr.close();
        String []splitData = data.split( "," );

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Names");
        sheet.setColumnWidth( 0,9000 );

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor( IndexedColors.GREEN.getIndex() );
        headerFont.setItalic( true );

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setAlignment( HorizontalAlignment.LEFT );
        headerCellStyle.setFont( headerFont );
//        headerCellStyle.setFillBackgroundColor(IndexedColors.AQUA.getIndex() );
//        headerCellStyle.setFillPattern (FillPatternType.ALT_BARS);

        for (int i = 0; i < splitData.length; i++) {
            Row row = sheet.createRow(i);
            Cell cell = row.createCell( 0 );
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue( splitData[i] );
        }
        FileOutputStream fileOut = new FileOutputStream("src/main/resources/data.xlsx");
        workbook.write( fileOut );
        fileOut.close();
        workbook.close();
    }
}

