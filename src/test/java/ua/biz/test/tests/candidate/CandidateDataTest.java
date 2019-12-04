package ua.biz.test.tests.candidate;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ua.biz.test.base.BaseTest;
import ua.biz.test.entity.Candidate;
import ua.biz.test.entity.Vacancy;
import ua.biz.test.pages.CandidatesListPage;
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

        CreateVacancyPage page = mainPage.openVacanciesListPage().addNewVacancy();
        page.createNewVacancy(TEST_VACANCY);

        CreateCandidatePage createCandidatePage = mainPage.openCandidatesListPage().addNewCandidate();
        createCandidatePage.saveNewCandidate(TEST_CANDIDATE);
        CandidatesListPage candidatesListPage =createCandidatePage.backToCandidatesListPage();

        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(candidatesListPage.isCandidatesPresent(TEST_CANDIDATE),"Not found a candidate with this data");
    }
}
