package ua.testbiz.page;

import org.testng.Assert;

public class VacancyAutomationTest extends BaseTest {

    @org.testng.annotations.Test
    public void checkVacancy() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

        loginPage.loginIntoSystem();
        Assert.assertTrue(homePage.isOpened(), "Not a home page");

        homePage.selectRecruitment();

        recruitmentPage.switchToVacancy();

        recruitmentPage.addVacancy();

        recruitmentPage.switchToVacancy();

        Assert.assertNotNull(recruitmentPage.checkVacancy(), "Vacancy is not found!");
    }
}
