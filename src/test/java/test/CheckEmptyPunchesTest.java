package test;

import data.PunchData;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.OrangeDashboardPage;
import pages.OrangeLoginPage;
import pages.OrangeTimePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckEmptyPunchesTest extends BaseTest{
    private PunchData punch = new PunchData();


    @Test
    public void recordsTableIsEmptyTest(){
        OrangeLoginPage loginPage = openLoginPage();
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeTimePage timePage = dashboardPage.toTimeModulePage();
        timePage.checkEmptyRecordsTable(punch.getWeekAfter());
        Assert.assertTrue(timePage.getEmptyRecord().isDisplayed(), "Record table isn't empty!");
    }
}
