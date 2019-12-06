package orangetest.tests;

import orangetest.pages.CandidatesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckCandidateJsonTest extends BaseTest {

    private CandidatesPage candidatesPage;

    @Test
    public void checkCandidateJsonTest() {
        candidatesPage = new CandidatesPage();
        Assert.assertTrue(candidatesPage.checkFromJSON());
    }
}
