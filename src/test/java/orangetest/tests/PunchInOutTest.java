package orangetest.tests;

import orangetest.pages.AttendancePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PunchInOutTest extends BaseTest {
    private static final String NOTE_IN = "I am a good worker :-)";
    private static final String NOTE_OUT = "I am already finished my work :-)";
    private AttendancePage attendancePage;

    @Test
    public void punchInOutTest() {
        attendancePage = new AttendancePage();
        Assert.assertTrue(attendancePage.punchInOut(NOTE_IN)
                .punchInOut(NOTE_OUT)
                .checkRecord());
    }
}
