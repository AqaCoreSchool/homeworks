package io;

import io.reader.CSVReader;
import io.writer.XMLWriter;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String sep = File.separator;
        String inputFilePath = "src"+sep+"main"+sep+"resourses"+sep+"Input data.csv";
        String outputFilePath = "src"+sep+"main"+sep+"resourses"+sep+"AQA courses.xls";
        String[] names= CSVReader.read(inputFilePath);
        XMLWriter.write(names,outputFilePath);
    }

}
