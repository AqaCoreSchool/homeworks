package IO;

import java.io.*;

public class Main {

    private static String fileName = "src\\main\\resources\\CSVFile.csv";
    private static String fileName2 = "src\\main\\resources\\XLSFile.xls";

    public static void main(String[] args) throws IOException {
        IO io = new IO();
        io.writeCSV(fileName);
        io.writeExcelFile(io.readFileToList(fileName),fileName2);
    }
}

