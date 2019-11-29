package test;

import org.testng.annotations.Test;
import testpackage.pages.LoginPage;

public class PunchIOTestWithStar {

    @Test
    public void punchInOutTestWithStar(){
        LoginPage loginPage = new LoginPage();
        loginPage
                .openLoginPage()
                .loginToTheSystem("TestUser03","Vfylhfujhf!1")
                .moveToTime()
                .moveToAttendance()
                .clickMyRecords()
                .goToDateWithMonth("20","Nov")
                .verifyAttendance()
                .goToDateWithMonth("4","Dec")
                .verifyAttendance();

    }
}
