package test;

import data.LocationData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.OrangeAdminPage;
import pages.OrangeDashboardPage;
import pages.OrangeLoginPage;

public class CreateLocationTest extends BaseTest{
    LocationData location = new LocationData();

    @Test(priority = 1)
    public void createVacancyTest(){
        OrangeLoginPage loginPage = openLoginPage();
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeAdminPage adminPage = dashboardPage.toAdminModulePage();
        adminPage.toOrganization().toLocations().createLocation(location);
        Assert.assertTrue(adminPage.findLocation(location), "Created location not found!");
    }
}
