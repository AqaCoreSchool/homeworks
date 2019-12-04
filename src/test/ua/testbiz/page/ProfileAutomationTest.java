package ua.testbiz.page;

import data.UserInformation;
import org.testng.Assert;

public class ProfileAutomationTest extends BaseTest {

    @org.testng.annotations.Test
    public void setProfile() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(driver);
        EmployeeListPage employeeListPage = new EmployeeListPage(driver);

        loginPage.loginIntoSystem();
        Assert.assertTrue(homePage.isOpened(), "Not a home page");

        homePage.selectMyInfo();

        UserInformation userInformation = new UserInformation();
        userInformation.setUserInformation();
        personalDetailsPage.setPersonalDetail(userInformation);

        homePage.selectPim();
        employeeListPage.checkEmployee(userInformation);
    }
}
