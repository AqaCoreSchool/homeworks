package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.model.Vacancy;
import selenium.page.CreateVacancyPage;

public class NegativeVacancyCreationTest extends BaseTest {
    @Test
    public void negativeVacancyTest() {
        Vacancy vacancy = new Vacancy();
        CreateVacancyPage page = getLoginPage()
                .fillUsername(getCredentials().getUserLoginName())
                .fillPassword(getCredentials().getUserPassword())
                .clickLoginButton()
                .moveToRecruitmentItem()
                .clickVacanciesButton()
                .clickNewVacancyButton()
                .fillJobTitle("")
                .fillVacancyName(vacancy.getVacancyName())
                .fillHiringManager(vacancy.getHiringManager())
                .fillPositionsNo(vacancy.getNoOfPositions())
                .fillDescription(vacancy.getDescription())
                .setJobStatus()
                .setPublishedInFeedStatus()
                .saveVacancy();

        Assert.fail("Check required fields! Fields message: \n" + page.getValidationMessage());
    }
}
