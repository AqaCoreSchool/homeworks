package orangetest.tests;

import orangetest.pages.CandidatesPage;
import orangetest.utils.Application;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AddCandidateTest extends BaseTest {
    private CandidatesPage candidatesPage;

    @Test
    public void addCandidateTest() {
        candidatesPage = new CandidatesPage();
        Assert.assertTrue(candidatesPage
                .addCandidate()
                .checkAddedCandidate());
    }
}
