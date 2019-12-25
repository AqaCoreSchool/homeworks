package orangetest.tests;

import pages.AttendancePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PunchInOutTest extends BaseTest {
    private static final String NOTE_IN = "I am a good worker :-)";
    private static final String NOTE_OUT = "I am already finished my work :-)";
    private AttendancePage attendancePage;

    @Test
    public void punchInOutTest() {
        attendancePage = new AttendancePage(driver);
        attendancePage.punchInOut(NOTE_IN);
        attendancePage.punchInOut(NOTE_OUT);
        boolean stringSearch = attendancePage.isRecordAdded();
        Assert.assertTrue(stringSearch, "Punch In/Out record with added parameters has not been found");
    }
}
