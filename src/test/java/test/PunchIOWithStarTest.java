package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import testpackage.base.BaseTest;
import testpackage.pages.LoginPage;
import testpackage.pages.MyRecordsPage;

public class PunchIOWithStarTest extends BaseTest {

    @Test
    public void punchInOutTestWithStar(){
        LoginPage loginPage = new LoginPage();
        loginPage
                .loginToTheSystem("TestUser03","Vfylhfujhf!1")
                .moveToTime()
                .moveToAttendance()
                .clickMyRecords()
                .goToDateWithMonth("20","Nov");
        Assert.assertTrue(new MyRecordsPage().getMessagesNoAttendance().isDisplayed());
               new MyRecordsPage().goToDateWithMonth("4","Dec");
        Assert.assertTrue(new MyRecordsPage().getMessagesNoAttendance().isDisplayed());

    }
}
