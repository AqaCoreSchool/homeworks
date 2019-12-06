package com.company.vTests.tests;

import com.company.vTests.base.BaseTest;
import com.company.vTests.pages.CandidatesPage;
import com.company.vTests.pages.LoginPage;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NegativeCandidateTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void testNegativeCandidates() {
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser07", "Vfylhfujhf!1")
                .moveToRecruitment()
                .moveToCandidate()
                .clickAddCandidate()
                .clickSaveBtn();

        CandidatesPage candidatesPage = new CandidatesPage();
        assertThat(candidatesPage.verifyEmptyCandidates()).as("Candidates not empty").isTrue();
    }

}
