package ua.biz.test.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSonConverter<T> {

    private ObjectMapper mapper = new ObjectMapper();

    public String convertObjectToJson(T t) throws JsonProcessingException {
        return mapper.writeValueAsString(t);
    }

    public T convertJsonToObject(String json, Class<T> ob) throws JsonProcessingException {
        return mapper.readerFor(ob).readValue(json);
    }
}