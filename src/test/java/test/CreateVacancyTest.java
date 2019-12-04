package test;

import data.VacancyData;
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

public class CreateVacancyTest extends BaseTest{
    VacancyData vacancy = new VacancyData("Test vacancy", "Nazariy Kushnir");


    @Test(priority = 1)
    public void createVacancyTest(){
        OrangeLoginPage loginPage = openLoginPage();
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeRecruitmentPage recruitmentPage = dashboardPage.toRecruitmentModulePage();
        recruitmentPage.toVacancies().createVacancy(vacancy);
        recruitmentPage.clickBackBtn();
        Assert.assertTrue(recruitmentPage.findCreatedVacancy(vacancy), "Created vacancy not found!");
    }

    @Test(priority = 2)
    public void createIncorrectVacancyTest(){
        OrangeLoginPage loginPage = openLoginPage();
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeRecruitmentPage recruitmentPage = dashboardPage.toRecruitmentModulePage();
        recruitmentPage.toVacancies().createVacancyWithoutTitle(vacancy);
        Assert.assertTrue( recruitmentPage.noTitleErrorDisplayed(), "Error notification not displayed");
    }
}
