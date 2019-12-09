package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Candidate;
import data.Location;
import data.Vacancy;

import java.io.IOException;

public class JsonParser {
    public ObjectMapper objectMapper = new ObjectMapper();

    public Candidate getCandidateFrom(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, Candidate.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Vacancy getVacancyFrom(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, Vacancy.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Location getLocationFrom(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, Location.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
         return null;
    }
}
