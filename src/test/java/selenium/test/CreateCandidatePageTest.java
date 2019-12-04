package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.driver.Driver;
import selenium.model.Candidate;
import selenium.page.CreateCandidatePage;

public class CreateCandidatePageTest extends BaseTest {
    @Test
    public void createCandidateTest() {
        Candidate candidate = new Candidate();
        CreateCandidatePage page = getLoginPage()
                .fillUsername(getUser().getUserLoginName())
                .fillPassword(getUser().getUserPassword())
                .clickLoginButton()
                .moveToRecruitmentItem()
                .clickCandidateListButton()
                .clickNewCandidateButton()
                .fillFirstName(candidate.getCandidateFirstName())
                .fillLastName(candidate.getCandidateLastName())
                .fillEmail(candidate.getCandidateEmail())
                .fillContactNo(candidate.getCandidateContactNo())
                .selectVacancy(candidate.getCandidateVacancy())
                .fillDate(candidate.getCandidateAppliedDate())
                .btnSaveClick();


        if (page.checkValidation()) {
            String successMessage = page.getSuccessMessage();
            Assert.assertEquals(successMessage, "Successfully Saved\nClose");
        } else {
            Assert.fail("Check required fields! Fields message: \n" + page.getValidationMessage());
        }
    }
}
