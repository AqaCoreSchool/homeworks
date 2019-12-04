package test;

import data.CandidateData;
import pages.OrangeRecruitmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplyCandidateTest extends BaseTest{
    private CandidateData candidateData = new CandidateData("Test vacancy", "Nazariy Kushnir");

    @Test(priority = 1)
    public void applyCandidateToVacancy(){
        OrangeRecruitmentPage recruitmentPage = openLoginPage()
                .loginCorrect(USERNAME, PASSWORD)
                .toRecruitmentModulePage()
                .toCandidates()
                .applyCandidate(candidateData);
        recruitmentPage.clickBackBtn();
        Assert.assertTrue(recruitmentPage.findCreatedCandidate(candidateData), "Created candidate not found!");

    }

    @Test(priority = 2)
    public void applyCandidateForFuture(){
        OrangeRecruitmentPage recruitmentPage = openLoginPage()
                .loginCorrect(USERNAME, PASSWORD)
                .toRecruitmentModulePage()
                .toCandidates()
                .applyCandidateForFuture(candidateData);
        Assert.assertTrue( recruitmentPage.futureDateErrorDisplayed(), "Error notification not displayed");

    }
}