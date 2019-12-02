package ua.biz.test.vacancy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        Map<String, String> vacancyDate = getVacancyDate();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(vacancyDate.get("Hiring manager"), testVacancy.getHiringManagerName());

        if (testVacancy.isActive()) {
            softAssert.assertEquals(vacancyDate.get("Status"), "Active");
        } else {
            softAssert.assertEquals(vacancyDate.get("Status"), "Close");
        }
        softAssert.assertAll();
    }

    private Map<String, String> getVacancyDate() {
        Map<String, String> vacancyData = new HashMap<>();
        List<WebElement> vacanciesDataList = driver.findElements(By.
                xpath("//table[@id='resultTable']//tbody//tr[@class='odd' or @class='even']"));
        System.out.println(vacanciesDataList.size());
        //Зробити через Lambda
        for (WebElement element : vacanciesDataList) {
            List<WebElement> vacanciesData = element.findElements(By.tagName("td"));
            if (vacanciesData.get(1).getText().equals(testVacancy.getName())) {
                vacancyData.put("Hiring manager", vacanciesData.get(3).getText());
                vacancyData.put("Status", vacanciesData.get(4).getText());
            }
        }
        return vacancyData;
    }

}
