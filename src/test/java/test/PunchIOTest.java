package test;

import testpackage.base.BaseTest;
import testpackage.pages.LoginPage;
import testpackage.pages.MyRecordsPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PunchIOTest extends BaseTest {

    @Test
    public void punchInOutTest(){
        LoginPage loginPage = new LoginPage();
        loginPage
                .loginToTheSystem("TestUser03","Vfylhfujhf!1")
                .moveToTime()
                .moveToAttendance()
                .clickPunchInOut()
                .punchIn()
                .punchOut()
                .moveToTime()
                .moveToAttendance()
                .clickMyRecords()
                .goToDate("29");
        assertThat(new MyRecordsPage().filterTable()).isTrue();
    }

}
