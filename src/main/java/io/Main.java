package io;

public class Main {
    public static final String CSV_PATH = "src\\main\\resources\\input.csv";
    public static final String XLSX_PATH = "src\\main\\resources\\output.xlsx";

    public static void main(String[] args) {
        InputFileWriter writer = new InputFileWriter();
        writer.writeInputFile();

        InputFileReader reader = new InputFileReader();
        reader.readInputFile();

        OutputFileWriter writer1 = new OutputFileWriter();
        writer1.writeOutputFile();
    }
}
