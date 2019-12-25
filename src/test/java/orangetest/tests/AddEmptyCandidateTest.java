package orangetest.tests;

import orangetest.pages.CandidatesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEmptyCandidateTest extends BaseTest {
    private CandidatesPage candidatesPage;

    @Test
    public void addEmptyCandidateTest() {
        candidatesPage = new CandidatesPage();
        Assert.assertTrue(candidatesPage.isEmptyCandidateAdded(), "Should be 3 error messages");
    }
}
