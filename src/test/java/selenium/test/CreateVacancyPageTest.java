package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.data.UserData;
import selenium.data.VacancyData;
import selenium.page.CreateVacancyPage;

public class CreateVacancyPageTest extends BaseTest {
    @Test
    public void createVacancyTest() {
        CreateVacancyPage page = getLoginPage()
                .fillUsername(UserData.USER_LOGIN_NAME)
                .fillPassword(UserData.USER_PASSWORD)
                .clickLoginButton()
                .moveToRecruitmentItem()
                .clickVacanciesButton()
                .clickNewVacancyButton()
                .fillJobTitle(VacancyData.JOB_TITLE)
                .fillVacancyName(VacancyData.VACANCY_NAME)
                .fillHiringManager(VacancyData.HIRING_MANAGER)
                .fillPositionsNo(VacancyData.POSITIONS_NUMBER)
                .fillDescription(VacancyData.DESCRIPTION)
                .setJobStatus()
                .setPublishedInFeedStatus()
                .saveVacancy();

        String successMessage = page.getSuccessMessage();
        Assert.assertEquals(successMessage, "Successfully Saved\nClose");
    }
}
