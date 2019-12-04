package ua.testbiz.page;

import data.Candidate;
import data.Location;
import data.UserInformation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationTest extends BaseTest {

    @org.testng.annotations.Test
    public void CandidateAutomationTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        RecruitmentPage recruitmentPage = new RecruitmentPage();

        loginPage.loginIntoSystem();
        Assert.assertTrue(homePage.isOpened(), "Not a home page");

        homePage.selectRecruitment();

        recruitmentPage.switchToCandidate();

        Candidate candidate = new Candidate();
        candidate.setCandidateInfo();
        recruitmentPage.addCandidate(candidate);

        recruitmentPage.switchToCandidate();

        Assert.assertNotNull(recruitmentPage.checkCandidate(candidate), "Candidate is not found");
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

        UserInformation userInformation = new UserInformation();
        userInformation.setUserInformation();

        personalDetailsPage.setPersonalDetail(userInformation);

        homePage.selectPim();
        employeeListPage.checkEmployee(userInformation);
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

        recruitmentPage.addVacancy();

        recruitmentPage.switchToVacancy();

        Assert.assertNotNull(recruitmentPage.checkVacancy(), "Vacancy is not found!");
    }

    @Test
    public void locationAutomationTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        LocationPage locationPage = new LocationPage();

        loginPage.loginIntoSystem();
        Assert.assertTrue(homePage.isOpened(), "Not a home page");

        homePage.selectAdmin();

        Location location = new Location();
        location.setLocation();
        locationPage.addLocation(location);

        Assert.assertTrue(locationPage.isLocationInList(location), "Location is not exist!");
    }
}
