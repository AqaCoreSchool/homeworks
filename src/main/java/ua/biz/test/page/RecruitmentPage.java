package ua.biz.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.biz.test.pojo.JobVacancy;
import ua.biz.test.util.LocalDriver;

import java.util.List;

public class RecruitmentPage {

    @FindBy(xpath = "//a[@id='menu_recruitment_viewJobVacancy']")
    private WebElement vacancySubOption;

    @FindBy(xpath = "//table[@id='resultTable']//tr[@class='odd' or @class='even']")
    private List<WebElement> candidateTable;

    private WebDriverWait wait;

    public RecruitmentPage() {
        PageFactory.initElements(LocalDriver.getDriver(), this);
        wait = new WebDriverWait(LocalDriver.getDriver(), 15);
    }

    public RecruitmentPage switchToVacancy() {
        vacancySubOption.click();
        return this;
    }

    public boolean isVacancyInList(String name, String lastName, List<JobVacancy> vacancies) {
        int counter = 0;
        for (WebElement element : candidateTable) {
            List<WebElement> vacanciesList = element.findElements(By.tagName("a"));
            List<WebElement> managers = element.findElements(By.xpath("//td[4]"));

            for (int i = 0; i < managers.size(); i++) {
                for (int j = 0; j < vacancies.size(); j++) {
                    if (vacanciesList.get(0).getText().equals(vacancies.get(j).getName())
                            && managers.get(i).getText().equals(name + " " + lastName)) {
                        counter++;
                    }
                }
            }
        }
        return (counter / 2 == vacancies.size());
    }
}
