package ua.testbiz.page;

import data.DataFaker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationTest extends BaseTest {

    @org.testng.annotations.Test
    public void testCandidate() {
        DataFaker dataFaker = new DataFaker().setCandidate();

        boolean isCandidate =
                new LoginPage()
                        .loginIntoSystem()
                        .selectRecruitment()
                        .switchToCandidate()
                        .addCandidate(dataFaker.getCandidate())
                        .switchToCandidate()
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
                        .isLocationInList(dataFaker.getLocation());

        Assert.assertTrue(isLocation, "Location is not exist!");
    }
}
