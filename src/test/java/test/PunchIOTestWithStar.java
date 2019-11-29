package test;

import org.testng.annotations.Test;
import testpackage.pages.LoginPage;

public class PunchIOTestWithStar {

    @Test
    public void punchInOutTestWithStar(){
        LoginPage
                .openLoginPage()
                .inputLogin("TestUser03")
                .inputPassword("Vfylhfujhf!1")
                .clickLogInButton()
                .moveToTime()
                .moveToAttendance()
                .clickMyRecords()
                .goToDateWithMonth("20","Nov")
                .verifyAttendance()
                .goToDateWithMonth("4","Dec")
                .verifyAttendance();

    }
}
