package com.company.vTests.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConvert {
    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> T jsonToObject(String jsonString, Class<T> object) {
        try {
            return objectMapper.readerFor(object).readValue(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


}
