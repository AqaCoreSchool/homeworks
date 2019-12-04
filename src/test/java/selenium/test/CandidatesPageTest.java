package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.page.CandidatesPage;

public class CandidatesPageTest extends BaseTest {
    @Test
    public void candidatesPageTest() {
        CandidatesPage page = getLoginPage()
                .fillUsername(getUser().getUserLoginName())
                .fillPassword(getUser().getUserPassword())
                .clickLoginButton()
                .moveToRecruitmentItem()
                .clickCandidateListButton()
                .checkCandidate(getUser().getUserLastName(), getVacancy().getVacancyName());

        boolean isCreated = page.isCreated();
        Assert.assertTrue(isCreated);
    }
}
