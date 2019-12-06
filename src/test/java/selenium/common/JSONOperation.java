package selenium.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONOperation {
    private ObjectMapper mapper;

    public JSONOperation() {
        mapper = new ObjectMapper();
    }

    public <T> T jsonToObject(String json, Class<T> object) throws JsonProcessingException {
        return mapper.readerFor(object).readValue(json);
    }

}
