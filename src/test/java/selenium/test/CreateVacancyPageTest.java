package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.model.Vacancy;
import selenium.page.CreateVacancyPage;

public class CreateVacancyPageTest extends BaseTest {
    @Test
    public void createVacancyTest() {
        Vacancy vacancy = new Vacancy();
        CreateVacancyPage page = getLoginPage()
                .fillUsername(getUser().getUserLoginName())
                .fillPassword(getUser().getUserPassword())
                .clickLoginButton()
                .moveToRecruitmentItem()
                .clickVacanciesButton()
                .clickNewVacancyButton()
                .fillJobTitle(vacancy.getJobTitle())
                .fillVacancyName(vacancy.getVacancyName())
                .fillHiringManager(vacancy.getHiringManager())
                .fillPositionsNo(vacancy.getNoOfPositions())
                .fillDescription(vacancy.getDescription())
                .setJobStatus()
                .setPublishedInFeedStatus()
                .saveVacancy();

        if (page.checkValidation()) {
            String successMessage = page.getSuccessMessage();
            Assert.assertEquals(successMessage, "Successfully Saved\nClose");
        } else {
            Assert.fail("Check required fields! Fields message: \n" + page.getValidationMessage());
        }
    }
}
