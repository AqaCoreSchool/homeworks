package test;

import data.CandidateData;
import pages.OrangeRecruitmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApplyCandidateTest extends BaseTest{
    private String todayDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    private String futureDate = LocalDateTime.now().plusDays(2).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    private CandidateData candidate = new CandidateData("Test vacancy", "Nazariy Kushnir", todayDate);
    private CandidateData candidateFuture = new CandidateData("Test vacancy", "Nazariy Kushnir", futureDate);

    @Test(priority = 1)
    public void applyCandidateToVacancy(){
        OrangeRecruitmentPage recruitmentPage = openLoginPage()
                .loginCorrect(USERNAME, PASSWORD)
                .toRecruitmentModulePage()
                .toCandidates()
                .applyCandidate(candidate);
        recruitmentPage.clickBackBtn();
        Assert.assertTrue(recruitmentPage.findCreatedCandidate(candidate), "Created candidate not found!");

    }

    @Test(priority = 2)
    public void applyCandidateForFuture(){
        OrangeRecruitmentPage recruitmentPage = openLoginPage()
                .loginCorrect(USERNAME, PASSWORD)
                .toRecruitmentModulePage()
                .toCandidates()
                .applyCandidate(candidateFuture);
        Assert.assertTrue( recruitmentPage.futureDateErrorDisplayed(), "Error notification not displayed");

    }
}