package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

public interface Convertable {

    default Object getObject(JSONObject jsonObject, Class aClass) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(jsonObject.toString(), aClass);
        } catch (JsonProcessingException e) {
            System.out.println("Convertable error: " + e.getMessage());
        }
        return null;
    }

    default Object getObject(String jsonObject, Class aClass) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(jsonObject, aClass);
        } catch (JsonProcessingException e) {
            System.out.println("Convertable error: " + e.getMessage());
        }
        return null;
    }

    default JSONObject convertToJson(Object o){
        return new JSONObject(o);
    }
}
