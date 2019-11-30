package com.company.verifytests;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class VerifyVacancyTest extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void testVerifyCandidates() {
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser07", "Vfylhfujhf!1");
        MainMenuPage mainPage = new MainMenuPage(driver);
        mainPage.moveToRecruitment()
                .moveToVacancy();
        VacancyPage vacancyPage = new VacancyPage(driver);
        vacancyPage.chooseJobTitleOfVacancy();
        vacancyPage.clickSearchBtn();
        vacancyPage.addVacancy();
        vacancyPage.chooseJobTitle();
        vacancyPage.inputVacancyName("AQA Senior");
        vacancyPage.inputHiringManagerName("Olya Bilynska");
        vacancyPage.inputNumberOfPositions("1");
        vacancyPage.clickSaveBtn();
        vacancyPage.clickBackBtn();

        assertThat(vacancyPage.verifyVacancy("AQA", "Olya Bilynska")).isTrue();

    }
}
