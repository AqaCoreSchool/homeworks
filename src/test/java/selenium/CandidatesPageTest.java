package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.data.UserData;
import selenium.data.VacancyData;
import selenium.page.CandidatesPage;

public class CandidatesPageTest extends BaseTest {
    @Test
    public void candidatesPageTest() {
        CandidatesPage page = getLoginPage()
                .fillUsername(UserData.USER_LOGIN_NAME)
                .fillPassword(UserData.USER_PASSWORD)
                .clickLoginButton()
                .moveToRecruitmentItem()
                .clickCandidateListButton()
                .checkCandidate(VacancyData.VACANCY_NAME, UserData.USER_NAME);

        boolean isCreated = page.isCreated();
        Assert.assertTrue(isCreated);
    }
}
