package com.company.verifytests;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class VerifyVacancyTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void testVerifyCandidates() {
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser07", "Vfylhfujhf!1");
        MainMenuPage mainPage = new MainMenuPage(driver);
        mainPage.moveToRecruitment()
                .moveToVacancy()
                .chooseJobTitleOfVacancy()
                .clickSearchBtn()
                .addVacancy()
                .chooseJobTitle()
                .inputVacancyName("AQA Senior")
                .inputHiringManagerName("Olya Bilynska")
                .inputNumberOfPositions("1")
                .clickSaveBtn()
                .clickBackBtn();

        VacancyPage vacancyPage = new VacancyPage(driver);
        assertThat(vacancyPage.verifyVacancy("AQA", "Olya Bilynska")).isTrue();

    }
}
