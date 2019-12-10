package orangetest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCandidatesTest extends BaseTest {
    private CandidatesPage candidatesPage;
    private String candidateFirstName = "Mariana";
    private String candidateLastName = "Mykytovych";
    private String candidateMiddleName = "Romanivna";
    private String candidateEmail = "my_e-mail@gmail.com";

    @Test
    public void addCandidateTest() {
        candidatesPage = new CandidatesPage(driver);
        candidatesPage.addCandidate(candidateFirstName, candidateLastName, candidateMiddleName, candidateEmail);
        boolean result = candidatesPage.isCandidateAdded(candidateFirstName, candidateLastName);
        Assert.assertTrue(result);
    }
}
