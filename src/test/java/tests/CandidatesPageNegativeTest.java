package tests;

import data.LoginInfo;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CandidatesPage;

public class CandidatesPageNegativeTest extends BaseTest {

    @Test
    public void testNegativeCandidatesPage() {
        CandidatesPage candidatesPage = loginPage
                .loginIntoSite(LoginInfo.LOGIN, LoginInfo.PASSWORD)
                .moveToCandidatesPage()
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
