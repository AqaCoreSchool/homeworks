package orangetest.tests;

import orangetest.data.Candidate;
import orangetest.pages.CandidatesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCandidateTest extends BaseTest {
    private CandidatesPage candidatesPage;

    @Test
    public void addCandidateTest() {
        candidatesPage = new CandidatesPage();
        Candidate candidate = new Candidate();
        Assert.assertTrue(candidatesPage
                        .addCandidate(candidate.getCandidateFirstName(),
                                    candidate.getCandidateLastName(),
                                    candidate.getCandidateMiddleName(),
                                    candidate.getCandidateEmail())
                        .isCandidateAdded(candidate.getCandidateFirstName(),
                                    candidate.getCandidateLastName(),
                                    candidate.getCandidateMiddleName()),
                "Candidate with such parameters has not been found");
    }
}
