package pageobject.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.logic.EmployeeListPage;
import pageobject.logic.LoginPage;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

public class EditUserInfoTest extends BaseTest{
    private LoginPage loginPage;
    private static final String NAME = "Andrii";
    private static final String LAST_NAME = "Shtyiuk";
    private static final String ID = "02";

    @BeforeTest
    public void beforeTest(){
        loginPage = openLoginPage();
    }

    @Test
    public void  testEditUser() {
        loginPage
                .loginIntoSite()
                .clickMyInfoBtn()
                .clickEditOrSave()
                .clickfirstNameInput(NAME)
                .clicklastNameInput(LAST_NAME)
                .clickIdInput("02")
                .clickGenderMale()
                .clickMaritalStatus()
                .clickNationalityUkrainian()
                .clickinputDateOfBirth(LocalDate.of(1987,11,23).toString())
                .clickEditOrSave()
                .clickPimBtn()
                .clickEmployeeListBtn();

        assertThat(new EmployeeListPage(driver).findEmployeeInfo(NAME,LAST_NAME,ID)).isNotEmpty();
    }


    @AfterTest(alwaysRun = true)
    public void shutDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
