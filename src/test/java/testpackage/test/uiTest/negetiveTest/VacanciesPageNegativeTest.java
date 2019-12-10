package testpackage.test.uiTest.negetiveTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testpackage.pages.LoginPage;
import testpackage.pages.VacanciesPage;

public class VacanciesPageNegativeTest {
    private String login = "TestUser03";
    private String password = "Vfylhfujhf!1";

    @Test
    public void vacanciesAddTest() {
        VacanciesPage vacanciesPage = new LoginPage()
                .loginToTheSystem(login, password)
                .moveToVacancies()
                .addVacancyForNegativeTest("Junior", "Marty Stu");

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
