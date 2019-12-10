package ua.testbiz.page;

import data.Vacancy;
import org.testng.Assert;

public class VacancyAutomationTest extends BaseTest {

    @org.testng.annotations.Test
    public void checkVacancy() {
        Vacancy vacancy = new Vacancy();
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage
                        .loginIntoSystem()
                        .selectRecruitment()
                        .switchToVacancy()
                        .addRecord()
                        .addVacancy(vacancy)
                        .saveRecord()
                        .switchToVacancy()
                        .checkVacancy(vacancy),
                "Vacancy is not found!");
    }
}
