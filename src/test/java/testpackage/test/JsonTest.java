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
import testpackage.json.JsonConvert;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest {

    @Test
    public void TestJson() {
        JsonConvert jsonConvert = new JsonConvert();

        Candidate candidate = new CandidateFactory().defaultCandidate();
        String candidateJson = jsonConvert.objectToJson(candidate);

        Location location = new LocationFactory().defaultLocation();
        String locationJson = jsonConvert.objectToJson(location);

        Vacancy vacancy = new VacancyFactory().defaultVacancy();
        String vacancyJson = jsonConvert.objectToJson(vacancy);

        User user = new UserFactory().defaultUser();
        String userJson = jsonConvert.objectToJson(user);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(candidate, jsonConvert.getCandidateFrom(candidateJson),
                "Compared candidates have different parameters");
        softAssert.assertEquals(vacancy, jsonConvert.getVacancyFrom(vacancyJson),
                "Compared candidates have different parameters");
        softAssert.assertEquals(user, jsonConvert.getUserFrom(userJson),
                "Compared candidates have different parameters");
        softAssert.assertEquals(location, jsonConvert.getLocationFrom(locationJson),
                "Compared candidates have different parameters");
        softAssert.assertAll();
    }
}
