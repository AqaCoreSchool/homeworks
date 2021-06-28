package testpackage.test.uiTest.negetiveTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testpackage.pages.CandidatesPage;
import testpackage.pages.LoginPage;

public class CandidatesPageNegativeTest {
    private String login = "TestUser03";
    private String password = "Vfylhfujhf!1";

    @Test
    public void testNegativeCandidatesPage() {
        CandidatesPage candidatesPage = new LoginPage()
                .loginToTheSystem(login, password)
                .moveToCandidates()
                .addCandidateInfoForNegativeTest();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(candidatesPage.isCandidateNameErrorDisplayed(),
                "First name input was correct, error isn't displayed");
        softAssert.assertTrue(candidatesPage.isCandidateLastNameErrorDisplayed(),
                "Last name input was correct, error isn't displayed");
        softAssert.assertTrue(candidatesPage.isEmailFormatErrorDisplayed(),
                "Email input was correct, error isn't displayed");
        softAssert.assertTrue(candidatesPage.isPhoneFormatErrorDisplayed(),
                "Phone input was correct, error isn't displayed");
        softAssert.assertAll();
    }
}
