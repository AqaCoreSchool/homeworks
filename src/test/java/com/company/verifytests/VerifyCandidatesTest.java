package com.company.verifytests;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyCandidatesTest extends BaseTest {
    LoginPage loginPage;

    LocalDate date = LocalDate.now();
    DateTimeFormatter format =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formatDate = date.format(format);

    @Test
    public void testVerifyCandidates() {
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser07", "Vfylhfujhf!1");
        MainMenuPage mainPage = new MainMenuPage(driver);
        mainPage.moveToRecruitment()
                .moveToCandidate()
                .chooseJobTitle()
                .searchCandidates()
                .clickAddCandidate()
                .inputFirstName("Oleg")
                .inputLastName("Vlasenko")
                .inputEmail("vlasenko2007@gmail.com")
                .inputContactNo("0951124853")
                .chooseJobVacancy()
                .clickSaveBtn()
                .clickBackBtn();

        CandidatesPage candidatesPage = new CandidatesPage(driver);
        assertThat(candidatesPage.verifyCandidates("Oleg Vlasenko", formatDate)).isTrue();
    }
}
