package ua.testbiz.page;

import data.Candidate;
import org.testng.Assert;

public class CandidateAutomationTest extends BaseTest {

    @org.testng.annotations.Test
    public void addCandidate() {
        Candidate candidate = new Candidate();

        Assert.assertTrue(
                new LoginPage(driver)
                        .loginIntoSystem()
                        .selectRecruitment()
                        .switchToCandidate()
                        .addRecord()
                        .addCandidate(candidate)
                        .saveRecord()
                        .switchToCandidate()
                        .checkCandidate(candidate),
                "Candidate is not found");
    }
}
