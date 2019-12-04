package testpackage.test;

import org.testng.annotations.Test;
import testpackage.base.BaseTest;
import testpackage.entity.Candidate;
import testpackage.factory.CandidateFactory;
import testpackage.pages.CandidatesPage;
import testpackage.pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class AddCandidatesTest extends BaseTest {

    private String login = "TestUser03";
    private String password = "Vfylhfujhf!1";

    @Test
    public void candidatesAddTest(){
        Candidate candidate = new CandidateFactory().defaultCandidate();
    LoginPage loginPage = new LoginPage();
        loginPage
                .loginToTheSystem(login,password)
                .moveToCandidates()
                .createdCandidate(candidate)
                .moveToCandidates();
        assertThat(new CandidatesPage().filterCandidates(candidate)).isTrue();
    }
}
