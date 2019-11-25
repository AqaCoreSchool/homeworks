package io;

import io.reader.CSVReader;
import io.writer.XMLWriter;

public class Main {

    public static void main(String[] args) {
        String inputFilePath = "src\\main\\resourses\\Input data.csv";
        String outputFilePath = "src\\main\\resourses\\AQA courses.xls";
        String[] names= CSVReader.read(inputFilePath);
        XMLWriter.write(names,outputFilePath);
    }

}
