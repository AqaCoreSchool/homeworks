package com.company.vTests.tests;

import com.company.vTests.base.BaseTest;
import com.company.vTests.pages.LoginPage;
import com.company.vTests.pages.VacancyPage;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NegativeVacancyTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void testNegativeCandidates() {
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser07", "Vfylhfujhf!1")
                .moveToRecruitment()
                .moveToVacancy()
                .chooseJobTitleOfVacancy()
                .clickSearchBtn()
                .addVacancy()
                .clickSaveBtn();

        VacancyPage vacancyPage = new VacancyPage();
        assertThat(vacancyPage.verifyEmptyVacancy()).as("Vacancy not empty").isTrue();
    }

}