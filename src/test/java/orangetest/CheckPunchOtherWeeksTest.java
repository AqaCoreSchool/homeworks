package orangetest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class CheckPunchOtherWeeksTest extends BaseTest {
    private HomePage homePage;
    private LocalDate date = LocalDate.now();

    @BeforeClass
    public void beforeClass() {
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser05", "Vfylhfujhf!1");
        homePage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void checkPreviousWeek() {
        String previousWeekDate = date.minusDays(7).toString();
        boolean stringSearch = homePage.checkPreviousOrNextWeek(previousWeekDate);
        Assert.assertTrue(stringSearch);
    }

    @Test(priority = 2)
    public void checkNextWeek() {
        String nextWeekDate = date.plusDays(7).toString();
        boolean stringSearch = homePage.checkPreviousOrNextWeek(nextWeekDate);
        Assert.assertTrue(stringSearch);
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
