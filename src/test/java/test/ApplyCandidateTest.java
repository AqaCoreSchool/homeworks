package test;

import data.CandidateData;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.OrangeDashboardPage;
import pages.OrangeLoginPage;
import pages.OrangeRecruitmentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplyCandidateTest extends BaseTest{
    private CandidateData candidateData = new CandidateData("Test vacancy", "Nazariy Kushnir");

    @Test(priority = 1)
    public void applyCandidateToVacancy(){
        OrangeLoginPage loginPage = openLoginPage();
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeRecruitmentPage recruitmentPage = dashboardPage.toRecruitmentModulePage();
        recruitmentPage.toCandidates().applyCandidate(candidateData);
        recruitmentPage.clickBackBtn();
        Assert.assertTrue(recruitmentPage.findCreatedCandidate(candidateData), "Created candidate not found!");

    }

    @Test(priority = 2)
    public void applyCandidateForFuture(){
        OrangeLoginPage loginPage = openLoginPage();
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeRecruitmentPage recruitmentPage = dashboardPage.toRecruitmentModulePage();
        recruitmentPage.toCandidates().applyCandidateForFuture(candidateData);
        Assert.assertTrue( recruitmentPage.futureDateErrorDisplayed(), "Error notification not displayed");

    }
}