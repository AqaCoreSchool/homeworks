package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.page.VacanciesPage;

public class VacanciesPageTest extends BaseTest {

    @Test
    public void vacanciesPageTest() {
        VacanciesPage page = getLoginPage()
                .fillUsername(getCredentials().getUserLoginName())
                .fillPassword(getCredentials().getUserPassword())
                .clickLoginButton()
                .moveToRecruitmentItem()
                .clickVacanciesButton();


        boolean isCreated = page.isVacancyCreated(getVacancy().getVacancyName(), getVacancy().getHiringManager());
        Assert.assertTrue(isCreated);
    }
}