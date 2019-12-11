package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.CandidateData;
import data.LocationData;
import data.VacancyData;

public class JsonReader {
    private static ObjectMapper objectMapper = new ObjectMapper();


    public static VacancyData readVacancyFromJson(String json) {
        try {
            return objectMapper.readValue(json, VacancyData.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static LocationData readLocationFromJson(String json) {
        try {
            return objectMapper.readValue(json, LocationData.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static CandidateData readCandidateFromJson(String json) {
        try {
            return objectMapper.readValue(json, CandidateData.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
