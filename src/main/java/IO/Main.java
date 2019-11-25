package IO;

import java.io.*;

public class Main {

    private static final String PATH = System.getProperty("user.dir") + File.separator
            + "src" + File.separator + "main" + File.separator + "resources" + File.separator;

    private static String fileNameCSV = PATH + "CSVFile.csv";
    private static String fileNameXLS = PATH + "XLSFile.xls";

    public static void main(String[] args) throws IOException {
        IO io = new IO();
        io.writeCSV(fileNameCSV);
        io.writeExcelFile(io.readFileToList(fileNameCSV), fileNameXLS);
    }
}

