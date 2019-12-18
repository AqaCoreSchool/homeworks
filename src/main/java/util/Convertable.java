package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public interface Convertable {
    default <T> T getObject(String jsonPath, Class<T> aClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(jsonPath));
            return objectMapper.readValue(jsonData, aClass);
        } catch (JsonProcessingException e) {
            System.out.println("Convertable error: " + e.getMessage());
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
