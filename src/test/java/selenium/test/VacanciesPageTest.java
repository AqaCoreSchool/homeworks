package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.data.UserData;
import selenium.data.VacancyData;
import selenium.page.VacanciesPage;

public class VacanciesPageTest extends BaseTest {

    @Test
    public void vacanciesPageTest() {
        VacanciesPage page = getLoginPage()
                .fillUsername(UserData.USER_LOGIN_NAME)
                .fillPassword(UserData.USER_PASSWORD)
                .clickLoginButton()
                .moveToRecruitmentItem()
                .clickVacanciesButton()
                .checkVacancy(VacancyData.VACANCY_NAME, VacancyData.HIRING_MANAGER);

        boolean isCreated = page.isCreated();
        Assert.assertTrue(isCreated);
    }
}
