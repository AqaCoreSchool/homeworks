package ua.testbiz.page;

import data.DataFaker;
import data.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Candidate;
import pojo.Location;
import pojo.Vacancy;
import util.Convertable;

public class AutomationTest extends BaseTest implements Convertable {

    @org.testng.annotations.Test
    public void testCandidate() {
        DataFaker dataFaker = new DataFaker().setCandidate();

        boolean isCandidate =
                new LoginPage()
                        .loginIntoSystem()
                        .selectRecruitment()
                        .addCandidate(dataFaker.getCandidate())
                        .switchToCandidate()
                        .searchCandidate(dataFaker.getCandidate())
                        .checkCandidate(dataFaker.getCandidate());

        Assert.assertTrue(isCandidate, "Candidate is not found");
    }

    @org.testng.annotations.Test()
    public void testProfile() {
        DataFaker dataFaker = new DataFaker().setUserInformation();

        boolean isEmployee =
                new LoginPage()
                        .loginIntoSystem()
                        .selectMyInfo()
                        .setPersonalDetail(dataFaker.getUserInformation())
                        .selectPim()
                        .checkEmployee(dataFaker.getUserInformation());

        Assert.assertTrue(isEmployee, "Employee is not found!");
    }

    @org.testng.annotations.Test()
    public void testVacancy() {
        DataFaker dataFaker = new DataFaker().setVacancy();

        boolean isVacancy =
                new LoginPage()
                        .loginIntoSystem()
                        .selectRecruitment()
                        .switchToVacancy()
                        .addVacancy(dataFaker.getVacancy())
                        .searchVacancy(dataFaker.getVacancy())
                        .checkVacancy(dataFaker.getVacancy());

        Assert.assertTrue(isVacancy, "Vacancy is not found!");
    }

    @Test
    public void testLocation() {
        DataFaker dataFaker = new DataFaker().setLocation();

        boolean isLocation =
                new LoginPage()
                        .loginIntoSystem()
                        .selectAdmin()
                        .addLocation(dataFaker.getLocation())
                        .searchLocation(dataFaker.getLocation())
                        .isLocationInList(dataFaker.getLocation());

        Assert.assertTrue(isLocation, "Location is not exist!");
    }

    @Test
    public void testLocationJSON() {
        Location location = Convertable.super.getObject(JsonObject.LOCATION.getPath(), Location.class);

        boolean isLocation =
                new LoginPage()
                        .loginIntoSystem()
                        .selectAdmin()
                        .addLocation(location)
                        .searchLocation(location)
                        .isLocationInList(location);

        Assert.assertTrue(isLocation, "Location from JSON is not exist!");
    }

    @Test
    public void testCandidateJSON() {
        Candidate candidate = Convertable.super.getObject(JsonObject.CANDIDATE.getPath(), Candidate.class);

        boolean isCandidate =
                new LoginPage()
                        .loginIntoSystem()
                        .selectRecruitment()
                        .addCandidate(candidate)
                        .switchToCandidate()
                        .searchCandidate(candidate)
                        .checkCandidate(candidate);

        Assert.assertTrue(isCandidate, "Candidate from JSON is not found");
    }

    @Test
    public void testVacancyJSON() {
        Vacancy vacancy = Convertable.super.getObject(JsonObject.VACANCY.getPath(), Vacancy.class);

        boolean isCandidate =
                new LoginPage()
                        .loginIntoSystem()
                        .selectRecruitment()
                        .switchToVacancy()
                        .addVacancy(vacancy)
                        //.searchVacancy(vacancy)
                        .checkVacancy(vacancy);

        Assert.assertTrue(isCandidate, "Vacancy from JSON is not found");
    }
}
