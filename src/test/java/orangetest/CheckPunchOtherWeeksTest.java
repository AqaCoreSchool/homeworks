package orangetest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class CheckPunchOtherWeeksTest extends BaseTest {
    private HomePage homePage;
    private LocalDate date = LocalDate.now();

    @Test(priority = 1)
    public void checkPreviousWeek() {
        homePage = new HomePage(driver);
        String previousWeekDate = date.minusDays(7).toString();
        boolean stringSearch = homePage.isPrevOrNextWeekWithoutRecords(previousWeekDate);
        Assert.assertTrue(stringSearch);
    }

    @Test(priority = 2)
    public void checkNextWeek() {
        String nextWeekDate = date.plusDays(7).toString();
        boolean stringSearch = homePage.isPrevOrNextWeekWithoutRecords(nextWeekDate);
        Assert.assertTrue(stringSearch);
    }
}
