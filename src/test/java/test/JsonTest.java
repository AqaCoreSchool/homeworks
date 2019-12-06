package test;

import com.google.gson.Gson;
import data.CandidateData;
import data.LocationData;
import data.VacancyData;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonReader;

public class JsonTest {

    @Test
    public void checkJsonDeserialization() {
        Gson jsonMaker = new Gson();
        CandidateData candidate = new CandidateData("test", "Nazariy Kushnir", "2019-12-05");
        LocationData location = new LocationData();
        VacancyData vacancy = new VacancyData("Test", "Nazariy Kushnir");
        String candidateJson = jsonMaker.toJson(candidate);
        String locationJson = jsonMaker.toJson(location);
        String vacancyJson = jsonMaker.toJson(vacancy);
        Assert.assertEquals(candidate, JsonReader.readCandidateFromJson(candidateJson));
        Assert.assertEquals(location, JsonReader.readLocationFromJson(locationJson));
        Assert.assertEquals(vacancy, JsonReader.readVacancyFromJson(vacancyJson));
    }
}
