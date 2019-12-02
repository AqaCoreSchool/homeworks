package pageobject.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.logic.LoginPage;
import pageobject.logic.VacanciesPage;

import static org.assertj.core.api.Assertions.*;

public class VacanciesPageTest extends BaseTest {

    private LoginPage loginPage;
    private static final String jobTitle = "AQA";
    private static final String vacancy = "Senior";
    private static final String hiringManager = "Andrii Shtyiuk";
    private static final String status = "Active";

    @BeforeTest
    public void beforeTest() {
        loginPage = openLoginPage();
    }

    @Test
    public void testCandidatesPage() {
        loginPage
                .loginIntoSite()
                .clickRecruitmentBtn()
                .clickVacanciesBtn()
                .clickAddBtn()
                .selectJobTittle(jobTitle)
                .vacancyNameInput(vacancy)
                .hiringManagerInput(hiringManager)
                .clickSaveBtn()
                .clickBackBtn();

        assertThat(new VacanciesPage(driver).findVacancies(vacancy, jobTitle, hiringManager, status)).isNotEmpty();
    }

    @AfterTest(alwaysRun = true)
    public void shutDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
