package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Converter<T> {
    private T t;

    public T getObject() {
        return t;
    }

    public Converter<T> convertToObject(String jsonPath, Class<T> aClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(jsonPath));
            t = objectMapper.readValue(jsonData, aClass);
        } catch (JsonProcessingException e) {
            System.out.println("Json processing exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
        return this;
    }
}
