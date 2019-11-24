package io;

import com.github.javafaker.Faker;

import java.io.FileWriter;
import java.io.IOException;

public class InputFileWriter {
    private Faker faker;

    public void writeInputFile() {
        try (FileWriter csvWriter = new FileWriter(Main.CSV_PATH)) {
            faker = new Faker();
            for (int i = 0; i < 10; i++) {
                csvWriter.append(faker.name().name());
                csvWriter.append(",");
                csvWriter.append(faker.company().profession());
                csvWriter.append(",");
                csvWriter.append(faker.address().country());
                csvWriter.append("\n");
            }
            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
