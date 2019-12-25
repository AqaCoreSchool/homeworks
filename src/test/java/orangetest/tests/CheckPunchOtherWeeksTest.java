package orangetest.tests;

import pages.AttendancePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class CheckPunchOtherWeeksTest extends BaseTest {
    private AttendancePage attendancePage;
    private LocalDate date = LocalDate.now();

    @Test(priority = 1)
    public void checkPreviousWeek() {
        attendancePage = new AttendancePage(driver);
        String previousWeekDate = date.minusDays(7).toString();
        boolean stringSearch = attendancePage.isPrevOrNextWeekWithoutRecords(previousWeekDate);
        Assert.assertTrue(stringSearch, "Punch In/Out records table is not empty for this date");
    }

    @Test(priority = 2)
    public void checkNextWeek() {
        String nextWeekDate = date.plusDays(7).toString();
        boolean stringSearch = attendancePage.isPrevOrNextWeekWithoutRecords(nextWeekDate);
        Assert.assertTrue(stringSearch, "Punch In/Out records table is not empty for this date");
    }
}
