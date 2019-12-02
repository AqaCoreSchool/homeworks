package pageobject.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.logic.LoginPage;
import pageobject.logic.VacanciesPage;

import static org.assertj.core.api.Assertions.*;

public class VacanciesPageTest extends BaseTest {

    private LoginPage loginPage;
    private static final String JOB_TITLE = "AQA";
    private static final String VACANCY = "Senior";
    private static final String HIRING_MANAGER = "Andrii Shtyiuk";
    private static final String STATUS = "Active";

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
                .selectJobTittle(JOB_TITLE)
                .vacancyNameInput(VACANCY)
                .hiringManagerInput(HIRING_MANAGER)
                .clickSaveBtn()
                .clickBackBtn();

        assertThat(new VacanciesPage(driver).findVacancies(VACANCY, JOB_TITLE, HIRING_MANAGER, STATUS)).isNotEmpty();
    }

    @AfterTest(alwaysRun = true)
    public void shutDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
