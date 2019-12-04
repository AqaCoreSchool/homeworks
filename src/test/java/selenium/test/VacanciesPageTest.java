package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.page.VacanciesPage;

public class VacanciesPageTest extends BaseTest {

    @Test
    public void vacanciesPageTest() {
        VacanciesPage page = getLoginPage()
                .fillUsername(getUser().getUserLoginName())
                .fillPassword(getUser().getUserPassword())
                .clickLoginButton()
                .moveToRecruitmentItem()
                .clickVacanciesButton()
                .checkVacancy(getVacancy().getVacancyName(), getVacancy().getHiringManager());

        boolean isCreated = page.isCreated();
        Assert.assertTrue(isCreated);
    }
}
