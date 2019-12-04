package test;

import data.UserData;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.OrangeAdminPage;
import pages.OrangeDashboardPage;
import pages.OrangeLoginPage;
import pages.OrangeMyInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeUserDataTest extends BaseTest{
    UserData userData = new UserData();

    @Test
    public void changeUserDataAndCheckUsersTest(){
        OrangeLoginPage loginPage = openLoginPage();
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeMyInfoPage infoPage = dashboardPage.toMyInfoPage();
        infoPage.editUserData(userData);
        OrangeAdminPage adminPage = infoPage.toAdminPage();
        Assert.assertTrue(adminPage.findUser(USERNAME, userData),
                "User name and surname in list is different!");
    }
}
