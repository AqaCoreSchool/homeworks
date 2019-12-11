package test;

import data.CandidateData;
import data.LocationData;
import data.VacancyData;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonReader;

public class JsonTest {

    @Test
    public void checkJsonDeserialization() {
        CandidateData candidate = new CandidateData("test", "Nazariy Kushnir", "2019-12-05");
        LocationData location = new LocationData();
        VacancyData vacancy = new VacancyData("Test", "Nazariy Kushnir");
        String candidateJson = String.format("{\"firstName\":\"%s\",\"lastName\":\"%s\",\"email\":\"%s\",\"contactNo\":\"%s\",\"vacancyName\":\"%s\",\"hiringManager\":\"%s\",\"comment\":\"%s\",\"date\":\"%s\"}\n",
                candidate.getFirstName(),
                candidate.getLastName(),
                candidate.getEmail(),
                candidate.getContactNo(),
                candidate.getVacancyName(),
                candidate.getHiringManager(),
                candidate.getComment(),
                candidate.getDate());
        String locationJson = String.format("{\"name\":\"%s\",\"countryCode\":\"%s\",\"state\":\"%s\",\"city\":\"%s\",\"address\":\"%s\",\"zip\":\"%s\",\"phone\":\"%s\",\"fax\":\"%s\",\"notes\":\"%s\"}",
                location.getName(),
                location.getCountryCode(),
                location.getState(),
                location.getCity(),
                location.getAddress(),
                location.getZip(),
                location.getPhone(),
                location.getFax(),
                location.getNotes());
        String vacancyJson = String.format("{\"jobTitleOption\":%d,\"vacancyName\":\"%s\",\"hiringManager\":\"%s\",\"positions\":\"%s\",\"description\":\"%s\"}",
                vacancy.getJobTitleOption(),
                vacancy.getVacancyName(),
                vacancy.getHiringManager(),
                vacancy.getPositions(),
                vacancy.getDescription());
        Assert.assertEquals(candidate, JsonReader.readCandidateFromJson(candidateJson));
        Assert.assertEquals(location, JsonReader.readLocationFromJson(locationJson));
        Assert.assertEquals(vacancy, JsonReader.readVacancyFromJson(vacancyJson));
    }
}
