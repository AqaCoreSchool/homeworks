package testpackage.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import testpackage.base.BaseTest;
import testpackage.pages.LoginPage;
import testpackage.pages.MyRecordsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class PunchIOWithStarTest extends BaseTest {

    @Test
    public void punchInOutTestWithStar(){
        MyRecordsPage myRecordsPage = new LoginPage()
                .loginToTheSystem("TestUser03","Vfylhfujhf!1")
                .clickMyRecords()
                .goToDateWithMonth("20","Nov");
        assertThat(myRecordsPage.getMessagesNoAttendance()).isTrue();
               myRecordsPage.goToDateWithMonth("4","Dec");
        assertThat(myRecordsPage.getMessagesNoAttendance()).isTrue();

    }
}
