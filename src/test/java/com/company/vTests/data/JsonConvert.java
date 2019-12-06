package com.company.vTests.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConvert {
    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> T convertJsonToObject(String jsonString, Class<T> object) throws JsonProcessingException{
            return objectMapper.readerFor(object).readValue(jsonString);
    }
}
