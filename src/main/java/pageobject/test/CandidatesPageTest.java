package pageobject.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.logic.CandidatesPage;
import pageobject.logic.LoginPage;
import static org.assertj.core.api.Assertions.*;


public class CandidatesPageTest extends BaseTest {

    private LoginPage loginPage;
    private static final String NAME = "Andrii";
    private static final String LAST_NAME = "Shtyiuk";
    private static final String EMAIL = "andriy.shtyiuk@gmail.com";
    private static final String PHONE_NUMBER = "+380686478967";
    private static final String VACANCY = "AQA Junior";


    @BeforeTest
    public void beforeTest(){
        loginPage = openLoginPage();
    }

    @Test
    public void testCandidatesPage(){
        loginPage
                .loginIntoSite()
                .clickRecruitmentBtn()
                .clickCandidatesBtn()
                .clickAddCandidate()
                .fullNameInput(NAME,LAST_NAME)
                .emailInput(EMAIL)
                .phoneNumberInput(PHONE_NUMBER)
                .selectJobVacancy()
                .clickConsentAndSave()
                .clickBackBtn();

        assertThat(new CandidatesPage(driver).findCandidate(NAME, LAST_NAME, VACANCY)).isNotEmpty();
    }

    @AfterTest(alwaysRun = true)
    public void shutDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
