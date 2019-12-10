package ua.testbiz.page;

import data.Candidate;
import data.Location;
import data.UserInformation;
import data.Vacancy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationTest extends BaseTest {

    @org.testng.annotations.Test
    public void CandidateAutomationTest() {
        Candidate candidate = new Candidate();
        candidate.setCandidateInfo();

        boolean isCandidate =
                new LoginPage()
                        .loginIntoSystem()
                        .selectRecruitment()
                        .switchToCandidate()
                        .addCandidate(candidate)
                        .switchToCandidate()
                        .searchCandidate(candidate)
                        .isCandidateInList(candidate);

        Assert.assertTrue(isCandidate, "Candidate is not found");
    }

    @org.testng.annotations.Test()
    public void ProfileAutomationTest() {
        UserInformation userInformation = new UserInformation();
        userInformation.setUserInformation();

        boolean isEmployee =
                new LoginPage()
                        .loginIntoSystem()
                        .selectMyInfo()
                        .setPersonalDetail(userInformation)
                        .selectPim()
                        .isEmployeeInList(userInformation);

        Assert.assertTrue(isEmployee, "Candidate is not found");
    }

    @org.testng.annotations.Test()
    public void VacancyAutomationTest() {
        Vacancy vacancy = new Vacancy();

        boolean isVacancy =
                new LoginPage()
                        .loginIntoSystem()
                        .selectRecruitment()
                        .switchToVacancy()
                        .addVacancy(vacancy)
                        .switchToVacancy()
                        .searchVacancy(vacancy)
                        .isVacancyInList(vacancy);

        Assert.assertTrue(isVacancy, "Vacancy is not found!");
    }

    @Test
    public void locationAutomationTest() {
        Location location = new Location();
        location.setLocation();

        boolean isLocation =
                new LoginPage()
                        .loginIntoSystem()
                        .selectAdmin()
                        .addLocation(location)
                        .searchLocation(location)
                        .isLocationInList(location);

        Assert.assertTrue(isLocation, "Location is not exist!");
    }
}
