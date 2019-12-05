package tests;

import data.UserInfo;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.EmployeeListPage;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.*;


public class EditUserInfoTest extends BaseTest{

    @Test
    public void  testEditUser() {
        EmployeeListPage employeeListPage = loginPage
                .loginIntoSite(UserInfo.LOGIN, UserInfo.PASSWORD)
                .moveToMyInfoPage()
                .editInfo()
                .moveToEmployeeListPage();

        assertThat(employeeListPage.findEmployeeInfo(UserInfo.FIRST_NAME, UserInfo.LAST_NAME, UserInfo.ID))
                .as("String should contain employee's name and id").isNotEmpty();
    }
}
