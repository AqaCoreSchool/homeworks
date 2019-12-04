package orangetest.tests;

import orangetest.pages.CandidatesPage;
import orangetest.pages.VacanciesPage;
import orangetest.utils.Application;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AddEmptyCandidateTest extends BaseTest {
    private CandidatesPage candidatesPage;

    @Test
    public void addEmptyCandidateTest() {
        candidatesPage = new CandidatesPage();
        Assert.assertTrue(candidatesPage.addEmptyCandidate(), "Should be 3 error messages");
    }
}
