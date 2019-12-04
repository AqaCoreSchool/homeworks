package tests;

import data.UserInfo;
import data.VacancyInfo;
import org.testng.annotations.Test;
import pages.CandidatesPage;
import static org.assertj.core.api.Assertions.*;


public class CandidatesPageTest extends BaseTest {

    @Test
    public void testCandidatesPage(){
        CandidatesPage candidatesPage = loginPage
                .loginIntoSite(UserInfo.LOGIN, UserInfo.PASSWORD)
                .moveToCandidatesPage()
                .addCandidateInfo();

        assertThat(candidatesPage.findCandidate(UserInfo.FIRST_NAME, UserInfo.LAST_NAME, VacancyInfo.VACANCY))
                .as("String should contain desired vacancy and candidate's name").isNotEmpty();
    }


}
