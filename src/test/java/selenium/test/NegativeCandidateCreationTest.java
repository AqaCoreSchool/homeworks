package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.model.Candidate;
import selenium.page.CreateCandidatePage;

public class NegativeCandidateCreationTest extends BaseTest {

    @Test
    public void negativeCandidateCreationTest() {
        Candidate candidate = new Candidate();
        CreateCandidatePage page = getLoginPage()
                .fillUsername(getCredentials().getUserLoginName())
                .fillPassword(getCredentials().getUserPassword())
                .clickLoginButton()
                .moveToRecruitmentItem()
                .clickCandidateListButton()
                .clickNewCandidateButton()
                .fillFirstName("")
                .fillLastName(candidate.getCandidateLastName())
                .fillEmail("==@gmail.com 12##")
                .fillContactNo(candidate.getCandidateContactNo())
                .selectVacancy(candidate.getCandidateVacancy())
                .fillDate(candidate.getCandidateAppliedDate())
                .btnSaveClick();

        Assert.fail("Check required fields! Fields message: \n" + page.getValidationMessage());
    }
}
