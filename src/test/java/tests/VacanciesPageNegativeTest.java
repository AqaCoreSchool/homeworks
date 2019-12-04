package tests;

import data.UserInfo;
import data.VacancyInfo;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VacanciesPage;


public class VacanciesPageNegativeTest extends BaseTest {

    @Test
    public void testNegativeVacanciesPage() {
        VacanciesPage vacanciesPage = loginPage
                .loginIntoSite(UserInfo.LOGIN, UserInfo.PASSWORD)
                .moveToVacanciesPage()
                .addVacancyForNegativeTest(VacancyInfo.VACANCY, "Marty Stu");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(vacanciesPage.isTitleNotSelectedErrorDisplayed(),
                "Validation error isn't displayed. Title was selected");
        softAssert.assertTrue(vacanciesPage.isVacancyExistsErrorDisplayed(),
                "Validation error isn't displayed. Vacancy wasn't exists");
        softAssert.assertTrue(vacanciesPage.isManagerInputErrorDisplayed(),
                "Validation error isn't displayed. Manager's name input was correct");
        softAssert.assertAll();
    }
}
