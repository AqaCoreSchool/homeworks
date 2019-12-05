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
                .clickCandidateListButton()
                .checkCandidate(getUser().getUserLastName(), getVacancy().getVacancyName());

        boolean isCreated = page.isCreated();
        Assert.assertTrue(isCreated);
    }
}
