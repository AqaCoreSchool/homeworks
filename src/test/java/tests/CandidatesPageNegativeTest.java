package tests;

import data.UserInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CandidatesPage;

public class CandidatesPageNegativeTest extends BaseTest {

    @Test
    public void testNegativeCandidatesPage() {
        loginPage
                .loginIntoSite(UserInfo.LOGIN, UserInfo.PASSWORD)
                .moveToCandidatesPage()
                .addCandidateInfoForNegativeTest();


        Assert.assertTrue(new CandidatesPage().isCandidateNameErrorDisplayed(),
                "Input was correct, error not Displayed");
        Assert.assertTrue(new CandidatesPage().isCandidateLastNameErrorDisplayed(),
                "Input was correct, error not Displayed");
        Assert.assertTrue(new CandidatesPage().isEmailFormatErrorDisplayed(),
                "Input was correct, error not Displayed");
        Assert.assertTrue(new CandidatesPage().isPhoneFormatErrorDisplayed(),
                "Input was correct, error not Displayed");
    }
}
