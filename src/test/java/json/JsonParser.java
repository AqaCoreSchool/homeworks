package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Candidate;
import data.Location;
import data.Vacancy;

import java.io.IOException;

public class JsonParser {


    public Candidate getCandidate(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        Candidate candidate = null;
        try {
            candidate = objectMapper.readValue(jsonString, Candidate.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return candidate;
    }

    public Vacancy getVacancy(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        Vacancy vacancy = null;
        try {
            vacancy = objectMapper.readValue(jsonString, Vacancy.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vacancy;
    }

    public Location getLocation(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        Location location = null;
        try {
            location = objectMapper.readValue(jsonString, Location.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return location;
    }
}
