package com.company.verifytests;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInfoTest extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);
    LocalDate date = LocalDate.now();
    DateTimeFormatter format =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String currentDate = date.format(format);

    @Test
    public void testUserInfo(){
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser07","Vfylhfujhf!1");
        
        MainMenuPage mainPage = new MainMenuPage(driver);
        mainPage.clickMyInfo();
        MyInfoPage info = new MyInfoPage(driver);
        info.clickEditSave();
        info.inputFirstName("Olya");
        info.inputLastName("Bilynska");
        info.inputEmployeeId("1");
        info.inputOtherId("07");
        info.inputDriverNo("78956");
        info.chooseGender();
        info.chooseNationality();
        info.chooseMaritalStatus();
        info.inputDateOfBirth("2000-08-11");
        info.clickEditSave();
        mainPage.moveToTime()
                .moveToAttendance();
        mainPage.clickPunchInOut();
        PunchPage punchPage = new PunchPage(driver);
        punchPage.punchIn();
        punchPage.punchOut();

        mainPage.moveToTime();
        mainPage.moveToAttendance();
        EmployeeRecordsPage employeeRecords = new EmployeeRecordsPage(driver);
        employeeRecords.clickEmployeeRecords();
        employeeRecords.chooseDateOfRecords(currentDate);
        employeeRecords.clickViewBtn();
        assertThat(employeeRecords.verifyEmployeeRecords("Olya Bilynska", currentDate)).isTrue();
    }
}
