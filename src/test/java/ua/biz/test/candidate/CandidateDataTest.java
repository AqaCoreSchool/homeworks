package ua.biz.test.candidate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.biz.test.BaseTest;
import ua.biz.test.entity.Candidate;
import ua.biz.test.pages.CreateCandidatePage;

import java.util.List;

public class CandidateDataTest extends BaseTest {

    private final Candidate TEST_CANDIDATE =
            new Candidate("Ivan", "Mosiychuk", "MWIvanko@gmail.com");

    @Test
    public void testCandidateData() {
        CreateCandidatePage createCandidatePage = mainPage.openCandidatesListPage(driver).addNewCandidate(driver);
        createCandidatePage.saveNewCandidate(TEST_CANDIDATE);
        createCandidatePage.backToCandidatesListPage(driver);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> candidatesData = driver.findElements(By.
                xpath("//table[@id='resultTable']//tbody//tr[@class='odd' or @class='even']"));
        System.out.println(candidatesData.size());
        for (WebElement candidateData : candidatesData) {
            List<WebElement> data = candidateData.findElements(By.tagName("td"));
            System.out.println(data.size() + "   " + data.get(2).getText());
            if (data.get(1).getText().equals(TEST_CANDIDATE.getVacancy().getName()) &
                    data.get(2).getText().contains(TEST_CANDIDATE.getFirstName()) &
                    data.get(2).getText().contains(TEST_CANDIDATE.getLastName()) &
                    data.get(3).getText().contains(TEST_CANDIDATE.getVacancy().getHiringManagerName())) {
                Assert.assertTrue(true);
            }
        }

    }

}
