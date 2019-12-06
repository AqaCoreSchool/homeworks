package ua.testbiz.page;

import data.DataFaker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationTest extends BaseTest {
    private String jsonLocation = "{\"locationName\":\"AMark & Spencer\",\"locationPostalCode\":\"11450-3689\",\"locationAddress\":\"013 Stephani Cliffs\",\"locationState\":\"Ohio\",\"locationCity\":\"Cleveland\",\"locationCountryIndex\":0}";

    @org.testng.annotations.Test
    public void CandidateAutomationTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        RecruitmentPage recruitmentPage = new RecruitmentPage();

        loginPage.loginIntoSystem();
        Assert.assertTrue(homePage.isOpened(), "Not a home page");

        homePage.selectRecruitment();

        recruitmentPage.switchToCandidate();

        DataFaker dataFaker = new DataFaker();
        dataFaker.setCandidate();
        recruitmentPage.addCandidate(dataFaker.getCandidate());

        recruitmentPage.switchToCandidate();
        recruitmentPage.searchCandidateByJSON();
        Assert.assertNotNull(recruitmentPage.checkCandidate(dataFaker.getCandidate()), "Candidate is not found");
    }

    @org.testng.annotations.Test()
    public void ProfileAutomationTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        EmployeeListPage employeeListPage = new EmployeeListPage();

        loginPage.loginIntoSystem();
        Assert.assertTrue(homePage.isOpened(), "Not a home page");

        homePage.selectMyInfo();

        DataFaker dataFaker = new DataFaker();
        dataFaker.setUserInformation();
        personalDetailsPage.setPersonalDetail(dataFaker.getUserInformation());

        homePage.selectPim();
        employeeListPage.checkEmployee(dataFaker.getUserInformation());
    }

    @org.testng.annotations.Test()
    public void VacancyAutomationTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        RecruitmentPage recruitmentPage = new RecruitmentPage();

        loginPage.loginIntoSystem();
        Assert.assertTrue(homePage.isOpened(), "Not a home page");

        homePage.selectRecruitment();

        recruitmentPage.switchToVacancy();

        DataFaker dataFaker = new DataFaker();
        dataFaker.setVacancy();
        recruitmentPage.addVacancy(dataFaker.getVacancy());

        recruitmentPage.switchToVacancy();
        recruitmentPage.searchVacancy(dataFaker.getVacancy());
        Assert.assertNotNull(recruitmentPage.checkVacancy(dataFaker.getVacancy()), "Vacancy is not found!");
    }

    @Test
    public void locationAutomationTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        LocationPage locationPage = new LocationPage();

        loginPage.loginIntoSystem();
        Assert.assertTrue(homePage.isOpened(), "Not a home page");

        homePage.selectAdmin();

        DataFaker dataFaker = new DataFaker();
        dataFaker.setLocation();

        locationPage.addLocation(dataFaker.getLocation());

        locationPage.searchLocationByJSON();
        Assert.assertTrue(locationPage.isLocationInList(dataFaker.getLocation()), "Location is not exist!");
    }
}
