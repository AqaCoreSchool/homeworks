package tests;

import data.UserInfo;
import data.VacancyInfo;
import org.testng.annotations.Test;
import pages.CandidatesPage;
import static org.assertj.core.api.Assertions.*;


public class CandidatesPageTest extends BaseTest {

    @Test
    public void testCandidatesPage(){
        loginPage
                .loginIntoSite(UserInfo.LOGIN, UserInfo.PASSWORD)
                .clickRecruitmentBtn()
                .clickCandidatesBtn()
                .clickAddCandidate()
                .fullNameInput(UserInfo.NAME,UserInfo.LASTNAME)
                .emailInput(UserInfo.EMAIL)
                .phoneNumberInput(UserInfo.PHONE_NUMBER)
                .selectJobVacancy()
                .clickConsentAndSave()
                .clickBackBtn();

        assertThat(new CandidatesPage(driver).findCandidate(UserInfo.NAME, UserInfo.LASTNAME, VacancyInfo.VACANCY))
                .as("String should contain desired vacancy and candidate's name").isNotEmpty();
    }


}
