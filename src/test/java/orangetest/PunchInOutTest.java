package orangetest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PunchInOutTest extends BaseTest {
    private static final String NOTE_IN = "I am a good worker :-)";
    private static final String NOTE_OUT = "I am already finished my work :-)";
    private HomePage homePage;

    @BeforeTest
    public void beforeClass() {
        LoginPage loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser05", "Vfylhfujhf!1");
        homePage = new HomePage(driver);
    }

    @Test
    public void punchInOutTest() {
        homePage.punchInOut(NOTE_IN);
        homePage.punchInOut(NOTE_OUT);
        boolean stringSearch = homePage.checkRecord();
        Assert.assertTrue(stringSearch);
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
