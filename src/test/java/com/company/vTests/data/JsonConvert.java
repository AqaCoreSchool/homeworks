package com.company.vTests.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConvert {
    private ObjectMapper objectMapper;

    public JsonConvert() {
            objectMapper = new ObjectMapper();
        }

        public <T> T jsonToObject(String json, Class<T> object) throws JsonProcessingException {
            return objectMapper.readerFor(object).readValue(json);
        }

}
