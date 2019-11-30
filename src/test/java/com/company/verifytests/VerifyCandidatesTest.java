package com.company.verifytests;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyCandidatesTest extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);

    LocalDate date = LocalDate.now();
    DateTimeFormatter format =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formatDate = date.format(format);

    @Test
    public void testVerifyCandidates() {
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser07", "Vfylhfujhf!1");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainMenuPage mainPage = new MainMenuPage(driver);

        mainPage.moveToRecruitment()
                .moveToCandidate();
        CandidatesPage candidatesPage = new CandidatesPage(driver);
        candidatesPage.chooseJobTitle();
        candidatesPage.searchCandidates();
        candidatesPage.clickAddCandidate();
        candidatesPage.inputFirstName("Oleg");
        candidatesPage.inputLastName("Vlasenko");
        candidatesPage.inputEmail("vlasenko2007@gmail.com");
        candidatesPage.inputContactNo("0951124853");
        candidatesPage.chooseJobVacancy();
        candidatesPage.clickSaveBtn();
        candidatesPage.clickBackBtn();

        assertThat(candidatesPage.verifyCandidates("Oleg Vlasenko", formatDate)).isTrue();
    }
}
