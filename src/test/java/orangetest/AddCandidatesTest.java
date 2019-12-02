package orangetest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddCandidatesTest extends BaseTest {
    private CandidatesPage candidatesPage;
    private String candidateFirstName = "Mariana";
    private String candidateLastName = "Mykytovych";
    private String candidateMiddleName = "Romanivna";
    private String candidateEmail = "my_e-mail@gmail.com";

    @BeforeTest
    public void beforeClass() {
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser05", "Vfylhfujhf!1");
        candidatesPage = new CandidatesPage(driver);
    }


    @Test
    public void addCandidateTest() {
        candidatesPage.addCandidate(candidateFirstName, candidateLastName, candidateMiddleName, candidateEmail);
        boolean result = candidatesPage.checkAddedCandidate(candidateFirstName, candidateLastName);
        Assert.assertTrue(result);
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
