package ua.testbiz.page;

import data.Candidate;
import org.testng.Assert;

public class CandidateAutomationTest extends BaseTest {

    @org.testng.annotations.Test
    public void addCandidate() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

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
}
