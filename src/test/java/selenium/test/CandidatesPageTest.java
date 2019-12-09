package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.page.CandidatesPage;

public class CandidatesPageTest extends BaseTest {
    @Test
    public void candidatesPageTest() {
        CandidatesPage page = getLoginPage()
                .fillUsername(getCredentials().getUserLoginName())
                .fillPassword(getCredentials().getUserPassword())
                .clickLoginButton()
                .moveToRecruitmentItem()
                .clickCandidateListButton();

        boolean isCreated = page.isCreated(getUser().getUserLastName(), getVacancy().getVacancyName());
        Assert.assertTrue(isCreated, "Candidate is not created.");
    }
}
