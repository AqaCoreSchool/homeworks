package iohome;

import java.io.*;
import java.util.List;


public class Main {

    private static final String PATH = System.getProperty("user.dir") + File.separator
            + "src" + File.separator + "main" + File.separator + "resources" + File.separator;


    public static void main(String[] args) {

        String csvPath = PATH + "capitals.csv";
        String xlsPath = PATH + "capitals.xls";

        Operations ops = new Operations();
        ops.writeInfoToCsvFile(csvPath);
        List<String> capitals = ops.readFromFileToList(csvPath);
        ops.writeToXlsFile(capitals, xlsPath, "Capitals" );
    }
}
