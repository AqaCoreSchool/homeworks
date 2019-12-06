package testpackage.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testpackage.entity.Candidate;
import testpackage.entity.Location;
import testpackage.entity.User;
import testpackage.entity.Vacancy;
import testpackage.factory.CandidateFactory;
import testpackage.factory.LocationFactory;
import testpackage.factory.UserFactory;
import testpackage.factory.VacancyFactory;
import testpackage.json.JsonParser;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest {

    @Test
    public void TestJson() {
        JsonParser jsonParser = new JsonParser();

        Candidate candidate = new CandidateFactory().defaultCandidate();
        String candidateJson = jsonParser.objectToJson(candidate);

        Location location = new LocationFactory().defaultLocation();
        String locationJson = jsonParser.objectToJson(location);

        Vacancy vacancy = new VacancyFactory().defaultVacancy();
        String vacancyJson = jsonParser.objectToJson(vacancy);

        User user = new UserFactory().defaultUser();
        String userJson = jsonParser.objectToJson(user);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(candidate, jsonParser.getCandidateFrom(candidateJson),
                "Compared candidates have different parameters");
        softAssert.assertEquals(vacancy, jsonParser.getVacancyFrom(vacancyJson),
                "Compared candidates have different parameters");
        softAssert.assertEquals(user, jsonParser.getUserFrom(userJson),
                "Compared candidates have different parameters");
        softAssert.assertEquals(location, jsonParser.getLocationFrom(locationJson),
                "Compared candidates have different parameters");
        softAssert.assertAll();
    }
}
