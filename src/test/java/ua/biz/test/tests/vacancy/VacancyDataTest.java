package ua.biz.test.tests.vacancy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.biz.test.base.BaseTest;
import ua.biz.test.entity.Vacancy;
import ua.biz.test.pages.CreateVacancyPage;
import ua.biz.test.pages.VacanciesListPage;

import java.util.List;

public class VacancyDataTest extends BaseTest {

    private Vacancy TEST_VACANCY = new Vacancy(faker.name()+"Manager", "Ivan Mosiychuk", 2, true);

    private CreateVacancyPage createVacancyPage;

    @BeforeMethod
    public void prepareVacancyTest(){
        createVacancyPage= mainPage.openVacanciesListPage().addNewVacancy();
    }

    @Test
    public void testDataVacancy() {
        createVacancyPage.createNewVacancy(TEST_VACANCY);
        VacanciesListPage vacanciesListPage = createVacancyPage.backToVacanciesPage();
        Assert.assertTrue(vacanciesListPage.isVacancyPresent(TEST_VACANCY),
                "Not found a vacancy with this data");
    }

    @Test
    public void testIncorrectDataVacancy() {
        TEST_VACANCY.setName(faker.name()+"Tester");
        createVacancyPage.createNewVacancy(TEST_VACANCY);
        VacanciesListPage vacanciesListPage =createVacancyPage.backToVacanciesPage();
        vacanciesListPage.addNewVacancy().createNewVacancy(TEST_VACANCY);
        Assert.assertTrue(createVacancyPage.isIncorrectVacancyNameMessageVisible(),
                "The message must be visible after type this data");
    }
}
