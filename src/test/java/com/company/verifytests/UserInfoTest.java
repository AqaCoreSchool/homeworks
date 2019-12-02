package com.company.verifytests;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInfoTest extends BaseTest {
    LoginPage loginPage;
    LocalDate date = LocalDate.now();
    DateTimeFormatter format =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String currentDate = date.format(format);

    @Test
    public void testUserInfo(){
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser07","Vfylhfujhf!1");
        MainMenuPage mainPage = new MainMenuPage(driver);
        mainPage.clickMyInfo()
                .clickEditSave()
                .inputFirstName("Olya")
                .inputLastName("Bilynska")
                .inputEmployeeId("1")
                .inputOtherId("07")
                .inputDriverNo("78956")
                .chooseGender()
                .chooseNationality()
                .chooseMaritalStatus()
                .inputDateOfBirth("2000-08-11")
                .clickEditSave();

        mainPage.moveToTime()
                .moveToAttendance()
                .clickPunchInOut()
                .punchIn()
                .punchOut();

        mainPage.moveToTime()
                .moveToAttendance();

        EmployeeRecordsPage employeeRecords = new EmployeeRecordsPage(driver);
        employeeRecords.clickEmployeeRecords()
                .chooseDateOfRecords(currentDate)
                .clickViewBtn();
        assertThat(employeeRecords.verifyEmployeeRecords("Olya Bilynska", currentDate)).isTrue();
    }
}
