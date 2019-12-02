package ua.biz.test.vacancy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ua.biz.test.BaseTest;
import ua.biz.test.entity.Vacancy;
import ua.biz.test.pages.CreateVacancyPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VacancyDataTest extends BaseTest {

    private Vacancy testVacancy = new Vacancy("Manager", "Ivan Mosiychuk", 2, true);

    @Test
    public void testDataVacancy() {
        CreateVacancyPage createVacancyPage = mainPage.openVacanciesListPage(driver).addNewVacancy(driver);
        createVacancyPage.createNewVacancy(testVacancy);
        createVacancyPage.backToVacanciesPage(driver);

        List<WebElement> vacanciesDataList = driver.findElements(By.
                xpath("//table[@id='resultTable']//tbody//tr[@class='odd' or @class='even']"));

        for (WebElement element : vacanciesDataList) {
            List<WebElement> vacanciesData = element.findElements(By.tagName("td"));
            if (vacanciesData.get(1).getText().equals(testVacancy.getName()) &
                    vacanciesData.get(3).getText().equals(testVacancy.getHiringManagerName()) &
                    vacanciesData.get(4).getText().equals("Active")) {
                Assert.assertTrue(true);
            }
        }
    }
}
