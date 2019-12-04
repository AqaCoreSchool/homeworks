package tests;

import data.UserInfo;
import data.VacancyInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.VacanciesPage;

import static org.assertj.core.api.Assertions.assertThat;


public class VacanciesPageNegativeTest extends BaseTest {

    @Test
    public void testNegativeVacanciesPage() {
        loginPage
                .loginIntoSite(UserInfo.LOGIN, UserInfo.PASSWORD)
                .moveToVacanciesPage()
                .addVacancyForNegativeTest(VacancyInfo.VACANCY, "Marty Stew");

        Assert.assertTrue(new VacanciesPage().isTitleNotSelectedErrorDisplayed(),
                "Validation error not displayed. That was the correct input");
        Assert.assertTrue(new VacanciesPage().isVacancyExistsErrorDisplayed(),
                "Validation error not displayed. That was the correct input");
        Assert.assertTrue(new VacanciesPage().isManagerInputErrorDisplayed(),
                "Validation error not displayed. That was the correct input");
    }
}
