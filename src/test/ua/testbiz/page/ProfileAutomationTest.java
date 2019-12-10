package ua.testbiz.page;

import data.UserInformation;
import org.testng.Assert;

public class ProfileAutomationTest extends BaseTest {

    @org.testng.annotations.Test
    public void setProfile() {
        UserInformation userInformation = new UserInformation();
        LoginPage loginPage = new LoginPage(driver);


        Assert.assertTrue(
                loginPage
                        .loginIntoSystem()
                        .selectMyInfo()
                        .setPersonalDetail(userInformation)
                        .selectPim()
                        .checkEmployee(userInformation), "Employee was not found!");
    }
}
