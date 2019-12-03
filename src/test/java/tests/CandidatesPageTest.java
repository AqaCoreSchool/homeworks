package tests;

import data.UserInfo;
import data.VacancyInfo;
import org.testng.annotations.Test;
import pages.CandidatesPage;
import static org.assertj.core.api.Assertions.*;


public class CandidatesPageTest extends BaseTest {
    UserInfo userInfo = new UserInfo();

    @Test
    public void testCandidatesPage(){
        loginPage
                .loginIntoSite(UserInfo.LOGIN, UserInfo.PASSWORD)
                .clickRecruitmentBtn()
                .clickCandidatesBtn()
                .clickAddCandidate()
                .fullNameInput(userInfo.firstName,UserInfo.LASTNAME)
                .emailInput(UserInfo.EMAIL)
                .phoneNumberInput(UserInfo.PHONE_NUMBER)
                .selectJobVacancy()
                .clickConsentAndSave()
                .clickBackBtn();

        assertThat(new CandidatesPage().findCandidate(userInfo.firstName, UserInfo.LASTNAME, VacancyInfo.VACANCY))
                .as("String should contain desired vacancy and candidate's name").isNotEmpty();
    }


}
