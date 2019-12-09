package tests;

import data.Candidate;
import data.Location;
import data.Vacancy;
import json.JsonParser;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JsonManualTest {

    @Test
    public void TestJson() {
        JsonParser jsonParser = new JsonParser();

        Candidate candidate = new Candidate();
        String candidateJson = "{\"firstName\": \"Andrii\", \"lastName\": \"Shtyiuk\"," +
                "\"email\": \"andrii.shtyiuk@gmail.com\", " +
                "\"phoneNumber\": \"0686478967\", \"vacancy\": \"Junior\"}";

        Vacancy vacancy = new Vacancy();
        String vacancyJson = "{\"vacancyName\": \"Junior\", \"jobTitle\": \"AQA\"," +
                "\"hiringManager\": \"Oleksandr Yablonskyi\", " +
                "\"status\": \"Active\"}";

        Location location = new Location();
        String locationJson = "{\"locationName\": \"CoreValue\", \"country\": \"Ukraine\"," +
                "\"province\": \"Lviv region\", " +
                "\"city\": \"Lviv\", \"address\": \"Heroiv UPA, 73\", \"postalCode\": \"79000\"," +
                "\"phone\": \"380 32 584 55 55\"}";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(candidate, jsonParser.getCandidateFrom(candidateJson),
                "Compared candidates have different parameters");
        softAssert.assertEquals(vacancy, jsonParser.getVacancyFrom(vacancyJson),
                "Compared vacancies have different parameters");
        softAssert.assertEquals(location, jsonParser.getLocationFrom(locationJson),
                "Compared locations have different parameters");
        softAssert.assertAll();
    }
}
