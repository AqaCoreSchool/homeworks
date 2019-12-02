package ua.biz.test.candidate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.biz.test.BaseTest;
import ua.biz.test.entity.Candidate;
import ua.biz.test.entity.Vacancy;
import ua.biz.test.pages.CreateCandidatePage;
import ua.biz.test.pages.CreateVacancyPage;

import java.util.List;

public class CandidateDataTest extends BaseTest {

    private final Vacancy TEST_VACANCY =
            new Vacancy("TEST_VACANCY_IMO","Ivan Mosiychuk",2,true);
    private final Candidate TEST_CANDIDATE =
            new Candidate("Ivan", "Mosiychuk", "MWIvanko@gmail.com", TEST_VACANCY);

    @Test
    public void testCandidateData() {

        CreateVacancyPage page = mainPage.openVacanciesListPage(driver).addNewVacancy(driver);
        page.createNewVacancy(TEST_VACANCY);

        CreateCandidatePage createCandidatePage = mainPage.openCandidatesListPage(driver).addNewCandidate(driver);
        createCandidatePage.saveNewCandidate(TEST_CANDIDATE);
        createCandidatePage.backToCandidatesListPage(driver);

        List<WebElement> candidatesData = driver.findElements(By.
                xpath("//table[@id='resultTable']//tbody//tr[@class='odd' or @class='even']"));

        for (WebElement candidateData : candidatesData) {
            List<WebElement> data = candidateData.findElements(By.tagName("td"));
            if (data.get(1).getText().equals(TEST_CANDIDATE.getVacancy().getName()) &&
                    data.get(2).getText().contains(TEST_CANDIDATE.getFullName()) &&
                    data.get(3).getText().contains(TEST_CANDIDATE.getVacancy().getHiringManagerName())) {
                Assert.assertTrue(true);
            }
        }
    }
}
