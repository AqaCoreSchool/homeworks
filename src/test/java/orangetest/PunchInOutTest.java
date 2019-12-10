package orangetest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PunchInOutTest extends BaseTest {
    private static final String NOTE_IN = "I am a good worker :-)";
    private static final String NOTE_OUT = "I am already finished my work :-)";
    private HomePage homePage;

    @Test
    public void punchInOutTest() {
        homePage = new HomePage(driver);
        homePage.punchInOut(NOTE_IN);
        homePage.punchInOut(NOTE_OUT);
        boolean stringSearch = homePage.isRecordAdded();
        Assert.assertTrue(stringSearch);
    }
}
