package tests;

import data.Candidate;
import data.LoginInfo;
import org.testng.annotations.Test;
import pages.CandidatesPage;
import static org.assertj.core.api.Assertions.*;


public class CandidatesPageTest extends BaseTest {

    @Test
    public void testCandidatesPage(){
        Candidate candidate = new Candidate();
        CandidatesPage candidatesPage = loginPage
                .loginIntoSite(LoginInfo.LOGIN, LoginInfo.PASSWORD)
                .moveToCandidatesPage()
                .addCandidateInfo(candidate);

        assertThat(candidatesPage.findCandidate(candidate))
                .as("String should contain desired vacancy and candidate's name").isNotEmpty();
    }


}
