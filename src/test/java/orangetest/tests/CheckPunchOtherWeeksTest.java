package orangetest.tests;

import orangetest.pages.AttendancePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class CheckPunchOtherWeeksTest extends BaseTest {
    private AttendancePage attendancePage;
    private LocalDate date = LocalDate.now();

    @Test(priority = 1)
    public void checkPreviousWeek() {
        attendancePage = new AttendancePage();
        String previousWeekDate = date.minusWeeks(2).toString();
        boolean stringSearch = attendancePage.checkPreviousOrNextWeek(previousWeekDate);
        Assert.assertTrue(stringSearch);
    }

    @Test(priority = 2)
    public void checkNextWeek() {
        String nextWeekDate = date.plusDays(7).toString();
        boolean stringSearch = attendancePage.checkPreviousOrNextWeek(nextWeekDate);
        Assert.assertTrue(stringSearch);
    }
}
